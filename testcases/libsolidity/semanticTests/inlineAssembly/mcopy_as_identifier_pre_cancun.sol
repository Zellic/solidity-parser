contract C {
    function f() public pure returns (uint result) {
        assembly {
            let mcopy := 1
            result := mcopy
        }
    }

    function g() public pure returns (uint result) {
        assembly {
            function mcopy() -> r {
                r := 1000
            }
            result := mcopy()
        }
    }
}
// ====
// EVMVersion: <cancun
// ----
// f() -> 1
// g() -> 1000
