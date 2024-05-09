pragma abicoder               v2;

contract C {
    struct S {
        uint128 a;
        uint256[] x;
        uint240 b;
    }
    uint8 b = 23;
    S s;
    uint8 a = 17;
    function f() public {
        delete s;
        s.x.push(42); s.x.push(42); s.x.push(42);
        delete s;
        assert(s.x.length == 0);
        uint256[] storage x = s.x;
        assembly { sstore(x.slot, 3) }
        assert(s.x[0] == 0);
        assert(s.x[1] == 0);
        assert(s.x[2] == 0);
        assert(b == 23);
        assert(a == 17);
    }

    function g() public {
        delete s;
        s.x.push(42); s.x.push(42); s.x.push(42);
        s.a = 1; s.b = 2;
        delete s.x;
        assert(s.x.length == 0);
        uint256[] storage x = s.x;
        assembly { sstore(x.slot, 3) }
        assert(s.x[0] == 0);
        assert(s.x[1] == 0);
        assert(s.x[2] == 0);
        assert(b == 23);
        assert(a == 17);
        assert(s.a == 1);
        assert(s.b == 2);
    }
}
// ----
// f() ->
// gas irOptimized: 113210
// gas legacy: 113591
// gas legacyOptimized: 113103
// g() ->
// gas irOptimized: 118580
// gas legacy: 118764
// gas legacyOptimized: 118172
