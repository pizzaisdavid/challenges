import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

  @Test
  public void toString_empty() {
    Queue buffer = new Queue(10);
    assertEquals("", buffer.toString());
  }
  
  @Test
  public void write_AddItemsButNotEnoughToRollOver() {
    Queue buffer = new Queue(10);
    buffer.write("test me");
    assertEquals("test me", buffer.toString());
  }

}
