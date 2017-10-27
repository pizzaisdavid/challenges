package adjustedAverage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Tests {

  @Test
  public void test() {
    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(2, 2, 4, 4, 4)); 
    double average = Main.adjustedAverage(numbers);
    assertEquals(2, average, 0.001);
  }
  
  @Test
  public void test_decimal() {
    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 4, 4)); 
    double average = Main.adjustedAverage(numbers);
    assertEquals(1.5, average, 0.001);
  }
  
  @Test
  public void test_empty() {
    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList()); 
    double average = Main.adjustedAverage(numbers);
    assertEquals(0, average, 0.001);
  }

}
