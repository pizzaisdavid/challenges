import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

  @Test
  public void hourRollover() {
    Timestamp start = new Timestamp("12:59:59");
    Timestamp duration = new Timestamp("0:02");
    Timestamp current = start.add(duration);
    String string = current.toString();
    assertEquals(string, "1:00:01");
  }
  
  @Test
  public void noRollover() {
    Timestamp start = new Timestamp("4:00:00");
    Timestamp duration = new Timestamp("5:13");
    Timestamp current = start.add(duration);
    String string = current.toString();
    assertEquals(string, "4:05:13");
  }

}
