import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.Assert;

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
  
  @Test
  public void contains_true() {
    LinkedList<String> list = new LinkedList<String>();
    list.append("A");
    list.append("B");
    list.append("C");
    assertTrue(list.contains("B"));
  }
  
  @Test
  public void delete_first() {
    LinkedList<String> list = new LinkedList<String>();
    list.append("A");
    list.append("B");
    list.append("C");
    
    list.delete("A");
    
    String expected = "BC";
    String computed = list.toString();
    assertEquals(expected, computed);
  }
  
  @Test
  public void delete_middle() {
    LinkedList<String> list = new LinkedList<String>();
    list.append("A");
    list.append("B");
    list.append("C");
    
    list.delete("B");
    
    String expected = "AC";
    String computed = list.toString();
    assertEquals(expected, computed);
  }
  
  @Test
  public void delete_last() {
    LinkedList<String> list = new LinkedList<String>();
    list.append("A");
    list.append("B");
    list.append("C");
    
    list.delete("C");
    
    String expected = "AB";
    String computed = list.toString();
    assertEquals(expected, computed);
  }
}
