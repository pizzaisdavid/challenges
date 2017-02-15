
public class Main {
  
  public static void main(String args[]) {
    int length = 1;
    System.out.println(spaces(length * 2) + underscores(length * 2) + spaces(length) + underscores(length * 2 + 1));
    for (int i = length * 2 - 1; i > length; i--) {
      System.out.println(spaces(i) + "/" + spaces(length * 4 - 1) + "/");
      
    }
    System.out.println(spaces(length) + "/" + underscores(length * 2 - 1) + spaces(length * 2) + "/");
    
    for (int i = length * 3 -1; i > length * 2; i--) {
      System.out.println(spaces(i) + "/" + spaces(length * 2 - 1) + "/");
    }
    System.out.println(underscores(length * 2) + "/" + spaces(length * 2 - 1) + "/");
    
  }
  
  public static String spaces(int count) {
    return stirngMultiplication(count, ".");
  }
  
  public static String underscores(int count) {
    return stirngMultiplication(count, "_");
  }
  
  public static String stirngMultiplication(int count, String symbol) {
    String message = "";
    for (int i = 0; i < count; i++) {
      message += symbol;
    }
    return message;
  }
}
