import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob7.in"));
    PrintWriter out = new PrintWriter("prob7.out");
    int count = 1;
    while (in.hasNextLine()) {
      List<String> descendants = new ArrayList<String>();
      String line = in.nextLine();
      while (line.isEmpty() == false) {
        descendants.add(line);
        line = in.nextLine();
      }
      
      int skew = compute(descendants);
      
      out.println("Case " + count + ": The skew factor is " + skew);
    }
    System.out.println("DONE");
    out.close();
  }

  private static int compute(List<String> descendants) {
    String root = descendants.remove(0);
    int left = 0;
    int right = 0;
    for (int i = 0; i < descendants.size(); i++) {
      String current = descendants.get(i);
      if (root.compareTo(current) > 0) {
        left++; 
      } else {
        right++;
      }
    }
    int skew = Math.abs(left - right);
    if (skew == 1) {
      return 0;
    }
    return skew;
  }
}
