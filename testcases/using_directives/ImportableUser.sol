pragma solidity 0.8.22;

struct User2 {
    string name;
    uint count;
}

function clear_count(User2 memory user) {
    user.count = 0;
}

// Now even when User is imported, the clear_count() method can be used.
using {clear_count} for User2 global;