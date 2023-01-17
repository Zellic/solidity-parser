from typing import Union, List, Dict, Optional
from pathlib import Path
import os
from abc import ABC, abstractmethod

from solidity_parser.ast import solnodes


class Resolver(ABC):
    @abstractmethod
    def resolve(self) -> Union['Resolver', 'Symbol']:
        """Resolve it"""


class Scoped():
    def __init__(self):
        self.parent_scope: 'Scope' = None

    def set_parent_scope(self, parent_scope: 'Scope'):
        assert self.parent_scope is None, 'Element is already scoped'
        self.parent_scope = parent_scope


class Symbol(Scoped):
    def __init__(self, names: List[str]):
        Scoped.__init__(self)
        self.names = names


class Scope(Scoped):
    def __init__(self):
        Scoped.__init__(self)
        self.local_scopeables: Dict[str, Scoped] = {}

    def resolve_symbol(self, name: str) -> Symbol:
        if name in self.local_scopeables:
            scopeable = self.local_scopeables[name]
