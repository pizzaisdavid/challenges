import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    String text = "HELP ME";
    String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    PrintWriter out = new PrintWriter("prob5.out");
    for (int i = 0; i < text.length(); i++) {
      char character = text.charAt(i);
      int index = ALPHABET.indexOf(character);
      out.println(space(index));
    }
    out.println();
    out.println();
    out.close();
  }

  private static String space(int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += ".";
    }
    return text;
  }
  
}
