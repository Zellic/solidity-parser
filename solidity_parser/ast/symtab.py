
from solidity_parser.ast import solnodes


class Scopeable():
    def __init__(self, parent_scopes=None):
        if parent_scopes is None:
            parent_scopes = []
        self.parent_scopes = parent_scopes

    def set_defined_in(self, parent_scope):
        if parent_scope not in self.parent_scopes:
            self.parent_scopes.append(parent_scope)


class Symbol(Scopeable):
    def __init__(self, aliases, value):
        Scopeable.__init__(self)

        # make it into a list if it's not
        if aliases is None:
            aliases = []
        elif not isinstance(aliases, list):
            aliases = [aliases]

        self.aliases = aliases
        self.value = value
        self.order = -1

    def set_defined_in(self, parent_scope):
        """Set's the scope info for this symbol and returns the aliases that the parent should set aliases for"""
        Scopeable.set_defined_in(self, parent_scope)
        self.order = len(parent_scope.symbols)
        return self.aliases

    def __str__(self, level=0):
        return f"Symbol: {self.aliases} @{type(self.value).__name__}"


class Scope(Scopeable):
    def __init__(self, scope_name=None):
        Scopeable.__init__(self)
        self.scope_name = scope_name
        self.symbols = {}
        self.enclosed_scopes = {}

    def set_defined_in(self, parent_scope):
        Scopeable.set_defined_in(self, parent_scope)
        return [self.scope_name]

    def is_defined(self, name):
        return name in self.symbols or name in self.enclosed_scopes

    def add(self, args):
        if not args:
            return
        if isinstance(args, list):
            for a in args:
                if a:
                    self._add(a)
        else:
            self._add(args)

    def _add(self, scope_or_symbol):
        aliases = scope_or_symbol.set_defined_in(self)

        for name in aliases:
            if self.is_defined(name):
                raise KeyError(f"{name} already exists in scope: {self.scope_name}")

        if isinstance(scope_or_symbol, Symbol):
            for name in aliases:
                self.symbols[name] = scope_or_symbol

        if isinstance(scope_or_symbol, Scope):
            for name in aliases:
                self.enclosed_scopes[name] = scope_or_symbol

    def find(self, name):
        if name in self.symbols:
            return self.symbols[name]

        for parent in self.parent_scopes:
            symbol = parent.find(name)
            if symbol:
                return symbol

        return None

    def str__symbols(self, level=0):
        indent = '  '*level
        indent1 = '  ' + indent

        all_syms = set(self.symbols.values()) | set(self.enclosed_scopes.values())

        if all_syms:
            nl_indent = '\n' + indent1
            strs = [sym.__str__(level=level+1) for sym in all_syms]
            symbol_str = nl_indent + nl_indent.join(strs)
        else:
            symbol_str = ''

        return symbol_str

    def __str__(self, level=0):
        return f"Scope: {self.scope_name}" + self.str__symbols(level)


class ScopeAndSymbol(Scope, Symbol):
    def __init__(self, name, ast_node):
        Scope.__init__(self, name)
        Symbol.__init__(self, name, ast_node)

    def __str__(self, level=0):
        # if the scope alias is the same as the symbol aliases then just use the scope alias, else dump all of them
        if len(self.aliases) == 1 and self.aliases[0] == self.scope_name:
            name = self.scope_name
        else:
            name = f"{self.scope_name}/{self.aliases}"

        return f"Scope/Symbol: {name} @{type(self.value).__name__}" + Scope.str__symbols(self, level)


class ImportSymbol(Symbol):
    def __init__(self, ast_node):
        # ast_node.aliases here is essentially [(symbol=X,alias=Y)]
        # take all the Y's and put them as this ImportSymbol Symbol.aliases but we need
        # the X's if Y is looked up to find X
        aliases = [symbol_alias.alias.text for symbol_alias in ast_node.aliases]
        Symbol.__init__(self, aliases, ast_node)

    # def __str__(self, level=0):
    #     return Symbol.__str__(self) + '#' + str(self.value.line_no)


class Builder:

    def __init__(self):
        self.root_scope = Scope('<root>')
        self.nodes_to_scope = {}

    def add_to_scope(self, scope, symbol_to_add):
        scope.add(symbol_to_add)

        if isinstance(symbol_to_add, Symbol):
            node = symbol_to_add.value
            if node:
                current_scope = scope
                if isinstance(symbol_to_add, Scope):
                    current_scope = symbol_to_add

                node.scope = current_scope
                # self.nodes_to_scope[node] = scope

    def process_file(self, file_name, source_units):
        file_scope = Scope(f"<file>@{file_name}")

        for node in source_units:
            self.add_to_scope(file_scope, self.process_node(node))

        self.add_to_scope(self.root_scope, file_scope)

    def process_node(self, node):
        if isinstance(node, solnodes.SymbolImportDirective):
            return ImportSymbol(node)
        if isinstance(node, solnodes.ContractDefinition):
            # contract defines a new scope
            contract_scope = ScopeAndSymbol(node.name.text, node)
            self.process_all(contract_scope, node.parts)
            return contract_scope
        elif isinstance(node, solnodes.StructDefinition):
            struct_scope = ScopeAndSymbol(node.name.text, node)
            self.process_all(struct_scope, node.members)
            return struct_scope
        elif isinstance(node, solnodes.StructMember):
            return Symbol(node.name.text, node)
        elif isinstance(node, solnodes.StateVariableDeclaration):
            return Symbol(node.name.text, node)
        elif isinstance(node, solnodes.ModifierDefinition):
            modifier_scope = ScopeAndSymbol(node.name.text, node)
            code_scope = self.process_stmt(node.code, name=f"{modifier_scope.scope_name}::code")
            self.add_to_scope(modifier_scope, code_scope)
            return modifier_scope
        elif isinstance(node, solnodes.FunctionDefinition):
            function_scope = ScopeAndSymbol(str(node.name), node)
            self.process_all(function_scope, node.args)
            code_scope = self.process_stmt(node.code, name=f"{function_scope.scope_name}::code")
            self.add_to_scope(function_scope, code_scope)
            return function_scope
        elif isinstance(node, solnodes.Parameter):
            return Symbol(str(node.var_name), node)
        elif isinstance(node, solnodes.Stmt):
            return self.process_stmt(node)
        else:
            return None

    def process_stmt(self, stmt, name=None):
        if stmt is None:
            return None

        if isinstance(stmt, solnodes.Block):
            block_scope = ScopeAndSymbol(name if name else "<block>", stmt)
            self.process_all(block_scope, stmt.stmts)
            return block_scope
        elif isinstance(stmt, solnodes.If):
            # TODO: get better names here, e.g. from line number
            stmt_scope = Scope(f"<if>@{stmt.line_no}")

            self.add_to_scope(stmt_scope, self.process_stmt(stmt.true_branch, '<true_branch>'))
            self.add_to_scope(stmt_scope, self.process_stmt(stmt.false_branch, '<false_branch>'))

            # TODO: check this, what about if(int x = y) {}

            # DONT declare symbols at ASSIGNMENT, only DECLARATION => otherway would be reaching analysis
            return stmt_scope
        elif isinstance(stmt, solnodes.VarDecl):
            return [Symbol(str(var.var_name), stmt) for var in stmt.variables]

    def process_all(self, parent_scope, children_nodes):
        if children_nodes is None:
            return

        for child in children_nodes:
            child_symbol = self.process_node(child)
            self.add_to_scope(parent_scope, child_symbol)

