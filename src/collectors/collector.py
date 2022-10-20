from src.collectors.v060 import TopLevelObjectCollectorV060
from src.collectors.v070 import TopLevelObjectCollectorV070
from src.collectors.v080 import TopLevelObjectCollectorV080


# not the best shld prob make this a bit nicer...
def get_minor_ver(txt):
    ind = txt.find('pragma solidity')
    ind2 = txt.find(';', ind)
    vers = txt[ind + len('pragma solidity') + 1:ind2]
    remove = ['^', '~', '>=', '>', '<', '<=', '=', ' ', '.']
    for r in remove:
        vers = vers.replace(r, '')
    return int(f'{vers[1]}')


def collect_top_level_objects(stream, vers):
    if vers < 7:
        print(f'Minor version {vers} detected, using V060')
        return TopLevelObjectCollectorV060().collect(stream)
    elif 8 > vers >= 7:
        print(f'Minor version {vers} detected, using V070')
        return TopLevelObjectCollectorV070().collect(stream)
    elif vers >= 8:
        print(f'Minor version  {vers} detected, using V080')
        return TopLevelObjectCollectorV080().collect(stream)
    return None
