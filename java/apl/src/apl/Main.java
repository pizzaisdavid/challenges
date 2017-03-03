package apl;

public class Main {
  public static void main(String args[]) {
    String input = "(((((103)))))";
    Expression expression = new Expression(input);
    Token answer = apl(expression);
    System.out.println(answer);  
  }

  public static Token apl(Expression expression) {
    System.out.println(expression);
    expression.dropWrappingParentheses();
    while(expression.isSimplified() == false) {
      Token trailing;
      if (expression.endsWithClosingParentheses()) {
        Expression sub = expression.getFirstLayerParentheses();
        System.out.println("sub: " + sub);
        trailing = apl(sub);
      } else {
        trailing = expression.popLast();
      }
      Token symbol = expression.popLast();
      Token leading;
      if (expression.endsWithClosingParentheses()) {
        Expression sub = expression.getFirstLayerParentheses();
        System.out.println("sub: " + sub);
        leading = apl(sub);
      } else {
        leading = expression.popLast();
      }
      System.out.println("trailing: " + trailing);
      System.out.println("symbol: " + symbol);
      System.out.println("leading: " + leading);
      expression.add(operate(leading, symbol, trailing));
      System.out.println(expression);
    }
    return expression.popLast();
  }

  private static Token operate(Token leading, Token symbol, Token trailing) {
    int lead = leading.getValue();
    char sym = symbol.getSymbol();
    int tail = trailing.getValue();
    
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
