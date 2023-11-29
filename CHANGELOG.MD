
## Changelog
All notable changes to this project will be documented in this file.
 
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

### [0.0.2] - 2023-11-29

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

### [0.0.1] - 2023-11-06

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