package apl;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

  @Test
  public void rightToLeft() {
    assertEquals(40, Main.apl("5*10-2"));
  }
  
  @Test
  public void parentheses() {
    assertEquals(32, Main.apl("((3*2)+2)*(2+2)"));
  }

}
