import sys, traceback
from itertools import combinations_with_replacement
import math

def main():
    goal = 1.28

    '''
    FAILS:
    N     TOTAL     ANSWER
    3     7.98      0.70, 2.28, 5.00

    '''

    recur(goal)
    print("DONE")

def recur(goal):    
    CENT = 0.01
    for divisor in decimal_range(CENT, goal, CENT):
        product = (goal / divisor)
        if product < goal and isDollar(product):
            print("goal", goal, "divisor", divisor, "product", round(product, 2))        
    
def isDollar(n):
    temp = round(n, 8)
    return temp == round(n, 2)

def decimal_range(x, y, jump):
  while x < y:
    yield round(x, 2)
    x += jump


main()
