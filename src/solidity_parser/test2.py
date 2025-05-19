import dataclasses

from solidity_parser.ast import types

__TYPE_CHECK_FUNCS__ = [name for name, value in vars(types.Type).items() if callable(value) and name.startswith('is')] + ['can_implicitly_cast_from', '']
@dataclasses.dataclass
class NamedType(types.Type):
    name: str
    ttype: types.Type

    def __str__(self):
        return f'{self.name}: {self.ttype}'

    def code_str(self):
        raise ValueError('NamedType is not printable')

    def type_key(self, name_resolver=None, *args, **kwargs):
        # chatGPT says not to include the name as part of the type itself
        return self.ttype.type_key(name_resolver, *args, **kwargs)

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        return self.ttype.can_implicitly_cast_from(actual_type)

    def __getattribute__(self, name):
        print(name)
        if name.startswith('is_') and hasattr(self.ttype, name) and callable(getattr(self.ttype, name)):
            return getattr(self.ttype, name)
        else:
            return super().__getattribute__(name)

if __name__ == '__main__':
    # type_funcs = [name for name, value in vars(types.Type).items() if callable(value) and not name.startswith('_')]
    # print(type_funcs)
    t = NamedType('', types.IntType(is_signed=False, size=8))
    print([f for f in t.__dataclass_fields__])
    x = t.is_int()
    print(x)

