import antlr4
from antlr4.tree.Tree import TerminalNode
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
        if isinstance(rule, antlr4.Token) or isinstance(rule, TerminalNode):
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
        """
        Finds the first subrule of the given rule and returns the result of running the appropriate subparser
        :param rule:
        :return:
        """
        for c in get_grammar_children(rule):
            return self.make(c)
        raise NotImplementedError('No subrules of ' + rule.__name__)

    def make_all(self, rule: antlr4.ParserRuleContext):
        """
        Takes all the subrules of the given rule and returns a list of the result of running their subparsers
        :param rule:
        :return:
        """
        if rule is None:
            return []
        else:
            return map_helper(self.make, get_grammar_children(rule))

    def make_all_rules(self, rules):
        if rules is None:
            return []
        else:
            return map_helper(self.make, [r for r in rules if is_grammar_rule(r)])


def get_grammar_children(rule: antlr4.ParserRuleContext):
    """
    Gets the children of the given rule that are grammar rules and not tokens
    :param rule:
    :return:
    """
    return rule.getChildren(is_grammar_rule)


def is_grammar_rule(rule):
    """
    Predicate for whether the given rule is a user written rule in the language grammar.
    e.g. StatementContext would be a grammar rule, whereas the literal 'for' or lexer token
    'For' would not be

    :param rule:
    :return:
    """
    return isinstance(rule, antlr4.ParserRuleContext)


def map_helper(func, xs):
    # helper to switch between list comprehension for debugging and
    # using map() for performance
    return [func(x) for x in xs]


def get_all_subparsers(module):
    """
    Gets all the valid subparser methods from the given module
    :param module:
    :return:
    """
    all_methods = inspect.getmembers(module, inspect.isfunction)
    # check every method to see if it looks like a subparser
    discovered_builders = [check_subparser_method(*info) for info in all_methods]
    # filter out the nones
    return dict([p for p in discovered_builders if p is not None])


def get_subparsers_from_methods(*methods):
    """
    Gets the valid subparser methods from the list of given methods
    :param methods:
    :return:
    """
    discovered_builders = [check_subparser_method(None, m) for m in methods]
    return dict([p for p in discovered_builders if p is not None])


def check_subparser_method(name, method):
    """
    Checks whether the given name and method match the form of valid subparsers in the context
    of this parsing framework. Subparsers are methods with the form _f(parser, rule: 'RuleType')
    where parser is the parent parser that provides a context to the subparser and method is a python
    method reference.
    The parser parameter must be named 'parser' but the 'rule' parameter can be named anything. The
    'RuleType' must be a string(not a python class type) matching the name of the generated
    antlr grammar rule, e.g. StatementContext

    :param name: Name of the given parser or None if no check is required on this parameter
    :param method: The subparser method to check
    :return: A tuple of (RuleType, method)
    """

    if name is not None and not name.startswith('_'):
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

    if isinstance(rule_param_type, type):
        rule_param_type = rule_param_type.__name__

    if not rule_param_type.endswith('Context'):
        return None

    return rule_param_type, method
