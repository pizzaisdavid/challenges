package apl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Tests {

  @Test
  public void rightToLeft() {
    Expression expression = new Expression("5*10-2");
    assertEquals(40, Main.apl(expression).getValue());
  }
  
  @Test
  public void oneSetOfParenthesesAtEnd() {
    Expression expression = new Expression("(5*10)-2");
    assertEquals(48, Main.apl(expression).getValue());
  }
  
  @Test
  public void alreadySimplified() {
    Expression expression = new Expression("103");
    assertEquals(103, Main.apl(expression).getValue());
  }
  
  @Test
  public void alreadySimplifiedWrappedInParentheses() {
    Expression expression = new Expression("(103)");
    assertEquals(103, Main.apl(expression).getValue());
  }
  
  @Test
  public void subtractionChain() {
    Expression expression = new Expression("1-2-3-4-5-6-7-8-9-10");
    assertEquals(-5, Main.apl(expression).getValue());
  }
  
  @Test
  public void parenthesesChain() {
    Expression expression = new Expression("((((((((1-2)-3)-4)-5)-6)-7)-8)-9)-10");
    assertEquals(-53, Main.apl(expression).getValue());
  }
  
  @Test
  public void parenthesesOnTheInside() {
    Expression expression = new Expression("4*(5*3-(3+5))-8");
    assertEquals(-132, Main.apl(expression).getValue());
  }
  
  @Test
  public void multiplyByZero() {
    Expression expression = new Expression("5*4*3*2*1*0");
    assertEquals(0, Main.apl(expression).getValue());
  }
  
  @Test
  public void subtractFromZero() {
    Expression expression = new Expression("0-0-5280");
    assertEquals(5280, Main.apl(expression).getValue());
  }

}
