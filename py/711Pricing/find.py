import sys, traceback
from itertools import combinations_with_replacement
import math

def main():
    count = 3   # <= change this to try it
    goal = 7.98 # <= change this to try it

    '''
    FAILS:
    N     TOTAL     ANSWER
    4     6.44      1.25, 1.60, 1.75, 1.84
    3     7.98      0.70, 2.28, 5.00
    2     4.90      1.40, 3.50
    '''

    formatted = goal * 100
    formatted = roundDollar(formatted)
    pool = [formatted]
    for n in range(count):
        pool.append(100)
    
    recur(goal, formatted, pool, count)
    print("DONE")

def recur(trueGoal, goal, pool, count):
    print(pool)
    attempt(trueGoal, pool, count)
    CENT = 1
    divisor = CENT
    while divisor <= goal / 2:
        product = (goal / divisor) * 100
        '''
        There is probably a bug in "product < goal"
        because then it won't include the divisor!
        '''
        if product < goal and isDollar(product):
            #print("goal", goal, "divisor", divisor, "product:", product)
            p = list(pool)
            p.append(divisor)
            p.append(product)
            recur(trueGoal, divisor, p, count)
            recur(trueGoal, product, p, count)
        divisor = divisor + CENT
    
def isDollar(n):
    return n == math.ceil(n)

def roundDollar(n):
    return round(n * 100.0) / 100.0	

def attempt(goal, pool, count):
    #print("attempting...")
    combos = list(combinations_with_replacement(pool, count))
    for c in combos:
        add = 0
        multi = 1
        for n in c:
            add = add + (n / 100)
            multi = multi * (n / 100)
        if add == goal and roundDollar(multi) == goal:
            print("winner", c)
            sys.exit(0)

main()
