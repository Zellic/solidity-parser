import re
from dataclasses import dataclass

VERSION_PATTERN = re.compile(r"(\d+)\.(\d+)(\.\d+)?", re.VERBOSE)


@dataclass
class Version:
    major: int
    minor: int
    patch: int
    is_min: bool
    """ Whether this version represents a lower bound (minimum) version or upper bound (maximum) version """
    is_strict: bool
    """ Whether the specified version is inclusive(non strict) or exclusive(strict) """
    is_inverse: bool
    """ True if the specified version is the inverse of the acceptable versions """

    def is_enforced_in(self, testing_version: 'Version') -> bool:
        """Tests whether a feature that was introduced in the given testing_version is enforced in the current version
        E.g. if a feature is only available in or after version 8.0.1 but the current version is 7.0.0, that feature
             should not be enforced and this function returns False
        """

        # Determine which operator to use based on bounding and strictness
        cmp = None

        if self.is_min:
            # > for strict min and >= for nonstrict min
            cmp = (lambda x, y: x > y) if self.is_strict else (lambda x, y: x >= y)
        else:
            # < for strict max and <= for nonstrict max
            cmp = (lambda x, y: x < y) if self.is_strict else (lambda x, y: x <= y)

        res = cmp(self.major, testing_version.major) and cmp(self.minor, testing_version.minor) and cmp(self.patch, testing_version.patch)

        return (not res) if self.is_inverse else res


@dataclass
class VersionRange:
    lower: Version
    upper: Version

    def is_enforced_in(self, testing_version: Version) -> bool:
        # upper and lower are assumed to be setup correctly, i.e. lower has is_min=True and upper has is_min=False
        assert self.lower.is_min
        assert not self.upper.is_min
        return self.lower.is_enforced_in(testing_version) and self.upper.is_enforced_in(testing_version)


def parse_version(ver_text: str, is_min=True, is_strict=False, is_inverse=False) -> Version:
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

    return Version(int(groups[0]), int(groups[1]), patch, is_min, is_strict, is_inverse)
