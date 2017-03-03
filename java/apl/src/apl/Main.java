package apl;

public class Main {
  public static void main(String args[]) {
    String input = "4*(5*3-(3+5))-8";
    Expression expression = new Expression(input);
    Token answer = apl(expression);
    System.out.println(answer);  
  }

  public static Token apl(Expression expression) {
    System.out.println(expression);
    
    expression.dropWrappingParentheses();
    while(expression.isSimplified() == false) {
      Token trailing = simplify(expression);
      Token symbol = expression.popLast();
      Token leading = simplify(expression);
      expression.add(operate(leading, symbol, trailing));
    }
    return expression.popLast();
  }

  private static Token simplify(Expression expression) {
    if (expression.endsWithClosingParentheses()) {
      Expression sub = expression.getFirstLayerParentheses();
      System.out.println("isolated parentheses: " + sub);
      return apl(sub);
    } else {
      return expression.popLast();
    }
  }

  private static Token operate(Token leading, Token symbol, Token trailing) {
    int lead = leading.getValue();
    char sym = symbol.getSymbol();
    int tail = trailing.getValue();
    System.out.println("" + lead + sym + tail);
    switch(sym) {
    case '+':
      return new Token(lead + tail);
    case '-':
      return new Token(lead - tail);
    case '*':
      return new Token(lead * tail);
    case '/':
      return new Token(lead / tail);
    default:
      System.out.println("Failure");
      return new Token(0);
    }
  }
}
