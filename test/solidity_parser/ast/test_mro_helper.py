import unittest
import mock

from solidity_parser.ast import mro_helper


class TestMROHelper(unittest.TestCase):
    def setUp(self) -> None:
        hierarchy = {
            'O': [],
            'A': ['O'],
            'B': ['O'],
            'C': ['O'],
            'D': ['O'],
            'E': ['O'],
            'K1': ['C', 'B', 'A'],
            'K2': ['B', 'D', 'E'],
            'K3': ['A', 'D'],
            'Z': ['K1', 'K3', 'K2'],

            'F1': ['A', 'B'],
            'F2': ['B', 'A'],
            'G': ['F1', 'F2']

        }

        nodes = {
            k: mock.Mock(name=k) for k in hierarchy.keys()
        }

        def get_supers(for_node):
            def _impl():
                return [nodes[sk] for sk in hierarchy[for_node]]
            return _impl

        for k, node in nodes.items():
            node.get_supers = get_supers(k)

        self.nodes = nodes

    def map_nodes(self, *names):
        return [self.nodes[n] for n in names]

    def test_no_superclass(self):
        result = mro_helper.c3_linearise(self.nodes['O'])
        self.assertEqual(self.map_nodes('O'), result)

    def test_single_superclass(self):
        result = mro_helper.c3_linearise(self.nodes['A'])
        self.assertEqual(self.map_nodes('A', 'O'), result)

    def test_complicated_1(self):
        result = mro_helper.c3_linearise(self.nodes['K1'])
        self.assertEqual(self.map_nodes('K1', 'A', 'B', 'C', 'O'), result)

    def test_complicated_2(self):
        result = mro_helper.c3_linearise(self.nodes['K2'])
        self.assertEqual(self.map_nodes('K2', 'E', 'D', 'B', 'O'), result)

    def test_complicated_3(self):
        result = mro_helper.c3_linearise(self.nodes['K3'])
        self.assertEqual(self.map_nodes('K3', 'D', 'A', 'O'), result)

    def test_complicated_4(self):
        result = mro_helper.c3_linearise(self.nodes['Z'])
        self.assertEqual(self.map_nodes('Z', 'K2', 'E', 'K3', 'D', 'K1', 'A', 'B', 'C', 'O'), result)

    def test_no_solution(self):
        self.assertRaises(AssertionError, mro_helper.c3_linearise, self.nodes['G'])
