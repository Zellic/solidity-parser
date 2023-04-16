from solidity_parser.collectors.v060 import TopLevelObjectCollectorV060
from solidity_parser.collectors.v070 import TopLevelObjectCollectorV070
from solidity_parser.collectors.v080 import TopLevelObjectCollectorV080


# not the best shld prob make this a bit nicer...
def get_minor_ver(txt):
    ind = txt.find('pragma solidity')
    if ind == -1:
        return None
    ind2 = txt.find(';', ind)
    if ind2 == -1:
        return None
    vers = txt[ind + len('pragma solidity') + 1:ind2].strip()
    remove = ['^', '~', '>=', '>', '<', '<=', '=', ' ', '.']
    for r in remove:
        vers = vers.replace(r, '')
    return int(f'{vers[1]}')


def collect_top_level_objects(stream, vers, debug=False):
    if vers < 7:
        if debug:
            print(f'Minor version {vers} detected, using V060')
        return TopLevelObjectCollectorV060().collect(stream)
    elif 8 > vers >= 7:
        if debug:
            print(f'Minor version {vers} detected, using V070')
        return TopLevelObjectCollectorV070().collect(stream)
    elif vers >= 8:
        if debug:
            print(f'Minor version  {vers} detected, using V080')
        return TopLevelObjectCollectorV080().collect(stream)
    return None
