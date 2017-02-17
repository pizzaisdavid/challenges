
public class Main {
  
  public static void main(String args[]) {
    //String input = "It was the best of times; it was the worst of times.";
    String input = "Yesterday, all my troubles seemed to far away.";
    //String input = "How now brown cow!";
    String output = babel(input);
    
    System.out.println(output);
  }
  
  public static String babel(String input) {
    String output = "";
    String alfalfa = "";
    String previous = "";
    for (int i = 0; i < input.length(); i++) {
      String current = input.substring(i, i + 1);
      String temp = current.toLowerCase();
      if (isVowel(temp, previous)) {
        alfalfa += temp;
      } else if (alfalfa.isEmpty() == false) {
        output += "lf" + alfalfa;
        alfalfa = "";
      }
      output += current;
      previous = current;
    }
    return output;
  }
  
  public static boolean isVowel(String current, String previous) {
    return isVowel(current) ||
        "y".equals(current) && hasContent(previous) ||
        "w".equals(current) && isVowel(previous);
  }
  
  public static boolean isVowel(String text) {
    return "aeiuo".indexOf(text) != -1;
  }
  
  public static boolean hasContent(String text) {
    return text.trim().isEmpty() == false;
  }
}
