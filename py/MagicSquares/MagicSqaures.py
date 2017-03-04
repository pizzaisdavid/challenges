
from itertools import combinations

def main():
    pool = [n for n in range(1, 10)]
    combinations = compute_all_length_combinations(pool);
    
    with open("prob1.in", "r") as ins, open("probl.out", "w+") as outs:
        grid = parse(ins.readline()) + parse(ins.readline()) + parse(ins.readline())
        ins.readline()
        while grid != []:
            solution = findSolution(combinations, grid)
            print(solution)
            outs.write(" ".join([str(x) for x in solution]) + "\n")
            grid = parse(ins.readline()) + parse(ins.readline()) + parse(ins.readline())
            ins.readline()
        print("done")

def parse(text):
    return [character for character in text.strip()]

def compute_all_length_combinations(pool):
    possible = []
    for size in range(1, len(pool) + 1):
        possible += list(combinations(pool, size))
    return possible;

def findSolution(combinations, grid):
    GOAL = ["1", "1", "1", "1", "0", "1", "1", "1", "1"]
    print(grid)
    for combo in combinations:
        table = list(grid)
        for move in combo:
            transform(table, move)
        if (table == GOAL):
            return combo
    print(grid)
    return ()

def transform(grid, number):
    flips = {1 : [1, 2, 4, 5],
             2 : [1, 2, 3],
             3 : [2, 3, 5, 6],
             4 : [1, 4, 7],
             5 : [2, 4, 5, 6, 8],
             6 : [3, 6, 9],
             7 : [4, 5, 7, 8],
             8 : [7, 8, 9],
             9 : [5, 6, 8, 9]
             }
    flip(grid, flips[number])

def flip(grid, flips):
    for flip in flips:
        index = flip - 1
        grid[index] = flop(grid[index])

def flop(character):
    if character == "0":
        return "1"
    return "0"
        
    

if __name__ == "__main__":
    main()
        
