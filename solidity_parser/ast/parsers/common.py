import antlr4
import inspect


class ParserBase:
    def __init__(self, subparsers):
        self.subparsers = subparsers  # the magic beans

    def make(self, rule: antlr4.ParserRuleContext):
        # Default case
        if rule is None:
            return None

        # this can happen with rule labels like in array slice if the
        # optional subrule in the grammar doesn't match
        if isinstance(rule, antlr4.Token):
            return None

        # find the appropriate _<type> creation method based on
        # the rule type
        rule_type = type(rule)
        subparser_lookup_key = rule_type.__name__

        if subparser_lookup_key in self.subparsers:
            subparser = self.subparsers[subparser_lookup_key]
            return subparser(self, rule)
        else:
            raise KeyError('No parser for ' + subparser_lookup_key)

    def make_first(self, rule: antlr4.ParserRuleContext):
        for c in get_grammar_children(rule):
            return self.make(c)
        raise NotImplementedError('No subrules of ' + rule.__name__)

    def make_all(self, rule: antlr4.ParserRuleContext):
        if rule is None:
            return []
        else:
            return map_helper(self.make, get_grammar_children(rule))


def get_grammar_children(rule: antlr4.ParserRuleContext):
    return rule.getChildren(is_grammar_rule)


def is_grammar_rule(rule):
    return isinstance(rule, antlr4.ParserRuleContext)


def map_helper(func, xs):
    # helper to switch between list comprehension for debugging and
    # using map() for performance
    return [func(x) for x in xs]


def get_all_subparsers(module):
    all_methods = inspect.getmembers(module, inspect.isfunction)
    # check every method to see if it looks like a subparser
    discovered_builders = [check_subparser_method(*info) for info in all_methods]
    # filter out the nones
    return dict([p for p in discovered_builders if p is not None])


def check_subparser_method(name, method):
    # parsers are methods with the form
    #  _f(parser, rule) where rule is the name a subclass of antlr4.ParserRuleContext

    if not name.startswith('_'):
        return None

    (args, _, _, _, _, _, annotations) = inspect.getfullargspec(method)

    # match (parser, rule) method signature
    if len(args) != 2 or args[0] != 'parser':
        return None

    # parameter name of the 2nd argument, e.g. expr, stmt, rule, etc
    rule_param_name = args[1]
    if rule_param_name not in annotations:
        return None

    # this is the name of the rule class created by antlr, e.g. for an antlr grammar
    # rule of 'expression', the generated class will be 'ExpressionContext' which the
    # subparser specifies and matches against
    rule_param_type = annotations[rule_param_name]
    if not rule_param_type.endswith('Context'):
        return None

    return rule_param_type, method
