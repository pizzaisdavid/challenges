import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cell {
  private int value;
  private List<Integer> possibilities;
  
  public Cell(char value) {
    if (value == ' ') {
      setupEmptyCell();
    } else {
      setupFilledCell(value);
    }
  }
  
  public Cell(Cell cell) {
    value = cell.value;
    possibilities = cell.possibilities;
  }

  public boolean equals(Cell other) {
    return value == other.getValue() && possibilities.equals(other.possibilities);
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
    for (int pos : possibilities) {
      if (noOneElseHas(pos, sequence)) {
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

  private int getValue() {
    return value;
  }

  private boolean isFilled() {
    return isEmpty() == false;
  }
  
  public boolean isEmpty() {
    return value == -1;
  }

  public List<Integer> getPossibilities() {
    return possibilities;
  }

  public void guess() {
    value = possibilities.get(0);
    possibilities = new ArrayList<Integer>();
  }

  public boolean hasError() {
    return value == -1 && possibilities.size() == 0;
  }

  public void removeFailedGuess() {
    possibilities.remove(0);
  }
}
