import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob6.out");
    
    while(in.hasNextInt()) {
      int size = in.nextInt();
      if (size == 0) {
        break;
      }
      out.println(space(size - 1) + "^");
      
      for (int i = 1; i < size - 1; i++) {
        out.println(space(size - i - 1) + "/" + space(i * 2 - 1) + "\\"); 
      }
      
      out.println("X" + dash(size * 2 - 3)  + "X");
      
      int width = size * 2 - 3;
      for (int i = 0; i < width; i++) {
        out.println("|" + space(width) + "|");
      }
      
      out.println("X" + dash(size * 2 - 3)  + "X");
      out.println();
    }
    out.close();
  }
    
  
  private static String dash(int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += "-";
    }
    return text;
  }


  public static String space(int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += " ";
    }
    return text;
  }
  
}
