import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 *  PRO-TIP don't let the last line get dropped!
 */

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    
    Scanner in = new Scanner(new File("prob2.in"));
    PrintWriter out = new PrintWriter("prob2.out");
    int count = 1;
    while (in.hasNextLine()) {
      String input = "";
      String line = in.nextLine();
      while (in.hasNextLine() && line.isEmpty() == false) {
        
        input += " " + line;
        line = in.nextLine();
      }
      
      if (line.isEmpty() == false) {
        input += " " + line;
      }
      
      
            
      char e = find(input);
      System.out.println("MOST COMMON LETTER:" + e);
      String th = find(input, e);
      System.out.println("the: " + th);
      char t = th.charAt(0);
      char h = th.charAt(1);
      System.out.println("T: " + t);
      System.out.println("H: " + h);
      
      String lettersToKeep = "" + t + h + e + "";
      System.out.println(lettersToKeep);
      
      String answer = decrypt(input, lettersToKeep);
      out.println("Case " + count + ": " +  answer);
      out.println();
      System.out.println(answer);
      count++;
      
    }
    in.close();
    out.close();
  }

  private static String decrypt(String input, String lettersToKeep) {
    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String de = "";
    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);
      if (lettersToKeep.indexOf(character) != -1) {
        int index = lettersToKeep.indexOf(character);
        char correct = Character.MIN_VALUE;
        if (index == 0) {
          correct = 'T';
        } else if (index == 1) {
          correct = 'H';
        } else if (index == 2) {
          correct = 'E';
        }
        de += correct;
      } else if (ALPHABET.indexOf(character) != -1) {
        de += "_";
      } else {
        de += character;
      }
    }
    return de;
  }

  private static String find(String input, char e) {
    Map<String, Integer> theFrequency = new HashMap<String, Integer>();
    for (int i = 0; i < input.length(); i++) {
      try {
        String substring = input.substring(i, i + 3);
        if (isPartOfWordEndingIn(substring, e)) {
         if (theFrequency.containsKey(substring) == false) {
           theFrequency.put(substring, 0);
         }
         int current = theFrequency.get(substring);
         current++;
         theFrequency.put(substring, current);
        }
      } catch (Exception exception) {
        
      }
    }
    return keyWithHighestValueL(theFrequency);
  }

  private static boolean isPartOfWordEndingIn(String substring, char e) {
    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char first = substring.charAt(0);
    char second = substring.charAt(1);
    char third = substring.charAt(2);
    return ALPHABET.indexOf(first) != -1 && first != e &&
           ALPHABET.indexOf(second) != -1 && second != e &&
           third == e;
  }

  private static String keyWithHighestValueL(Map<String, Integer> map) {
    String winner = "";
    int highest = Integer.MIN_VALUE;
    
    for (Entry<String, Integer> entry : map.entrySet()) {
      String key = entry.getKey();
      int value = entry.getValue();
      if (value > highest) {
        winner = key;
        highest = value;
      }
    }
    return winner;
  }

  private static char find(String input) {
    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int STARTING_AMOUNT = 0;
    Map<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
    for (int i = 0; i < ALPHABET.length(); i++) {
      char letter = ALPHABET.charAt(i);
      letterFrequency.put(letter, STARTING_AMOUNT);
    }
    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);
      try {
        int current = letterFrequency.get(character);
        current++;
        letterFrequency.put(character, current);
      } catch (Exception e) {
      }
    }
    return keyWithHighestValue(letterFrequency);
  }

  private static char keyWithHighestValue(Map<Character, Integer> map) {
    char winner = Character.MIN_VALUE;
    int highest = Integer.MIN_VALUE;
    
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      char key = entry.getKey();
      int value = entry.getValue();
      if (value > highest) {
        winner = key;
        highest = value;
      }
    }
    return winner;
  }
}
