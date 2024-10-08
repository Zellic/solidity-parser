# Configuration file for the Sphinx documentation builder.
#
# For the full list of built-in configuration values, see the documentation:
# https://www.sphinx-doc.org/en/master/usage/configuration.html

# -- Project information -----------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#project-information

import importlib.metadata

__version__ = importlib.metadata.version("solidity-parser")

project = 'SOLP'
copyright = '2024, Zellic'
author = 'Zellic'
release = __version__

# -- General configuration ---------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#general-configuration

extensions = [
    'sphinx.ext.autosectionlabel',
    'sphinx.ext.autodoc',
    'sphinx_autodoc_typehints',
    'sphinx.ext.autosummary',
    'autoapi.extension'
]

# Make sure the target is unique
autosectionlabel_prefix_document = True

autoapi_dirs = ['../../src']
autoapi_keep_files = True
autoapi_ignore = ['*/grammar/*']

templates_path = ['_templates']
exclude_patterns = []


# -- Options for HTML output -------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#options-for-html-output

html_theme = 'furo'
html_static_path = ['_static']

import os
import sys
sys.path.insert(0, os.path.abspath('../../src'))