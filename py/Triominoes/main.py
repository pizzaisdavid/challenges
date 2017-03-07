import itertools
import math

'''
 n     perms      repeats     dominoes (difference)
 1     1          0           1
 2     8          4           4
 3     27         16          11
 4     65         40          24
 5     125        80          45
 6     216        140         76
 7     343        224         119
 8     512        336         176
 9     729        480         249
 10    1000       660         340
 11    1331       880         451
 12    1728       1144        584
 13    2197       1456        741
 14    2744       1820        924
 15    3375       2240        1135
'''

def main():
    print("test")
    count = 1
    with open("prob4.in") as inFile, open("prob4.out", "w+") as outFile:
        while (True):
            line = inFile.readline();
            print(line)
            cases = [int(case) for case in line.strip().split()]
            for case in cases:
                if case == 0:
                    return 0;
                length = calculate(case)
                print("CASE=", case)
                outFile.write("Case {}: There are {} triominoes number to {}.\n".format(count, length, case))
                count += 1
                

def calculate(n):
    perms = list(itertools.product(range(1, n + 1), repeat=3))
    permCount = len(perms)
    repeats = (2 / 3) * math.pow(n, 3) - (2 / 3) * n
    repeats = math.ceil(repeats)
    return permCount - repeats













if __name__ == "__main__":
    main()
