import sys

from src.collectors.collector import collect_top_level_objects, get_minor_ver

if __name__ == "__main__":
    input_src = open(sys.argv[1], 'r').read()
    minor_vers = get_minor_ver(input_src)
    for obj in collect_top_level_objects(input_src, minor_vers):
        print(f'=== {obj.name} ===')
        print(obj.content)
