import unittest
from mock import patch, Mock, MagicMock

from solidity_parser.ast.nodebase import Node, NodeList
from solidity_parser.ast.types import VoidType, BoolType, TupleType


class TestNodeDataclass(unittest.TestCase):

    @patch.object(Node, 'compute_node_hash')
    def test_basic_hash_not_recomputed(self, compute_node_hash_mock: Mock):
        compute_node_hash_mock.return_value = 1
        n = Node()

        hash1 = hash(n)
        hash2 = hash(n)

        self.assertEqual(hash1, 1)
        self.assertEqual(hash2, 1)

        compute_node_hash_mock.assert_called_once()

    def test_child_list_changed_should_recompute_hash(self):
        p = Node()
        p_hash_mock = MagicMock()
        p_hash_mock.return_value = 1
        p.compute_node_hash = p_hash_mock

        c = Node()

        # hash first time, no child
        hash(p)
        p_hash_mock.assert_called_once()

        # add child
        p.comments.append(c)
        c.parent = p

        # hash first time, with child
        hash(p)
        self.assertEqual(p_hash_mock.call_count, 2)

    def test_child_list_equals(self):
        # comments here are NodeLists, not lists

        n1 = TupleType([])
        c1 = BoolType()
        n1.ttypes.append(c1)

        n2 = TupleType([])
        c2 = VoidType()
        n2.ttypes.append(c2)

        self.assertNotEqual(n1, n2)
        self.assertNotEqual(n1.ttypes, n2.ttypes)

        n1.ttypes.clear()
        n2.ttypes.clear()

        self.assertEqual(n1.ttypes, n2.ttypes)
        self.assertEqual(n1, n2)

    def test_list_item_propagates_to_grandparent(self):
        g = Node()
        p = Node()
        c = Node()

        g.comments.append(p)
        p.parent = g

        p.comments.append(c)
        c.parent = p

        hash(g)
        self.assertIsNotNone(g._cached_hash)

        d = Node()
        c.comments.append(d)

        self.assertIsNone(g._cached_hash)

    def test_init_with_list_creates_nodelist(self):
        n = TupleType([])
        self.assertIsInstance(n.ttypes, NodeList)

    def test_set_list_creates_nodelist(self):
        n = TupleType([])
        n.ttypes = [VoidType()]
        self.assertIsInstance(n.ttypes, NodeList)
