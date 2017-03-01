import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
  private static PrintWriter out;
  
  public static void main(String args[]) throws FileNotFoundException {
    int size = 1;
    out = new PrintWriter("prob3.out");
    for (int i = 0; i < size; i++) {
      println("|" + space(i) + "\\" + space((size - i - 1) * 2) + "/" + space(i) + "|");
    }
    
    for (int i = 0; i < size; i++) {
      println("|" + space(size - i - 1) + "/" + space(i * 2) + "\\" + space(size - i - 1) + "|");
    }
    
    for (int i = 0; i < size * 2; i++) {
      println("|" + space(size * 2) + "|");
    }
    
    
    out.close();
  }

  private static void println(String text) {
    System.out.println(text);
    out.println(text);
    
  }

  private static String space(int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += ".";
    }
    return text;
  }
  
}
