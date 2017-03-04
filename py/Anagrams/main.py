
from itertools import permutations

def main():
    with open("prob1.in", "r") as inFile, open("prob1.out", "w+") as outFile:
        text = inFile.readline()
        count = 1;
        while (text != ""):
            outFile.write(str.format("Case {}\n", count))

            text = text.strip() # removes \n 
            distinct = distinguishable_permutations(text, len(text))
            print(distinct)
            for d in distinct:
                outFile.write("".join(d) + "\n")
            outFile.write("\n")
            count += 1
            text = inFile.readline()
            

def distinguishable_permutations(text, size):
    return sorted({p for p in permutations(text, size)})


if __name__ == "__main__":
    main()
