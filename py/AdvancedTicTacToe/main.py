
def main():
    r = 3
    c = 3
    k = 2

    answer = count(r, c, k)
    print(answer)

def count(rows, columns, length):
    total = 0
    total += fits(rows, length) * columns
    total += fits(columns, length) * rows
    total += squareFits(rows, columns, length, length) * 2
    return total

def fits(totalLength, segmentLength):
    return 0

def squareFits(heightTotal, widthTotal, smallHeight, smallWidth):
    return 0

if __name__ == "__main__":
    main()
