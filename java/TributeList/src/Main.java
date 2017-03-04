
// perms

public class Main {
  public static void main(String args[]) {
    
    //distinguishablePermutationsEquation(3, new int []{});
    int total = 50;
    int numerator = factorial(total * 2);
    int denom = 1;
    for (int i = 0; i < total; i++) {
      denom *= 2;
    }
    System.out.println(numerator);
    System.out.println(denom);
    System.out.println(numerator / denom);
  }
  
  public static int distinguishablePermutationsEquation(int total, int[] counts) {
    int numerator = factorial(total);
    System.out.println(numerator);
    return 0;
  }

  private static int factorial(int total) {
    if (total == 1) {
      return 1;
    }
    return total * factorial(total - 1);
  }
}
