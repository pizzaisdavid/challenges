
public class Main {
  public static void main(String args[]) {
    String candidate = "RACECARRACECAR";
    
    if (isDoubleNearPalindrome(candidate)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }

  private static boolean isDoubleNearPalindrome(String candidate) {
    for (int i = 1; i < candidate.length(); i++) {
      String start = candidate.substring(0, i);
      String end = candidate.substring(i);
      System.out.println("Start=" + start + ", end=" + end);
      if (isNearPalindrome(start) && isNearPalindrome(end)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isNearPalindrome(String text) {
    return isNearPalindrome(text, 0) || text.length() % 2 == 1 && isPalindrome(text);
  }
  
  public static boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  } 
  
  private static boolean isNearPalindrome(String text, int count) {
    System.out.println("poop loop: " + text + " " + count);
    if (text.length() <= 1) {
      return count == 1;
    }
    
    
    if (text.charAt(0) == text.charAt(text.length() - 1)) {
      return isNearPalindrome(cutCrust(text), count);
    } else {
      if (count == 0) {
        count++;
        return isNearPalindrome(cutCrust(text), count);
      } else {
        return false;
      }
    }
  }

  private static String cutCrust(String text) {
    System.out.println("before: " + text);
    text = text.substring(1, text.length() - 1);
    System.out.println("after: " + text);
    return text;
  }
  
  
}
