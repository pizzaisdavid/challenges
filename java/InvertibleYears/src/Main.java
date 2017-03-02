import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
  
  public static void main(String args[]) {    
    ArrayList<Integer> years = setupInvertibleYears(99999);
    System.out.println(Arrays.toString(years.toArray()));
    
    
    int year = 1961;
    for (int i = 0; i < years.size(); i++) {
      int invertibleYear = years.get(i);
      if (year < invertibleYear) {
        System.out.println(invertibleYear);
        break;
      }
    }
  }

  private static ArrayList<Integer> setupInvertibleYears(int size) {
    ArrayList<Integer> years = new ArrayList<Integer>();
    for (int i = 0; i <= size; i++) {
      if (isInvertible(i)) {
        years.add(i);
      }
    }
    return years;
  }

  private static boolean isInvertible(int i) {
    String year = Integer.toString(i);
    return year.equals(invert(year));
  }
  
  private static String invert(String year) {
    String built = "";
    for (int i = 0; i < year.length(); i++) {
      char character = year.charAt(i);
      char inverted = invert(character);
      built = Character.toString(inverted) + built;
    }
    return built;
  }

  private static char invert(char number) {
    switch (number) {
    case '0':
      return '0';
    case '1':
      return '1';
    case '6':
      return '9';
    case '9':
      return '6';
    case '8':
      return '8';
    default:
      return 'X';
    }
  }
  
}
