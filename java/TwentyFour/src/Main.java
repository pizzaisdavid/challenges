
public class Main {
  
  public static void main(String args[]) {
    int size = 10;
    int twice = size*2;
    System.out.println(dash(twice));
    
    for (int i = 0; i < size; i++) {
      System.out.println(space(twice - 1) + "|" + space(twice) + "|" + space(twice - 2) + "|");
    }
    
    System.out.println(dash(twice) + space(twice) + dash(twice));
    
    for (int i = 0; i < size; i++) {
      System.out.println("|" + space(size * 6 - 2) + "|");
    }
    
    System.out.println(dash(twice));
  }

  private static String dash(int count) {
    return stringMultiplication(count, "-");
  }
  
  private static String space(int count) {
    return stringMultiplication(count, ".");
  }

  private static String stringMultiplication(int count, String symbol) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += symbol;
    }
    return text;
  }
}
