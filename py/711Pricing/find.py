import sys, traceback
from itertools import combinations_with_replacement
import math

def main():
    count = 3   # <= change this to try it
    goal = 4.90 # <= change this to try it

    '''
    FAILS:
    N     TOTAL     ANSWER
    3     7.98      0.70, 2.28, 5.00

    '''

    formatted = goal * 100
    formatted = roundDollar(formatted)
    pool = [formatted]
    pool = []
    ONE_DOLLAR = 100
    for n in range(count):
        pool.append(ONE_DOLLAR)
    recur(goal, formatted, pool, count)
    print("DONE")

def recur(trueGoal, goal, pool, count):
    
    attempt(trueGoal, pool, count)
    CENT = 1
    #print(pool)
    limit = math.ceil(goal / 2);
    bonus = int(goal / 4) # not scientific at all
    
    for divisor in range(CENT * 50, limit + bonus):
        product = (goal / divisor) * 100
        if product < goal and isDollar(product):
            p = list(pool)
            p.append(divisor)
            p.append(product)
            recur(trueGoal, product, p, count)
            recur(trueGoal, divisor, p, count)
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
            print(pool)
            sys.exit(0)

main()
