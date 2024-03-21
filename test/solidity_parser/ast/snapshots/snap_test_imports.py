# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import Snapshot


snapshots = Snapshot()

snapshots['TestImports::test_expr_types 1'] = [
    '5 :: uint8(3)',
    '5 :: uint8(3)',
    'this.g(this.token.f) :: uint256',
    'this.token.f :: address',
    'this.token.f :: address',
    'this.g(this.token.f) :: uint256',
    'this.token.f :: address',
    'this.token.f :: address',
    'this.token.f2 :: uint256',
    'x = x + this.g(msg.sender) :: uint256',
    'this.g(msg.sender) :: uint256',
    'this.token.f2 :: uint256',
    'x = x + this.g(msg.sender) :: uint256',
    'this.g(msg.sender) :: uint256',
    'this.token.f3[x] :: uint256',
    'this.token.f4[x][y] :: int8',
    'this.token.f6 :: byte[32]',
    'this.token.f7 :: bytes',
    'this.token.f8 :: string',
    'z + this.token.f5[10] :: int8',
    'this.token.f5[10] :: int8',
    '10 :: uint8(4)',
    'this.token.f3[x] :: uint256',
    'this.token.f4[x][y] :: int8',
    'this.token.f6 :: byte[32]',
    'this.token.f7 :: bytes',
    'this.token.f8 :: string',
    'z + this.token.f5[10] :: int8',
    'this.token.f5[10] :: int8',
    '10 :: uint8(4)',
    'this.token.f4[x][y] :: int8',
    'this.token.f4[x][y] :: int8'
]
