package adjustedAverage;

import java.util.Collections;
import java.util.List;

public class Main {
  
  public static void main(String[] args) {
    System.out.println("hi");
  }
  
  public static double adjustedAverage(List<Integer> numbers) {
    numbers = removeHighest(3, numbers);
    if (numbers.isEmpty()) {
      return 0;
    }
    int total = sum(numbers);
    return (float) total / numbers.size();
  }

  public static List<Integer> removeHighest(int count, List<Integer> numbers) {
    for (int i = 0; i < count; i++) {
      numbers = removeHightest(numbers);
    }
    return numbers;
  }
  
  private static List<Integer> removeHightest(List<Integer> numbers) {
    int max = Integer.MIN_VALUE;
    int index = -1;
    for (int i = 0; i < numbers.size(); i++) {
      int value = numbers.get(i);
      if (value > max) {
        max = value;
        index = i;
      }
    }
    if (index != -1) {
      numbers.remove(index);
    }
    return numbers;
  }

  private static int sum(List<Integer> numbers) {
    int total = 0;
    for (int i = 0; i < numbers.size(); i++) {
      int value = numbers.get(i);
      total += value;
    }
    return total;
  }

}
