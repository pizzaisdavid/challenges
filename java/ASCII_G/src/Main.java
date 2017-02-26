
public class Main {
  public static void main(String args[]) {
    int size = 5;
    
    System.out.println("+" + dash(size * 2 - 1));
    
    for (int i = 0; i < size - 1; i++) {
      System.out.println("|");
    }
    
    System.out.println("|" + space(size - 1) + dash(size - 1) + "+");
    
    for (int i = 1; i < size - 1; i++) {
      System.out.println("|" + space(size * 2 - 2) + "|");
    }
    
    System.out.println("+" + dash(size * 2 - 2) + "+");
  }

  private static String space(int size) {
    return stringMultiplication(" ", size);
  }

  private static String dash(int size) {
    return stringMultiplication("-", size);
  }

  private static String stringMultiplication(String symbol, int size) {
    String text = "";
    for (int i = 0; i < size; i++) {
      text += symbol;
    }
    return text;
  }
}
