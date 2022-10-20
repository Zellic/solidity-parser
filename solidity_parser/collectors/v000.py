class TopLevelObjectCollector:
    def __init__(self):
        self.indent = 0
        self.lines = []
        self.cur_line = ''
        self.prev_terminal = ''
        self.in_loop = False
        self.past_loop = '';
        self.ALPHA_CHARS = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_$\"'

    def reset(self):
        self.indent = 0
        self.lines = []
        self.cur_line = ''
        self.prev_terminal = ''

    def visit_terminal_node(self, node, parent=None):
        x = node.getText()
        if 'for' in self.prev_terminal:
            self.in_loop = True
        if self.in_loop:
            self.past_loop += self.prev_terminal
        if x == ')' and 'for' in self.past_loop:
            self.in_loop = False

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
        if x in ['=>', '=', '|=', '^=', '&=', '<<=', '>>=', '+=', '-=', '*=', '/=', '%=', '?', ':', '||', '&&',
                 '==', '!=', '<', '>', '<=', '>=', '|', '^', '&', '<<', '>>', '+', '-', '*', '/', '%', '**']:
            if parent and parent.getChildCount() > 2:  # dont pad unary expressions
                prespace = ' '
                postspace = ' '

        if x == '}':  # always put '}' on its own line
            self.newline()
            self.cur_line += x
        else:
            self.cur_line += prespace + x + postspace

        if x == '}':
            self.indent -= 1
        if x in (';', '{', '}') and not self.in_loop:  # bit of a hack to catch all the non-specially handled cases
            self.newline()
        if x == '{':
            self.indent += 1

        self.prev_terminal = x

    def newline(self):
        if not self.cur_line:
            return
        self.cur_line = self.cur_line.rstrip()
        self.lines.append('  ' * self.indent + self.cur_line)
        self.cur_line = ''
        self.prev_terminal = ''

    def collect_lines(self):
        return '\n'.join(self.lines)


class TopLevelObject:
    def __init__(self, name, content):
        self.name = name
        self.content = content
