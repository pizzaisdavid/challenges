import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {

  @Test
  public void append_strings() {
    LinkedList<String> list = new LinkedList<String>();
    list.append("A");
    list.append("B");
    list.append("C");
    String expected = "ABC";
    String computed = list.toString();
    assertEquals(expected, computed);
  }
  
  @Test
  public void append_integer() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.append(1);
    list.append(2);
    list.append(3);
    String expected = "123";
    String computed = list.toString();
    assertEquals(expected, computed);
  }

}
