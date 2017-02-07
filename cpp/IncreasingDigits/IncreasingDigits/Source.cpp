#include <cmath>
#include <iostream>
#include <string>

int computeSmallestNumber(int);
int computeLargestNumber(int);
bool isIncreasingNumber(int);

int main() {
  int numberOfDigits = 3;

  int smallest = computeSmallestNumber(numberOfDigits);
  int largest = computeLargestNumber(numberOfDigits);
  for(int i = smallest; i <= largest; i++) {
    if (isIncreasingNumber(i)) {
      std::cout << i << std::endl;
    }
  }
  return 0;
}

int computeSmallestNumber(int digitCount) {
  return (int) pow(10, digitCount - 1);
}

int computeLargestNumber(int digitCount) {
  return (int) pow(10, digitCount) - 1;
}

bool isIncreasingNumber(int number) {
  std::string text = std::to_string(number);
  int previous = 0;
  for (unsigned int i = 0; i < text.length(); i++) {
    int digit = text[i];
    if (previous < digit) {
      previous = digit;
    } else {
      return false;
    }
  }
  return true;
}