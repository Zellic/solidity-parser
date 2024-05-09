==== ExternalSource: _base64/base64_inline_asm.sol ====
==== ExternalSource: _base64/base64_no_inline_asm.sol ====
==== Source: base64.sol ====

import "_base64/base64_inline_asm.sol";
import "_base64/base64_no_inline_asm.sol";

contract test {
    function encode_inline_asm(bytes memory data) external pure returns (string memory) {
      return InlineAsmBase64.encode(data);
    }

    function encode_no_asm(bytes memory data) external pure returns (string memory) {
      return NoAsmBase64.encode(data);
    }

    function encode_inline_asm_large() external {
      for (uint i = 0; i < 1000; i++) {
        InlineAsmBase64.encode("foo");
      }
    }

    function encode_no_asm_large() external {
      for (uint i = 0; i < 1000; i++) {
        NoAsmBase64.encode("foo");
      }
    }
}
// Test cases derived from Base64 specification: RFC4648
// https://datatracker.ietf.org/doc/html/rfc4648#section-10
//
// ====
// EVMVersion: >=constantinople
// ----
// constructor()
// gas irOptimized: 405832
// gas legacy: 735054
// gas legacyOptimized: 522722
// encode_inline_asm(bytes): 0x20, 0 -> 0x20, 0
// encode_inline_asm(bytes): 0x20, 1, "f" -> 0x20, 4, "Zg=="
// encode_inline_asm(bytes): 0x20, 2, "fo" -> 0x20, 4, "Zm8="
// encode_inline_asm(bytes): 0x20, 3, "foo" -> 0x20, 4, "Zm9v"
// encode_inline_asm(bytes): 0x20, 4, "foob" -> 0x20, 8, "Zm9vYg=="
// encode_inline_asm(bytes): 0x20, 5, "fooba" -> 0x20, 8, "Zm9vYmE="
// encode_inline_asm(bytes): 0x20, 6, "foobar" -> 0x20, 8, "Zm9vYmFy"
// encode_no_asm(bytes): 0x20, 0 -> 0x20, 0
// encode_no_asm(bytes): 0x20, 1, "f" -> 0x20, 4, "Zg=="
// encode_no_asm(bytes): 0x20, 2, "fo" -> 0x20, 4, "Zm8="
// encode_no_asm(bytes): 0x20, 3, "foo" -> 0x20, 4, "Zm9v"
// encode_no_asm(bytes): 0x20, 4, "foob" -> 0x20, 8, "Zm9vYg=="
// encode_no_asm(bytes): 0x20, 5, "fooba" -> 0x20, 8, "Zm9vYmE="
// encode_no_asm(bytes): 0x20, 6, "foobar" -> 0x20, 8, "Zm9vYmFy"
// encode_inline_asm_large()
// gas irOptimized: 1322025
// gas legacy: 1554031
// gas legacyOptimized: 1132031
// encode_no_asm_large()
// gas irOptimized: 3206081
// gas legacy: 4587075
// gas legacyOptimized: 2823075
