
## Changelog
All notable changes to this project will be documented in this file.
 
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

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