import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    File file = new File("prob5.txt");
    Scanner in = new Scanner(file);
    
    while (true) {
      int size = in.nextInt();
      if (size == 0) {
        break;
      }
      
      for (int i = 1; i < size; i++) {
        System.out.println("|" + spaces(size - i - 1) + "/");
      }
      
      System.out.println("K");
      
      for (int i = 1; i < size; i++) {
        System.out.println("|" + spaces(i - 1) + "\\");
      }
      
      System.out.println("");
    }
  }
  
  public static String spaces(int count) {
    String text = "";
    String symbol = ".";
    for (int i = 0; i < count; i++) {
      text += symbol;
    }
    return text;
  }

}
