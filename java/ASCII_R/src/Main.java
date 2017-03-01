
public class Main {
  
  public static void main(String args[]) {
    
    int size = 1;
    
    for (int i = 0; i < size; i++) {
      System.out.println("|" + space(i) + "\\");
    }
    
    for (int i = 0; i < size; i++) {
      System.out.println("|" + space(size - i - 1) + "/");
    }
    
    for (int i = 0; i < size; i++) {
      System.out.println("|" + space(i) + "\\");
    }
  }

  private static String space(int i) {
    return stringMultiplication(i, ".");
  }

  private static String stringMultiplication(int count, String symbol) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += symbol;
    }
    return text;
  }
}
