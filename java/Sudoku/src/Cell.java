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
      return Arrays.toString(possibilities.toArray());
    } else {
      return value + "";
    }
  }

  public void update(Cell[] sequence) {
    updateInlineConstrictions(sequence);
    updateNeighborConstrictions(sequence);
    if (isEmpty()) {
      System.out.println(Arrays.toString(possibilities.toArray()));
      if (possibilities.size() == 1) {
        value = possibilities.remove(0);
        System.out.println("FILLED WITH " + value);
      }
    }
  }
  
  private void updateInlineConstrictions(Cell[] sequence) {
    for (int i = 0; i < sequence.length; i++) {
      Cell cell = sequence[i];
      if (cell.isFilled()) {
        Integer value = cell.getValue();
        possibilities.remove(value);
      }
    }
  }

  private void updateNeighborConstrictions(Cell[] sequence) {
    // If you're the only one with a number in your possibilities list, you are that number.
    for (int i = 0; i < sequence.length; i++) {
      System.out.println("UNSOLVED NEG " + sequence[i]);
    }
    for (int pos : possibilities) {
      if (noOneElseHas(pos, sequence)) {
        System.out.println("DONEONE");
        value = pos;
        possibilities = new ArrayList<Integer>();
        break;
      }
    }
  }

  private boolean noOneElseHas(int possible, Cell[] sequence) {
    // yourself is included in "sequence" so it occurs once it is okay
    int count = 0;
    for (int i = 0; i < sequence.length; i++) {
      Cell cell = sequence[i];
      if (cell.has(possible)) {
        count++;
      }
    }
    return count == 1;
  }

  private boolean has(int possible) {
    return possibilities.contains(possible);
  }

  private List<Integer> removeCommonPossibilities(List<Integer> unquiepossibilities) {
    unquiepossibilities.removeAll(possibilities);
    return unquiepossibilities;
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
