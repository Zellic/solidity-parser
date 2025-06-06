 
## Changelog
All notable changes to this project will be documented in this file.
 
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

### [0.1.23] - 2025-05-19
 - Added `FunctionParameter` for input parameters of `FunctionType`s (required for named argument support)
 - Changed `FunctionType` field `inputs` to `input_params`
 - Added `block.blobbasefee` builtin variable
 - Added `blobhash` builtin function
 - Added new `require` function that takes an `ErrorType`
 - Added `Type.is_user_error`
 - Added `ErrorType` to make allow class error objects
 - Added `UserDefinedErrorType` for solidity `error` 'function' types
 - Added `CreateError` AST2 node for first class error initialisation
 - Changed AST2 `RevertWithError` to take a `CreateError` object instead of a type and list of args
 - Changed AST1 `EventParameter` and `ErrorParameter` to use `var_name` instead of `name` to be consistent with Parameter
 - Changed AST1 `Parameter` to use `soltypes.Type` for `var_type` instead of `Ident`
 - Fixed hashing issue with `NodeList`
 - Fixed some issues with function type widening with 
 - 
### [0.1.22] - 2024-08-29
 - Fixed issues with external function call options(gas/value) being confused with name function arguments
 - Renamed `solnodes.CallFunction.modifiers` to `special_call_options`
 - Renamed `solnodes2.Call` and `solnodes2.CreateAndDeployContract` `named_args` to `call_options`
 - Fixed error messaging and ignore line numbers when parsing remapping files
 - Fixed naming issue where `location` was being used instead of `id_location` for AST Node source locations
 - Allowed AST2 partial function building to expand multiple calls(used for `call` on `address payable`)
 - Added `selector` support for Events and Errors
 - Fixed incompatability issue with partial function application for old style gas/value and using functions on function base types
 - Fixed issue with BuiltInCall `name` being a set instead of string
 - Fixed other misc issues in AST2Builder
 - Fixed function call resolution for calls with named args
 - Added testcases

### [0.1.21] - 2024-08-01
 - Fixed issue where `using *` statements with unimported types were causing crashes
 - Changed types.type_key to support UserTypes with a callback
 - Added symtab.TypeNotFound error

### [0.1.20] - 2024-06-13
 - Fixed issue with AST2 TypeHelper with function types of overriden functions

### [0.1.19] - 2024-05-13
 - Fixed import lookup case for remapping files with imports that clash

### [0.1.18] - 2024-05-09
 - Fixed version string in docs

### [0.1.17] - 2024-05-09
 - Added documentation site
 - Changed AST2 FileDefinition descriptor to not include file name twice
 - Added AST2 ContractDefinition.state_var()
 - Changed VFS process_cli_input_file to return LoadedSource result
 - Added _do_read_path to VFS

### [0.1.16] - 2024-04-16
 - Created nodebase.py for all Node base type for AST1 and AST2 nodes
   - NodeDataclass/NodeList parenting mechanism added to AST1
 - Created types.py for shared AST1 and AST2 types

### [0.1.15] - 2024-03-20
 - Cleaned up AST2 ErrorHandler
   - Removed code_errors from AST2Builder, moved to ErrorHandler.caught_errors
 - Added errors.UnexpectedProcessingErrors for wrapping python errors in AST2Builder
 - Fixed Ident and Using directive and import resolution issues

### [0.1.14] - 2024-02-05
 - Fixed AST1 parser line number tracking
 - Updated AST2 error handling
 - Fixed issues with free floating functions/events/errors
 - Added `start_location` and `end_location` to ast2 nodes
 - Added `origin` to `LoadedSource`
 - Added origin tracking to VFS


### [0.1.13] - 2024-01-11
 - Add SourceLocationSpan in AST1
 - Stability fixes to do with using directives and symtab searching

### [0.1.12] - 2024-01-08
- Fixed line number issue with rules with `start` attributes
- Added source start/end location markers for solnodes1
- Updated main.py stress tester
- Added requirement for python 3.10 in README

### [0.1.11] - 2024-01-04
 - Minor AST2 fixes
 - make_ast now takes the input source 'origin' to better locate parsing errors
   - Added Origin to AntlrParsingError
 - Removed polluting symtab exists debug line
 - Fixed issue with type lookup in symtab pulling inherited Using types

### [0.1.10] - 2023-12-19
 - Changed git versioning to setuptools versioning (was broken)

### [0.1.9] - 2023-12-19
 - Added soft errors in AST2 for code processing exceptions
 - Improved FCA to account for unprocessed function code
 - Fixed AST1 parsing issue for VarDecl tuples desugars that have 1 element, e.g. (x,) = ...
 - Changed AST2 log levels from info to debug

### [0.1.8] - 2023-12-14
 - Fixed many internal AST2 bugs
 - Added parser_version to symtab.Builder2

### [0.1.7] - 2023-12-12
 - Fixed inherited Using directive scopes in subcontracts
 - Added snapshottest library for testing
 - Fixed bug with ast2builder map_arg_as_type

### [0.1.6] - 2023-12-11
 - Fixed parsing bug with pragmas using `=` symbol

### [0.1.5] - 2023-12-06

 - AST2/AST2builder
   - Fixed issues with GetArrayValue nodes misparsing in AST2
   - Patched issue where multiple types have the same name in a contract context
   - Added load_non_top_level_if_required
   - Fixed issue with reskeletoning free floating AST2 nodes
   - Fixed bug where using function calls weren't being desugared
 - Parser060/070
   - Fixed issue with inline array expressions parsed as tuples
 - Solnodes2
   - Made get_children only return dataclass children
   - Fixed address payable code str output
- Symtab
  - Changed symtab Using directive nesting to flat format
  - Removed interfaceId interface check due to abstract contract having the field
  - Fixed msg.data being bytes4 to bytes
  - Fixed qualified name lookups for some symtab refs
  - Changed resolve_base_symbol() (single) to res_syms() (multiple)
  - Added sha256 and ripemd160 builtins
  - Added UsingDirectiveScope

### [0.1.4] - 2023-11-30
 - Changed address payable code_str `addresspayable` to `address payable`
 - Fixed type mapping for names shadowed in proxy scopes(because of using directives)
 - Fixed ast2builder skeletoning nodes twice
 - Added type_key() to solnodes1 and solnodes2 Types to fix `ResolvedUserType(X)` lookups (now just uses `X`)

### [0.1.3] - 2023-11-29
 - Updated README
 - AST2/AST2builder
   - Added is_enum() helper to TopLevelUnit
   - Fixed issue with default field initialisation for BytesType and StringType
   - Added missing str functions
   - Added GetArraySlice node
   - Fixed issue for multi element buckets for overriden calls
   - Removed solidity 0.4/0.5 Address contract base scope (needs to be fixed with version check)
   - Fixed min/max case for Enums
   - Improved logging
   - Fixed type issue for ErrorParameter name (str to Ident)
   - Fixed callable variable name to include parameters
   - Updated using library overrides building
   - Added NodeList and NodeDataclass cached hashing + tests
 - Function analysis
   - Added CallGraph building
   - Changed super call mro lookup
   - Changed mark_sources to return a list of sources that were marked
 - Solnodes1
   - Added source_location() helper
 - Symtab
   - Fixed issues with resolving base symbols
   - Replaced all_symbols() with get_all_children()
   - Added get_all_functions() helper
   - Fixed recursive infinite loops during symbol lookup for Contracts
   - Added min/max builtins for Enums
   - Fixed recursive DFS MRO symbol resolution in contracts(check_hierarchy flag)
   - Added ordering for UserDefinedValueType nodes during building to fix SelfUsing case
 - VFS
   - Changed log levels from info to debug

### [0.1.2] - 2023-11-08
- Disable all 0.8.* parsers except for 0.8.22(default parser) in parse autoloading

### [0.1.1] - 2023-11-06

Upgrades to ASI now require version bumping this library 

- Added changelog
- Added version to setup.py
- Added parsing support for Solidity 0.8.22
- Improve pragma version parsing
- Added `bytes.concat` and `string.concat` builtins
- Added user defined value type support(0.8.8)
- Added `wrap`/`unwrap` for user defined value types
- Added user defined operator support(0.8.19)
- Added `using X for *` directive parsing
- Fixed Windows source unit naming issue with backslashes in name
- Fixed 'using directive' scoping mechanism
- Added `ResolvedUserType` as base for `DynamicBuiltInCall`
- Added names to argument types of MappingType(0.8.18)
- Fixed AST2 lookup issues with overriden functions
- Fixed issues with loading 'free' source unit types during AST2 building
- Added `abi.encodeCall` builtin
- Fixed issue with qualified type casts, e.g. `MyA.MyB(value)`
- Fixed overriding function modifier lookup issue