from dataclasses import dataclass, field
from typing import TypeVar, NamedTuple, Optional, Generic, Callable, Generator
from copy import deepcopy


class SourceLocation(NamedTuple):
    line: int
    "Line number, beginning at 1"
    column: int
    "Column number, beginning at 1. E.g. the first character on the line is at column 1."


class SourceLocationSpan(NamedTuple):
    start: SourceLocation
    end: SourceLocation

    def does_contain(self, loc: SourceLocation):
        """
        Checks whether the given 'loc' location is contained within this span.
        E.g. if this span represents ((5,1), (10, 1)), i.e lines 5 to 10 and loc is (6, 1), the location is contained
        :param loc:
        :return:
        """

        if loc.line < self.start.line or loc.line > self.end.line:
            # outside the line range
            return False

        # below: the location is in the line range

        before_start, after_end = loc.column < self.start.column, loc.column > self.end.column
        on_start_line, on_end_line = loc.line == self.start.line, loc.line == self.end.line

        if on_start_line and on_end_line:
            # i.e. start and end line are the same, check within column range
            return not (before_start or after_end)
        elif on_start_line:
            # on the start line (not on the end line, end line != start line), check after the start col
            return not before_start
        elif on_end_line:
            # above but for end line
            return not after_end
        else:
            # start and end lines are not the same and the loc is somewhere between, but not on the start or end lines
            return True


__REASON_CHILD__ = '__child__'
__FIELD_PARENT__ = 'parent'
__REASON_INIT__ = '__init__'


def NodeDataclass(cls, *args, **kwargs):
    """
    AST node decorator to add an updatable and cachable element based hash to the dataclass
    """

    # Add a hash based on the elements that make up this node. This is required because dataclass doesn't generate a
    # hash for us unless we pass in unsafe_hash=True on the decorator for every node subclass and even if we do that
    # it can't hash lists. Since get_all_children returns a generator of nodes (i.e. no lists), we can hash it as a
    # tuple, i.e. a "snapshot hash"
    def compute_node_hash(self):
        return hash(tuple(self.get_all_children()))

    def __hash__(self):
        if not self._cached_hash:
            # this hash can be computed many times if the dataclass field that made this instance dirty is not a real
            # child, i.e. doesn't get returned in get_children() because its not a Node(e.g. the field is a List[str])
            # For now just allow this because we'd have to recurse on the object to see if it really makes a difference
            # to the hash, and it's not worth it
            self._cached_hash = self.compute_node_hash()
        return self._cached_hash

    actual_dataclass = dataclass(cls, *args, **kwargs)

    actual_init = actual_dataclass.__init__
    actual_setattr = actual_dataclass.__setattr__

    def __setattr__(self, name, value):
        # wrap lists as they are mutable in our own list type that can notify when elements are changed
        # since NodeList is also a list, this will take the existing nodelist and wrap it
        if isinstance(value, list):
            value = NodeList(self, value)

        actual_setattr(self, name, value)
        # if this attribute was declared as a dataclass field, the state of this node is dirty as the
        # contents changed
        if name in actual_dataclass.__dataclass_fields__:
            self._set_dirty(name, value)

    def _set_dirty(self, name, value):
        # in the case of lists, name can be an int or slice

        # a node is considered hash dirty if its direct children or grandchildren attributes are changed
        #  - if the parent of a node is changed, the node does not become hash dirty
        # __FIELD_PARENT__ is triggered when the parent is changed
        # __REASON_CHILD__ is not a real attribute, it's triggered to alert the parent of this node that the child was
        #                  made hash dirty(e.g. because of a grandchild becoming hash dirty)
        # final case is for real attributes in this node that were just changed
        if name != __FIELD_PARENT__ or name == __REASON_CHILD__:
            # print("HashDirty: " + str(id(self))[9:] +"  because of " + str(name))
            self._cached_hash = None
        if self.parent:
            # parent is recursively dirty
            self.parent._set_dirty(__REASON_CHILD__, self)

    def __init__(self, *args, **kwargs):
        actual_init(self, *args, **kwargs)
        self._cached_hash = None

    actual_dataclass.__hash__ = __hash__
    actual_dataclass.compute_node_hash = compute_node_hash
    actual_dataclass.__setattr__ = __setattr__
    actual_dataclass.__init__ = __init__
    actual_dataclass._set_dirty = _set_dirty

    return actual_dataclass


T = TypeVar('T')


@NodeDataclass
class NodeList(list[T]):
    # Note: this class is marked as a NodeDataclass and has _set_dirty defined by the decorator. Ignore IDE warnings
    def __init__(self, parent: T, seq=()):
        super().__init__(seq)
        self.parent = parent

    def __str__(self):
        return list.__str__(self)

    def __repr__(self):
        return list.__repr__(self)

    def __setitem__(self, key, value):
        # seems to get called with slices too, that's why __setslice__ is stubbed with TODO
        super().__setitem__(key, value)
        self._set_dirty(key, value)

    def __delitem__(self, key):
        super().__delitem__(key)
        self._set_dirty(key, None)

    def __setslice__(self, i, j, sequence):
        raise NotImplemented

    def __eq__(self, other):
        if isinstance(other, list):
            return super().__eq__(other)
        raise NotImplemented

    def append(self, __object):
        ret = super().append(__object)
        self._set_dirty('__append__', __object)
        return ret

    def clear(self):
        ret = super().clear()
        self._set_dirty('__clear__', None)
        return ret

    def extend(self, __iterable):
        ret = super().extend(__iterable)
        self._set_dirty('__extend__', None)
        return ret

    def insert(self, __index, __object):
        ret = super().insert(__index, __object)
        self._set_dirty('__insert__', __object)
        return ret

    def pop(self, __index):
        ret = super().pop(__index)
        self._set_dirty('__pop__', None)
        return ret

    def remove(self, __value):
        ret = super().remove(__value)
        self._set_dirty('__remove__', None)
        return ret

    def reverse(self):
        ret = super().reverse()
        self._set_dirty('__reverse__', None)
        return ret

    def sort(self, *args, **kwargs):
        ret = super().sort(*args, **kwargs)
        self._set_dirty('__sort__', None)
        return ret


@dataclass
class Ref(Generic[T]):
    """
    A weak AST reference to another Node. This is needed when we want to associate a Node with another Node but don't
    want it to be marked as a child of the other Node. This is useful if we want to create circular or back references
    to help the client use the AST more naturally, e.g. ResolvedUserTypes have a reference to the actual TopLevelUnit
    they reference.
    """

    x: T
    "The item being referenced"

    def __repr__(self):
        # this is needed for snapshot testing, GenericRepr uses repr to built the snapshot
        ref_target = '?'
        if hasattr(self.x, 'descriptor'):
            ref_target = self.x.descriptor()
        else:
            par = self.x.parent
            if hasattr(self.x, 'name'):
                par_d = ''
                if hasattr(par, 'descriptor'):
                    par_d = par.descriptor() + '.'
                elif hasattr(par, 'name'):
                    par_d = par.name + '.'
                ref_target = f'{par_d}{self.x.name}'

        return f'<REF({ref_target})>'


@NodeDataclass
class Node:
    """
    Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
    clients can traverse all child and parent nodes.
    """

    id_location: str = field(init=False, repr=False, hash=False, compare=False, default=None)
    "LineNumber:LinePosition, this is set dynamically in common.make"
    start_location: SourceLocation = field(init=False, repr=False, hash=False, compare=False, default=None)
    "Source start location of this node (column is inclusive)"
    end_location: SourceLocation = field(init=False, repr=False, hash=False, compare=False, default=None)
    "Source end location of this node (column is exclusive)"
    start_buffer_index: int = field(init=False, repr=False, hash=False, compare=False, default=-1)
    "Source start (0-based) position in the input text buffer(inclusive)"
    end_buffer_index: int = field(init=False, repr=False, hash=False, compare=False, default=-1)
    "Source end (0-based) position in the input text buffer(exclusive)"

    parent: Optional['Node'] = field(init=False, repr=False, hash=False, compare=False, default=None)
    comments: Optional[list[str]] = field(init=False, repr=False, hash=False, compare=False, default_factory=list)

    def __post_init__(self):
        self._set_child_parents()

    def get_source_span(self):
        return SourceLocationSpan(self.start_location, self.end_location)

    def linenumber(self) -> int:
        return int(self.id_location.split(":")[0])

    def source_location(self):
        if hasattr(self, 'scope') and self.scope:
            from solidity_parser.ast.symtab import FileScope
            file_scope = self.scope.find_first_ancestor_of(FileScope)
            file_name = file_scope.source_unit_name
        else:
            file_name = '<unknown>'
        return f'{file_name} @{self.id_location}'

    def offset(self) -> int:
        return int(self.id_location.split(":")[1])

    def get_children(self, predicate: Callable[['Node'], bool] = None) -> Generator['Node', None, None]:
        if not predicate:
            predicate = lambda _: True
        # get the dataclass fields instead of vars() here: two benefits:
        #  we loop fewer times as there are less things
        #  we include only the explicit fields of each dataclass so won't pick up accidental recursions
        for k, dfield in self.__dataclass_fields__.items():
            if dfield.hash:
                continue

            val = getattr(self, k)
            # Don't include parent or Refs
            #  or NodeLists (done implicitly by generator)
            if val is self.parent:
                continue

            if isinstance(val, Node) and predicate(val):
                yield val
            elif isinstance(val, (list, tuple)):
                yield from [v for v in val if isinstance(v, Node) and predicate(v)]

    def get_all_children(self, predicate: Callable[['Node'], bool] = None) -> Generator['Node', None, None]:
        for direct_child in self.get_children():
            if not predicate or predicate(direct_child):
                yield direct_child
            yield from direct_child.get_all_children(predicate)

    def _set_child_parents(self):
        for child in self.get_children():
            child.parent = self

    def __deepcopy__(self, memodict):
        new_fields = {}
        for name, dfield in self.__dataclass_fields__.items():
            if name == 'parent':
                # don't climb up the tree/copy the parent
                continue
            # just confirm it needs to be passed to the constructor
            if not dfield.init:
                continue

            current_value = getattr(self, name)
            if isinstance(current_value, (Node, list, tuple)) and not isinstance(current_value, Ref):
                new_fields[name] = deepcopy(current_value, memodict)
            else:
                # copy stuff like str, int
                new_fields[name] = current_value
        klass = self.__class__
        # create the copy by instantiating it like a normal Node, i.e. the parent of the children are set here
        new_obj = klass(**new_fields)
        return new_obj

    def code_str(self):
        raise NotImplementedError()

