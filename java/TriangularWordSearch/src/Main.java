
public class Main {
  
  private static char[][] triangle;
  
  public static void main(String[] args) {
    /*
    triangle = new char[][] {
                  {'B'},
                {'A', 'A'},
              {'T', 'T', 'T'},
            {'B', 'A', 'A', 'A'},
          {'T', 'A', 'B', 'B', 'B'},
        {'B', 'A', 'T', 'M', 'A', 'N'}
    };
    String word = "BAT";
    */
    triangle = new char[][] {
          {'B'},
        {'O', 'O'},
      {'B', 'O', 'B'}
    };
    String word = "BOB";   
    
    int total = 0;
    for(int i = 0; i < triangle.length; i++) {
      char[] row = triangle[i];
      for(int j = 0; j <= row.length; j++) {
        total += check(i, j, word);
      }
    }
    if (isPalindrome(word)) {
      total /= 2;
    }
    System.out.println(total);
  }

  public static int check(int height, int width, String word) {
    Position position = new Position(height, width);
    if(isMatch(position, word)) {
      int count = 0;
      String lettersToFind = word.substring(1);
      for (Direction direction : Direction.values()) {
        count += check(position, lettersToFind, direction);
      }
      return count;
    }
    return 0;
  }
  
  public static int check(Position position, String word, Direction direction) {
    position = Position.copy(position);
    position.move(direction);
    if (isMatch(position, word)) {
      if (word.length() == 1) {
        System.out.println(position + " " + word);
        return 1;
      }
      String lettersToFind = word.substring(1);
      return check(position, lettersToFind, direction);
    }
    return 0;
  } 
  
  private static boolean isMatch(Position position, String word) {
    try {
      return triangle[position.height][position.width] == word.charAt(0);
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}