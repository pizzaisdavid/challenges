
public class WordSlot {
  public static final WordSlot NULL = null;
  private String value;
  private int i;
  private int j;
  private Direction direction;
  
  public WordSlot(String value, int i, int j, Direction direction) {
    this.value = value;
    this.i = i;
    this.j = j;
    this.direction = direction;
  }

  public int length() {
    return value.length();
  }

  public boolean fits(String word) {
    if (value.length() != word.length()) {
      return false;
    }
    
    for (int i = 0; i < word.length(); i++) {
      char asteriskOrLetter = value.charAt(i);
      char letter = value.charAt(i);
      if (asteriskOrLetter != '*' && asteriskOrLetter != letter) {
        return false;
      }
    }
    return true;
  }
  
  public String toString() {
    return "VALUE=" + value + " (X=" + i + ", Y=" + j + ", DIRECTION=" + direction + ")";
  }

  public Direction getDirection() {
    return direction;
  }

  public boolean isValid() {
    return value.equals("*");
  }

  public int getI() {
    return i;
  }

  public int getJ() {
    return j;
  }
}
