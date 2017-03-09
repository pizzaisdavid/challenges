import time
from itertools import combinations_with_replacement

def main():
    start_time = time.time()
    totals = [4.0, 6.00, 7.11, 8.00, 6.44, 5.61, 7.98, 7.50, 4.05, 4.9, 8.41]
    counts = [2, 3, 4, 4, 4, 3, 3, 3, 2, 2, 2]
    for t, c in zip(totals, counts):
        answer = slurp(t, c)
        print(answer)
    print("--- %s seconds ---" % (time.time() - start_time))
    print("DONE")

def slurp(total, count):
    pool = calculate_all_possible_breakdowns(total)
    pool.append(1)
    pool.append(total)
    print(pool)
    for combo in list(combinations_with_replacement(pool, count)):
        addition = 0
        multiplication = 1
        for c in combo:
            addition += c
            multiplication *= c
        if isMatching(addition, total) and isMatching(multiplication, total):
            return sorted(combo)
                
    
def calculate_all_possible_breakdowns(total, pool=[]):
    for divisor in dollar_range(total):
        product = total / divisor
        if isDollar(product):
            product = round(product, 2)
            isNewProduct = product < total and product not in pool
            isNewDivisor = divisor not in pool
            if isNewProduct:
                pool.append(product)
            if isNewDivisor:
                pool.append(divisor)
            if isNewProduct:
                calculate_all_possible_breakdowns(product, pool)
            if isNewDivisor:
                calculate_all_possible_breakdowns(divisor, pool)
    return pool

def isMatching(value, key):
    return isDollar(value) and round(value, 2) == key

def dollar_range(total):
    CENT = 0.01
    i = total
    smallest = CENT * 50
    while i > smallest:
        yield round(i, 2)
        i -= CENT

def isDollar(n):
    temp = round(n, 8)
    return temp == round(n, 2)

if __name__ == "__main__":
    main()
