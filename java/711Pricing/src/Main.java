import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  
  public static void main(String args[]) {
    double total = 7.11;
    int n = 4;
    List<Double> x = poopDolla(total, total, n, n, 0, 1);
    System.out.println(Arrays.toString(x.toArray()));
  }

  private static List<Double> poopDolla(double goal, double total, int count, int n, double addTotal, double multiplyTotal) {
    addTotal += total;
    multiplyTotal *= total;
    System.out.println("add: " + addTotal + " mutl: " + multiplyTotal);
    if (count == 0) {
      if (addTotal == goal && Math.abs(multiplyTotal  - goal) < .0001) {
        List<Double> x = new ArrayList<Double>();
        return x;
      } else {
        return null; // you smell
      }
    } else {
      double CENT = 0.01;
      double halfway = total / 2;
      for (double i = CENT; i < halfway; i = roundDollar( i + CENT)) {
        double product = total / i;
        if (product < goal && isDollarAmount(product)) {
          List<Double> poops = poopDolla(goal, i, count - 1, n, addTotal, multiplyTotal);
          if (poops != null) {
            poops.add(i);
            return poops;
          }
          List<Double> pees = poopDolla(goal, product, count - 1, n, addTotal, multiplyTotal);
          if (pees != null) {
            pees.add(i);
            return pees;
          }
        }
      }
    }
    return null;
  }

  private static List<Double> copy(List<Double> pool) {
    List<Double> ImAPoolYouKnow = new ArrayList<Double>();
    for (double d : pool) {
      ImAPoolYouKnow.add(d);
    }
    return ImAPoolYouKnow;
  }

  private static boolean isDollarAmount(double product) {
    double temp = roundDollar(product);
    return product == temp || Math.abs(temp - product) < .0001;
  }
  
  private static double roundDollar(double number) {
    return Math.round(number * 100.0) / 100.0;
  }
}
