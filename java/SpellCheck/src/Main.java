import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws Exception {
    
    ArrayList<String> dictionary = new ArrayList<String>();
    Scanner in = new Scanner(new File("prob2.in"));
    while (true) {
      String line = in.nextLine();
      if (line.isEmpty()) {
        break;
      }
      dictionary.add(line);
    }
    while (in.hasNextLine()) {
      String word = in.nextLine();
      String message = "Matches for " + word + ":";
      System.out.println(message);
      ArrayList<String> matches = spellcheck(dictionary, word);
      for (int i = 0; i < matches.size(); i++) {
        System.out.println(matches.get(i));
      }
      System.out.println();
    }
  }

  private static ArrayList<String> spellcheck(ArrayList<String> dictionary, String keyword) {
    ArrayList<String> matches = new ArrayList<String>();
    for (int i = 0; i < dictionary.size(); i++) {
      String word = dictionary.get(i);
      if (isMatch(keyword, word)) {
        matches.add(word);
      }
    }
    return matches;
  }

  private static boolean isMatch(String keyword, String word) {
    return isSameLength(keyword, word) && hasAtMostOneDifferentLetter(keyword, word);
  }

  private static boolean hasAtMostOneDifferentLetter(String keyword, String word) {
    boolean alreadyOneMismatch = false;
    for (int i = 0; i < keyword.length(); i++) {
      char first = keyword.charAt(i);
      char second = word.charAt(i);
      if (first != second) {
        if (alreadyOneMismatch == true) {
          return false;
        } else {
          alreadyOneMismatch = true;
        }
      }
    }
    return true;
  }

  private static boolean isSameLength(String a, String b) {
    return a.length() == b.length();
  }
}
