package apl;

public class Main {
  public static void main(String args[]) {
    
    int answer = apl("");
    
  }
  
  public static int apl(String question) {
    /*
     * for all first layer parentheses
     * - 1 remove parentheses
     * - 2 call apl on and recombine
     * 
     * for all math right to left:  <--
     * - while not Integer.parse(question)
     * - combine using last symbol
    */
    return 0;
  }
  
  public static String cutCrust(String text) {
    return text.substring(1, text.length() - 1);
  }
}
