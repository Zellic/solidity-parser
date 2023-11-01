pragma solidity ^0.8.22;

struct User {
    string name;
    uint count;
}

library UserLibrary {
    function clear_count(User user) internal {
        user.count = 0;
    }

    function inc(User user, uint by) internal {
        user.count += by;
    }

    function dec(User user) internal {
        require(user.count > 0);
        user.count--;
    }
}

using UserLibrary for User global;

contract UserContract {
    function testUser(User u) public returns (uint) {
        u.inc(5);
        return u.count;
    }
}

function testUserOutside(User u) public {
    u.dec();
}
