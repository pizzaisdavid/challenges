
from itertools import combinations_with_replacement

def main():
    goal = 711.0

    goal = 7.11
    count = 4
    pool = [711.0, 150, 474.0, 120, 395.0, 125, 316.0]
    combos = list(combinations_with_replacement(pool, count))
    for c in combos:
        add = 0
        multi = 1
        for n in c:
            add = add + n
            multi = multi * (n / 100)
        if add == goal:
            print("add", add, "multi", multi)
            print(c)
    

main()
