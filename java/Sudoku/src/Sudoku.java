
public class Sudoku {
  private Cell[][] content;
  
  public Sudoku(char [][] grid) {
    for (int columnIndex = 0; columnIndex < grid.length; columnIndex++) {
      int rowLength = grid[columnIndex].length;
      
      for (int rowIndex = 0; rowIndex < rowLength; rowIndex++) {
        char value = grid[columnIndex][rowIndex];
        Cell cell;
        if (value == ' ') {
          cell = new Cell();
        } else {
          int number = Character.getNumericValue(value);
          cell = new Cell(number);
        }
        content[columnIndex][rowIndex] = cell;
      }
    }
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
}
