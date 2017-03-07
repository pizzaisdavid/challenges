import java.util.ArrayList;
import java.util.Arrays;
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

  public void update(Cell[] sequence) {
    for (int i = 0; i < sequence.length; i++) {
      Cell cell = sequence[i];
      if (cell.isFilled()) {
        Integer value = cell.getValue();
        possibilities.remove(value);
      }
    }
    if (isEmpty()) {
      System.out.println(Arrays.toString(possibilities.toArray()));
      if (possibilities.size() == 1) {
        value = possibilities.remove(0);
        System.out.println("FILLED WITH " + value);
      }
    }
  }

  private int getValue() {
    return value;
  }

  private boolean isFilled() {
    return isEmpty() == false;
  }
  
  public boolean isEmpty() {
    return value == -1;
  }
}
