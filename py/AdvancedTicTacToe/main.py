
def main():

    with open("prob5.in", "r") as inFile, open("prob5.out", "w+") as outFile:
        while True:
            try:
                line = inFile.readline()
                while line == "\n":
                    line = inFile.readline()
                    
                tokens = line.split()
                print(tokens)
                if len(tokens) == 1 and tokens[0] == "0":
                    print("DONE")
                    break
                r, c, k = [int(x) for x in tokens]
                answer = count(r, c, k)
                outFile.write(str(answer) + "\n")
                print(answer)
            except EOFError:
                print("Done!!")

def count(rows, columns, length):
    if length == 1:
        return rows * columns
    else:
        total = 0
        total += fits(rows, length) * columns
        total += fits(columns, length) * rows
        total += squareFits(rows, columns, length, length) * 2
        return total

def fits(totalLength, segmentLength):
    starts = []
    for start in range(0, totalLength):
        if start + segmentLength <= totalLength and start not in starts:
            starts.append(start)
    return len(starts)
        

def squareFits(heightTotal, widthTotal, smallHeight, smallWidth):
    starts = []
    for start_height in range(0, heightTotal):
        for start_width in range(0, widthTotal):
            end_height = start_height + smallHeight
            end_width = start_width + smallWidth
            pair = (start_height, start_width)
            if end_height <= heightTotal and end_width <= widthTotal and pair not in starts:
                starts.append(pair)
    return len(starts)

if __name__ == "__main__":
    main()
