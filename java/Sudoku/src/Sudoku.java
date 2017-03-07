
public class Sudoku {
  private Cell[][] content;
  
  public Sudoku(Cell [][] grid) {
    content = grid;
  }
  
  public String toString() {
    String string = "";
    for (int columnIndex = 0; columnIndex < content.length; columnIndex++) {
      int rowLength = content[columnIndex].length;
      for (int rowIndex = 0; rowIndex < rowLength; rowIndex++) {
        Cell value = content[columnIndex][rowIndex];
        string += value.toString();
      }
      string += "\n";
    }
    return string;
  }

  public void solve() {
    while (hasEmptyCell()) {
      //Cell cellWithTheLeastAmountOfOptions 
    }
  }

  private boolean hasEmptyCell() {
    for (int columnIndex = 0; columnIndex < content.length; columnIndex++) {
      int rowLength = content[columnIndex].length;
      for (int rowIndex = 0; rowIndex < rowLength; rowIndex++) {
        Cell cell = content[columnIndex][rowIndex];
        if (cell.isEmpty()) {
          return true;
        }
      }
    }
    return false;
  }
}
