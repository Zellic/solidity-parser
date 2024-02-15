contract Base {
    constructor(uint256 j) {
        m_i = j;
    }

    uint256 public m_i;
}


contract Base1 is Base {
    constructor(uint256 k) Base(k) {}
}


contract Derived is Base, Base1 {
    constructor(uint256 i) Base1(i) {}
}


contract Final is Derived(4) {}

// ----
// m_i() -> 4
