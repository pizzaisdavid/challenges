package apl;

public class Token {
  private char symbol;
  private int value;

  public Token(String number) {
    try {
      value = Integer.parseInt(number);
      symbol = ' ';
    } catch (Exception e) {
      
    }
  }

  public Token(char character) {
    symbol = character;
  }
  
  public Token() {
    symbol = ' ';
  }

  public Token(int i) {
    value = i;
    symbol = ' ';
  }

  public String toString() {
    if (symbol == ' ') {
      return value + "";
    } else {
      return symbol + "";
    }
  }

  public boolean isOpeningParentheses() {
    return symbol == '(';
  }

  public boolean isClosingParentheses() {
    return symbol == ')';
  }

  public int getValue() {
    return value;
  }

  public char getSymbol() {
    return symbol;
  }
}
