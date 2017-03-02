import java.util.ArrayList;
import java.util.List;

public class Cell {
  private int value;
  private List<Integer> possibilities;
  
  public Cell(int value) {
    this.value = value;
    possibilities = new ArrayList<Integer>();
  }

  public Cell() {
    this.value = -1;
    possibilities = new ArrayList<Integer>();
    for (int i = 1; i < 10; i++) {
      possibilities.add(i);
    }
  }
  
  public String toString() {
    if (value == -1) {
      return " ";
    } else {
      return value + "";
    }
  }
}
