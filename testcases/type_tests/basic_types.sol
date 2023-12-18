pragma solidity ^0.8.0;

contract AllTypesExample {
    // State variables
    bool public booleanValue;
    int256 public integerValue;
    uint256 public unsignedValue;
    address public addressValue;
    bytes public bytesValue;
    string public stringValue;

    // Fixed-size array
    uint256[3] public fixedArray;

    // Dynamic array
    uint256[] public dynamicArray;

    // Struct
    struct MyStruct {
        uint256 field1;
        string field2;
    }
    MyStruct public myStructValue;

    // Enum
    enum MyEnum { Option1, Option2, Option3 }
    MyEnum public enumValue;

    // Mapping
    mapping(uint256 => string) public keyValueMapping;

    // Address Payable
    address payable public payableAddress;

    // Libraries
//    using SafeMath for uint256;
//    uint256 public libraryValue;

    // Function
    function myFunction(uint256 arg) public pure returns (uint256) {
        return arg * 2;
    }

    // Event
    event MyEvent(address indexed sender, uint256 indexed value);

    // Function Types
    modifier onlyOwner() {
        if(msg.sender == addressValue) {
//            require(msg.sender == addressValue, "Only owner can call this");
        }
        _;
    }

    // Error Types
    error CustomError(string message);

    function throwError() public pure {
        revert CustomError("This is a custom error");
    }

    constructor() {
        booleanValue = true;
        integerValue = -42;
        unsignedValue = 42;
        addressValue = msg.sender;
        bytesValue = bytes("Hello, Solidity!");
        stringValue = "Hello, World!";

        // Since fixed-size memory arrays of different type cannot be converted into each other (even if the base types
        // can), you always have to specify a common base type explicitly if you want to use two-dimensional array literals:
        fixedArray = [uint256(1), 2, 3];
        dynamicArray.push(4);
        dynamicArray.push(5);

        myStructValue = MyStruct(10, "Example");
        enumValue = MyEnum.Option1;

        keyValueMapping[1] = "One";
        keyValueMapping[2] = "Two";
        keyValueMapping[3] = "Three";

        emit MyEvent(msg.sender, 100);

        payableAddress = payable(msg.sender);

        // Using SafeMath library
        uint256 x = 10;
        uint256 y = 5;
//        libraryValue = x.add(y); // SafeMath addition
    }

        // Modifiers
    function modifyValue(uint256 newValue) public onlyOwner {
        integerValue = int256(newValue);
    }

    // Pragma Directives
//    function getVersion() public pure returns (string memory) {
//        return pragma solidity ^0.8.0;
//    }

    // Assembly Types
    function useAssembly() public pure returns (bytes32) {
        bytes32 result;
        assembly {
            mstore(result, 42)
        }
        return result;
    }

    function unary_ops() {
        int128 a = 1;
        a++;
        a--;

        uint256 b = 2;
        b = -b;

        uint8 c = 5;
//        c = +c;

        uint16 d = ~c;

        bool k = false;
        bool j = !k;
    }

    function get_a_contract_name() public returns (string) {
        return type(AllTypesExample).name;
    }

    function get_int_min_max() public returns (int16, int16) {
        return (type(int16).min, type(int16).max);
    }

    function new_deploy_contract() {
        AllTypesExample e = new AllTypesExample();
    }
}