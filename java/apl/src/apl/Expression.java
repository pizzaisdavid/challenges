package apl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {
  private List<Token> tokens;
  
  public Expression() {
    this("");
  }
  
  public Expression(String value) {
    this.tokens = parse(value);
  }

  private static List<Token> parse(String input) {
    List<Token> tokens = new ArrayList<Token>();
    String number = "";
    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);
      if (isSymbol(character)) {
        if (number.isEmpty() == false) {
          tokens.add(new Token(number));
          number = "";
        }
        tokens.add(new Token(character));
      } else {
        number += character;
      }
    }
    if (number.isEmpty() == false) {
      tokens.add(new Token(number));
    }
    return tokens;
  }
  
  private static boolean isSymbol(char character) {
    return "-+*/()".indexOf(character) != -1;
  }
  
  public void dropWrappingParentheses() {
    while (isWrappedInParentheses()) {
      tokens.remove(0);
      popLast();
    }
  }

  public boolean isWrappedInParentheses() {
    if (tokens.size() == 0) {
      return false;
    }
    Token first = getFirst();
    Token last = getLast();
    return first.isOpeningParentheses() && last.isClosingParentheses();
  }

  private Token getFirst() {
    return tokens.get(0);
  }

  private Token getLast() {
    return tokens.get(tokens.size() - 1);
  }

  public int size() {
    return tokens.size();
  }

  public boolean isSimplified() {
    return tokens.size() == 1;
  }

  public Token popLast() {
    return tokens.remove(tokens.size() - 1);
  }

  public boolean endsWithClosingParentheses() {
    return getLast().isClosingParentheses() == true;
  }
  
  public String toString() {
    return Arrays.toString(tokens.toArray());
  }

  public void appendFront(Token current) {
    tokens.add(0, current);
  }

  public void add(Token operate) {
    tokens.add(operate);    
  }

  public Expression getFirstLayerParentheses() {
    int closingParenthesesCount = 0;
    int openingParenthesesCount = 0;
    Expression sub = new Expression();
    
    while (true) {
      Token current;
      try {
        current = popLast();
      } catch (Exception e) {
        return sub;
      }
      if (current.isClosingParentheses()) {
        closingParenthesesCount++;
      } else if (current.isOpeningParentheses()) {
        openingParenthesesCount++;
      }
      sub.appendFront(current);
      if (closingParenthesesCount == openingParenthesesCount) {
        break;
      }
    }
    return sub;
  }
}
