import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class Tests {

  @Test
  public void isPalindrome_true() {
    assertFalse(Main.isPalindrome("CAT"));
  }
  
  @Test
  public void isPalindrome_false() {
    assertTrue(Main.isPalindrome("BOB"));
  }
}
