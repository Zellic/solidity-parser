:py:mod:`solidity_parser.ast.parsers.common`
============================================

.. py:module:: solidity_parser.ast.parsers.common


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.parsers.common.ParserBase



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.parsers.common.get_grammar_children
   solidity_parser.ast.parsers.common.is_grammar_rule
   solidity_parser.ast.parsers.common.map_helper
   solidity_parser.ast.parsers.common.get_all_subparsers
   solidity_parser.ast.parsers.common.get_subparsers_from_methods
   solidity_parser.ast.parsers.common.check_subparser_method



.. py:class:: ParserBase(subparsers, token_stream)


   .. py:method:: make(rule: antlr4.ParserRuleContext, default=None)


   .. py:method:: make_first(rule: antlr4.ParserRuleContext)

      Finds the first subrule of the given rule and returns the result of running the appropriate subparser
      :param rule:
      :return:


   .. py:method:: make_all(rule: antlr4.ParserRuleContext)

      Takes all the subrules of the given rule and returns a list of the result of running their subparsers
      :param rule:
      :return:


   .. py:method:: make_all_rules(rules)


   .. py:method:: copy_source_data(decorated_node, node_to_decorate)


   .. py:method:: wrap_node(rule, node, add_comments=False)



.. py:function:: get_grammar_children(rule: antlr4.ParserRuleContext)

   Gets the children of the given rule that are grammar rules and not tokens
   :param rule:
   :return:


.. py:function:: is_grammar_rule(rule)

   Predicate for whether the given rule is a user written rule in the language grammar.
   e.g. StatementContext would be a grammar rule, whereas the literal 'for' or lexer token
   'For' would not be

   :param rule:
   :return:


.. py:function:: map_helper(func, xs)


.. py:function:: get_all_subparsers(module)

   Gets all the valid subparser methods from the given module
   :param module:
   :return:


.. py:function:: get_subparsers_from_methods(*methods)

   Gets the valid subparser methods from the list of given methods
   :param methods:
   :return:


.. py:function:: check_subparser_method(name, method)

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


