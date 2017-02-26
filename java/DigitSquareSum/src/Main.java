
public class Main {
  public static void main(String args[]) {
    poops("999999");
  }
  
  private static void poops(String i) {
    if (i.equals("1") || i.equals("4")) {
      System.out.println(i);
      System.out.println(i);
    } else {
      digitSquareSum(i);
    }
  }

  private static void digitSquareSum(String i) {
    System.out.println(i);
    if (i.equals("1") || i.equals("4")) {
    } else {
      String q = compute(i);
      digitSquareSum(q);
    }
  }
  
  public static String compute(String number) {
    int newNumber = 0;
    for (int i = 0; i < number.length(); i++) {
      char character = number.charAt(i);
      int value = Character.getNumericValue(character);
      newNumber += value * value;
    }
    return newNumber + "";
  }
}
