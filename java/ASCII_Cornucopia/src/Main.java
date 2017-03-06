import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    
    Scanner in = new Scanner(new File("prob3.in"));
    PrintWriter out = new PrintWriter("prob3.out");
    
    while (in.hasNextInt()) {
      int size = in.nextInt();
      if (size == 0) {
        break;
      }
      System.out.println(size);
      int topWidth = size * 2 - 1;
      
      out.println(space(topWidth) + dash(topWidth));
      
      for (int i = 1; i <= size * 2 - 1; i++) {
        out.println(space(topWidth - i) + "/" + space(topWidth + 2 * i - 2) + "\\");
      }
      
      out.println(space(topWidth + topWidth / 2) + "C");
      
      for (int i = 1; i <= size * 2 - 1; i++) {
        out.println(space(i - 1) + "\\" + space(topWidth + 2 * (topWidth - i)) + "/");
      }
      
      out.println(space(topWidth) + dash(topWidth));
      out.println();
    }
    out.close();
  }

  private static String dash(int count) {
    return stringMultiple(count, "-");
  }

  private static String space(int count) {
    return stringMultiple(count, " ");
  }
  

  private static String stringMultiple(int count, String string) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += string;
    }
    return text;
  }
}
