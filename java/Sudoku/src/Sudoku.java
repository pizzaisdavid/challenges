import java.util.Arrays;

public class Sudoku {
  private int WIDTH = 9;
  private int HEIGHT = 9;
  private Cell[][] content;
  private Cell[][] clusters;
  
  public Sudoku(Cell [][] grid) {
    content = grid;
    setupClusters();
  }

  private void setupClusters() {
    /*
     *   0  1  2
     *   3  4  5
     *   6  7  8
     */
    clusters = new Cell[WIDTH][HEIGHT];
    int x = 0;
    int y = 0;
    for (int i = 0; i < 9; i++) {
      System.out.println("I=" + i + " X=" + x + " Y=" + y);
      clusters[i] = new Cell[] {
        content[x + 0][y + 0], content[x + 1][y + 0], content[x + 2][y + 0],
        content[x + 0][y + 1], content[x + 1][y + 1], content[x + 2][y + 1],
        content[x + 0][y + 2], content[x + 1][y + 2], content[x + 2][y + 2]
      };
      System.out.println(Arrays.toString(clusters[i]));
      x += 3;
      if (x == 9) {
        y += 3;
        x = 0;
      }
    }
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
  
  public String toString() {
    /*
    String string = "";
    for (int x = 0; x < content.length; x++) {
      Cell[] column = content[x];
      for (int y = 0; y < column.length; y++) {
        Cell value = content[x][y];
        string += value.toString();
      }
      string += "\n";
    }
    return string;
    */
    
    String text = "";
    text += "board\n";
    for (int x = 0; x < content.length; x++) {
      Cell[] column = content[x];
      for (int y = 0; y < column.length; y++) {
        text += content[x][y];
      }
      text += "\n";
    }
    text += "\n";
    text += "clusters\n";
    for (int x = 0; x < clusters.length; x++) {
      Cell[] cluster = clusters[x];
      for (int y = 0; y < cluster.length; y++) {
        text += clusters[x][y];
      }
      text += "\n";
    }
    
    
    return text;
  }
}
