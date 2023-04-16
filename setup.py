from setuptools import setup, find_packages

setup(
    name='solidity-parser',

    setuptools_git_versioning={
        "enabled": True,
    },
    setup_requires=["setuptools-git-versioning<2"],

    packages=find_packages(where='src'),
    package_dir={'': 'src'}
)
