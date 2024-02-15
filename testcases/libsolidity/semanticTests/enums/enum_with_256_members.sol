pragma abicoder v2;
enum E {
    E000, E001, E002, E003, E004, E005, E006, E007, E008, E009,
    E010, E011, E012, E013, E014, E015, E016, E017, E018, E019,
    E020, E021, E022, E023, E024, E025, E026, E027, E028, E029,
    E030, E031, E032, E033, E034, E035, E036, E037, E038, E039,
    E040, E041, E042, E043, E044, E045, E046, E047, E048, E049,
    E050, E051, E052, E053, E054, E055, E056, E057, E058, E059,
    E060, E061, E062, E063, E064, E065, E066, E067, E068, E069,
    E070, E071, E072, E073, E074, E075, E076, E077, E078, E079,
    E080, E081, E082, E083, E084, E085, E086, E087, E088, E089,
    E090, E091, E092, E093, E094, E095, E096, E097, E098, E099,
    E100, E101, E102, E103, E104, E105, E106, E107, E108, E109,
    E110, E111, E112, E113, E114, E115, E116, E117, E118, E119,
    E120, E121, E122, E123, E124, E125, E126, E127, E128, E129,
    E130, E131, E132, E133, E134, E135, E136, E137, E138, E139,
    E140, E141, E142, E143, E144, E145, E146, E147, E148, E149,
    E150, E151, E152, E153, E154, E155, E156, E157, E158, E159,
    E160, E161, E162, E163, E164, E165, E166, E167, E168, E169,
    E170, E171, E172, E173, E174, E175, E176, E177, E178, E179,
    E180, E181, E182, E183, E184, E185, E186, E187, E188, E189,
    E190, E191, E192, E193, E194, E195, E196, E197, E198, E199,
    E200, E201, E202, E203, E204, E205, E206, E207, E208, E209,
    E210, E211, E212, E213, E214, E215, E216, E217, E218, E219,
    E220, E221, E222, E223, E224, E225, E226, E227, E228, E229,
    E230, E231, E232, E233, E234, E235, E236, E237, E238, E239,
    E240, E241, E242, E243, E244, E245, E246, E247, E248, E249,
    E250, E251, E252, E253, E254, E255
}

contract C {
    function getMinMax() public returns (E, E) {
        return (E.E000, E.E255);
    }

    function intToEnum(uint8 _i) public returns (E) {
        return E(_i);
    }

    function enumToInt(E _e) public returns (uint8) {
        return uint8(_e);
    }

    function decodeEnum(bytes memory data) public returns (E) {
        (E e) = abi.decode(data, (E));
        return e;
    }
}
// ----
// getMinMax() -> 0, 255
// intToEnum(uint8): 0 -> 0
// intToEnum(uint8): 255 -> 255
// enumToInt(uint8): 0 -> 0
// enumToInt(uint8): 255 -> 255
// enumToInt(uint8): 256 -> FAILURE
// decodeEnum(bytes): 0x20, 32, 0 -> 0
// decodeEnum(bytes): 0x20, 32, 255 -> 255
// decodeEnum(bytes): 0x20, 32, 256 -> FAILURE
