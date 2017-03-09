
from itertools import combinations_with_replacement

def main():
    goal = 7.98
    count = 3
    pool = [7.98, 1.05, 7.06, 1.25, 4.75, 3.04, 1.52, 2.0, 1.6]
    combos = list(combinations_with_replacement(pool, count))
    for c in combos:
        add = 0
        multi = 1
        for n in c:
            add = add + n
            multi = multi * n            
        print("add", add, "multi", multi)
        #print(c)
        if add == goal and multi == goal:
            print("add", add, "multi", multi)
            print(c)
    

main()
