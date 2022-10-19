import sys
from antlr4 import *
from SolidityLexer import SolidityLexer
from SolidityParser import SolidityParser
from antlr4.tree.Trees import Trees
from antlr4.tree.Tree import TerminalNode

class SolidityPrinter:
    def __init__(self):
        self.indent = 0
        self.lines = []
        self.cur_line = ''
        self.prev_terminal = ''
        self.ALPHA_CHARS = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_$\"'

    def newline(self):
        if not self.cur_line: return
        self.cur_line = self.cur_line.rstrip()
        self.lines.append('  '*self.indent + self.cur_line)
        self.cur_line = ''
        self.prev_terminal = ''

    def visit(self,node,parent=None):
        if isinstance(node, TerminalNode):
            x = node.getText()
            prespace, postspace = '', ''

            prev_is_alpha = any(self.prev_terminal.endswith(c) for c in self.ALPHA_CHARS)
            cur_is_alpha = any(x.startswith(c) for c in self.ALPHA_CHARS)
            if x not in ['.', ',', ';', ')']:
                if prev_is_alpha and cur_is_alpha:
                    prespace = ' '
            if x == '{':
                prespace = ' '
            if x == '(' and self.prev_terminal in ['returns', 'mapping', 'if', 'while', 'for']:
                prespace = ' '
            if self.prev_terminal.endswith(')') and cur_is_alpha:
                prespace = ' '
            if x in [',', '=>', '=']:
                postspace = ' '
            if isinstance(parent, SolidityParser.VersionOperatorContext):
                prespace = ' '
            if x in ['=>', '=', '|=', '^=', '&=', '<<=', '>>=', '+=', '-=', '*=', '/=', '%=', '?', ':', '||', '&&', '==', '!=', '<', '>', '<=', '>=', '|', '^', '&', '<<', '>>', '+', '-', '*', '/', '%', '**']:
                if parent and parent.getChildCount() > 2: # dont pad unary expressions
                    prespace = ' '
                    postspace = ' '

            if x == '}': # always put '}' on its own line
                self.newline()
                self.cur_line += x
            else:
                self.cur_line += prespace + x + postspace
            
            if x == '}':
                self.indent -= 1
            if x in (';','{','}'): # bit of a hack to catch all the non-specially handled cases
                self.newline()
            if x == '{':
                self.indent += 1
            
            self.prev_terminal = x

        elif node.children is None:
            return ''

        elif isinstance(node, SolidityParser.StatementContext):
            assert len(node.children) == 1
            self.visit(node.children[0], node)
            self.newline()

        elif isinstance(node, SolidityParser.ContractPartContext):
            assert len(node.children) == 1
            self.visit(node.children[0], node)
            self.cur_line += '\n'
            self.newline()

        else:
            for c in node.children:
                self.visit(c, node)

    def output(self):
        return '\n'.join(self.lines)

if __name__ == "__main__":
    input_src = open(sys.argv[1],'r').read()
    data =  InputStream(input_src)
    # lexer
    lexer = SolidityLexer(data)
    stream = CommonTokenStream(lexer)
    # parser
    parser = SolidityParser(stream)
    tree = parser.sourceUnit()
    # print(Trees.toStringTree(tree, None, parser))
    source_units = tree.children
    for su in source_units:
        y = SolidityPrinter()
        y.visit(su)
        print(y.output())
        print('\n\n\n')

