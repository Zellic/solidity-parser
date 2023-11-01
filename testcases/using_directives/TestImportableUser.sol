pragma solidity 0.8.22;

import {User2} from "./ImportableUser.sol";

contract TestImportableUser {
    function testFoo(User2 memory user) public {
        user.clear_count();
    }
}