import math
from decimal import localcontext, Decimal


def main():
    count = 1
    with open("prob1.in") as cin, open("prob1.out", "w") as cout:
        number = int(cin.readline())
        while number != 0:
            try:
                print(number)
                answer = dist(number)
                message = "Case " + str(count) + ": There are " + str(answer) + " possible orderings.\n"
                print(message)
                cout.write(message)
                count += 1
                number = int(cin.readline())
            except IndexError:
                break

def dist(numberOfDistricts):
    numberOfPlayers = numberOfDistricts * 2
    numerator = math.factorial(numberOfPlayers)
    denominator = math.pow(2, numberOfDistricts)
    with localcontext() as cont:
        cont.prec = 1000
        answer = Decimal(numerator) / Decimal(denominator)
        return answer;
    
    

if __name__ == "__main__":
    main()
