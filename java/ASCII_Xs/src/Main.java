
public class Main {
  
  public static void main(String args[]) {
    int size = 3;
    System.out.println(stringMultiplication(size, "\\ /"));
    System.out.println(stringMultiplication(size, " X "));
    System.out.println(stringMultiplication(size, "/ \\"));
  }
  
  public static String stringMultiplication(int count, String string) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += string;
    }
    return text;
  }
}
