import math
from itertools import combinations


def main():
    goal = 7.11
    count = 4

    widthoutDecimal = goal * 100
    pool = []
    print(widthoutDecimal)
    poopDolla(widthoutDecimal, widthoutDecimal, count, count, pool)
    print("DONE")


def poopDolla(goal, amountLeft, itemsLeft, totalItems, pool):
    if itemsLeft == 0:
        # try to solve
        theyDidTheMath_TheMonsterMath(goal, pool, totalItems)
    else:
        ONE_PENNY_BOB = 1
        halfwayMark = math.ceil(goal / 2) # cuts off the decmial bit
        for divisor in range(1, halfwayMark):
            product = (amountLeft / divisor) * 100
            #print("d", divisor, "p", product)
            if product < amountLeft and isValidDollar(product):
                #print("d", divisor, "p", product)
                newPool = list(pool) # cuz we gonna recure on this bitch
                newPool.append(divisor)
                newPool.append(product)
                newItemsLeft = itemsLeft - 1;
                poopDolla(goal, divisor, newItemsLeft, totalItems, newPool)
                poopDolla(goal, product, newItemsLeft, totalItems, newPool)
                
def isValidDollar(n):
    return n == math.ceil(n)


def theyDidTheMath_TheMonsterMath(desiredAmount, pool, n):
    print(pool)
    for combo in combinations(pool, n):
        addTotal = sum(combo)
        multiplyTotal = multiply(combo)
        if addTotal == desiredAmount and multiplyTotal == desiredAmount: 
           print(combo)

def multiply(sequence):
    product = 0.0
    for s in sequence:
        product = product * s
    return s

if __name__ == "__main__":
    main()
