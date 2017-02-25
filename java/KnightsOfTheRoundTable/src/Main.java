import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  private static int count;
  
  public static void main(String args[]) {
    count = 3;
    int killed = 0;
    int permsMinusOne = factorial(count - 1);
    for (int jedi = 1; jedi <= count; jedi++) {
      System.out.println("Jedi strength: " + jedi);
      
      int numberOfJedisThatCanDefeat = count - jedi;
      System.out.println("Stronger jedis: " + numberOfJedisThatCanDefeat);
      if (numberOfJedisThatCanDefeat == 0) {
        
      } else {
        for (int i = 1; i <= numberOfJedisThatCanDefeat; i++) {
          int p = i;
          System.out.println(p);
          killed += p;
        }
      }
    }
    System.out.println("killed: " + killed);
  }

  private static int factorial(int count) {
    if (count == 1) {
      return 1;
    } else {
      return factorial(count - 1) * count;
    }
  }
}