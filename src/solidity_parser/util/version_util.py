import re
from dataclasses import dataclass

VERSION_PATTERN = re.compile(r"(\d+)\.(\d+)(\.\d+)?", re.VERBOSE)


@dataclass
class Version:
    major: int
    minor: int
    patch: int

    def is_enforced_in(self, testing_version: 'Version') -> bool:
        """Tests whether a feature that was introduced in the given testing_version is enforced in the current version
        E.g. if a feature is only available in or after version 8.0.1 but the current version is 7.0.0, that feature
             should not be enforced and this function returns False
        """
        return self.major >= testing_version.major and self.minor >= testing_version.minor and self.patch >= testing_version.patch


def parse_version(ver_text: str) -> Version:
    results = VERSION_PATTERN.search(ver_text)
    if not results:
        raise ValueError(f'No version match in {ver_text}')
    # elif len(results) > 1:
    #     raise ValueError(f'{len(results)} version matches in {ver_text}')

    groups = results.groups()

    if len(groups) < 2 or not groups[0] or not groups[1]:
        raise ValueError(f'Need major and minor version(optional patch) for valid version: {groups}')

    # e.g. ".2" - remove the dot
    patch = int(groups[2][1:]) if groups[2] else 0

    return Version(int(groups[0]), int(groups[1]), patch)
