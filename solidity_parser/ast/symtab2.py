from typing import Union, List, Dict, Optional
from pathlib import Path
import os
from abc import ABC, abstractmethod

from solidity_parser.ast import solnodes
from solidity_parser.filesys import VirtualFileSystem


class Scopeable(ABC):
    """Element that can be added as a child of a Scope"""

    def __init__(self, aliases: Optional[Union[str, List[str]]]):
        self.parent_scope: Optional[Scope] = None
        self.aliases = aliases


    # def set_parent_scope(self, parent_scope: 'Scope'):
    #     assert self.parent_scope is None, 'Element is already scoped'
    #     self.parent_scope = parent_scope

    def find_first_ancestor(self, predicate):
        """Walks up the symbol tree and finds the first element that satisfies the given predicate"""
        current = self.parent_scope
        while current and not predicate(current):
            current = current.parent_scope
        return current

