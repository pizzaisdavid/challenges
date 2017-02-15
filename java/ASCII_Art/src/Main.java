
public class Main {
  public static void main(String args[]) {
    
    int length = 10;
    
    for (int i = 0; i < length - 1; i++) {
      System.out.println(spaces(i) + "\\" + spaces(length - i - 2) + "|" + spaces(length - i - 2) + "/");
    }
    
    System.out.println(dashes(length - 1) + "*" + dashes(length - 1));
    
    for (int i = 0; i < length - 1; i++) {
      System.out.println(spaces(length - i - 2) + "/" + spaces(i) + "|" + spaces(i) + "\\");
    }
    
  }
  
  public static String dashes(int count) {
    return stringMultiplication("-", count);
  }
  
  public static String spaces(int count) {
    return stringMultiplication(".", count);
  }
  
  public static String stringMultiplication(String symbol, int count) {
    String message = "";
    for (int i = 0; i < count; i++) {
      message += symbol;
    }
    return message;
  }
}
