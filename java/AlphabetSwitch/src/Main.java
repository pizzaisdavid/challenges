
public class Main {
  
  public static void main(String args[]) {
    
    String input = "Gsv jfrxp yildm ulc qfnkvw levi gsv ozab wlth.";
    
    String output = reverse(input);
    System.out.println(output);
  }
  
  public static String reverse(String input) {
    String output = "";
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    for (int i = 0; i < input.length(); i++) {
      String character = input.substring(i, i + 1);
      if (isLetter(character)) {
        boolean isUpper = character.equals(character.toUpperCase());
        int index = alphabet.indexOf(character.toUpperCase());
        String reversed = alphabet.substring(25-index, 25-index+1);
        if (isUpper) {
          output += reversed;
        } else {
          output += reversed.toLowerCase();
        }
      } else {
        output += character;
      }
    }
    
    return output;
  }
  
  public static boolean isLetter(String character) {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String upper = character.toUpperCase();
    return alphabet.indexOf(upper) != -1;
  }
}
