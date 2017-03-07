import java.util.ArrayList;
import java.util.List;

public class Cell {
  private Coordinate position;
  private int value;
  private List<Integer> possibilities;
  
  public Cell(Coordinate position, char value) {
    this.position = position;
    if (value == ' ') {
      setupEmptyCell();
    } else {
      setupFilledCell(value);
    }
  }

  private void setupEmptyCell() {
    value = -1;
    possibilities = new ArrayList<Integer>();
    for (int i = 1; i < 10; i++) {
      possibilities.add(i);
    }
  }
  
  private void setupFilledCell(char value) {
    this.value = Character.getNumericValue(value);
    possibilities = new ArrayList<Integer>();
  }

  public String toString() {
    if (value == -1) {
      return " ";
    } else {
      return value + "";
    }
  }

  public boolean isEmpty() {
    return value == -1;
  }
}
