import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
  private int WIDTH = 9;
  private int HEIGHT = 9;
  private Cell[][] content;
  private Cell[][] clusters;
  private Cell[][] verticals;
  
  public Sudoku(Cell [][] grid) {
    content = grid;
    setupClusters();
    setupVerticals();
    updateCellConstrictions();
  }

  private void updateCellConstrictions() {
    System.out.println("Updating based on normal table");
    updateConstrictions(content);
    System.out.println("Updating based on clusters table");
    updateConstrictions(clusters);
    System.out.println("Updating based on verticals table");
    updateConstrictions(verticals);
  }

  private void updateConstrictions(Cell[][] table) {
    for (int i = 0; i < table.length; i++) {
      Cell[] sequence = table[i];
      for (int j = 0; j < sequence.length; j++) {
        table[i][j].update(sequence);
      }
    }
  }

  private void setupVerticals() {
    verticals = new Cell[WIDTH][HEIGHT];
    for (int i = 0; i < content.length; i++) {
      verticals[i] = new Cell[] {
        content[0][i],
        content[1][i],
        content[2][i],
        content[3][i],
        content[4][i],
        content[5][i],
        content[6][i],
        content[7][i],
        content[8][i]
      };
    }

  }

  private void setupClusters() {
    clusters = new Cell[WIDTH][HEIGHT];
    int x = 0;
    int y = 0;
    for (int i = 0; i < 9; i++) {
      System.out.println("I=" + i + " X=" + x + " Y=" + y);
      clusters[i] = new Cell[] {
        content[x + 0][y + 0], content[x + 0][y + 1], content[x + 0][y + 2],
        content[x + 1][y + 0], content[x + 1][y + 1], content[x + 1][y + 2],
        content[x + 2][y + 0], content[x + 2][y + 1], content[x + 2][y + 2]
      };
      System.out.println(Arrays.toString(clusters[i]));
      y += 3;
      if (y == 9) {
        x += 3;
        y = 0;
      }
    }
  }

  public void solve() {
    while (hasEmptyCell()) {
      updateCellConstrictions();
      Scanner reader = new Scanner(System.in);
      System.out.println(pretty());
      reader.nextLine();
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
    String text = "";
    
    text += "\n";    
    text += "verticals\n";
    for (int x = 0; x < verticals.length; x++) {
      Cell[] vertical = verticals[x];
      for (int y = 0; y < vertical.length; y++) {
        text += verticals[x][y];
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
    text += "\n";
    text += "board\n";
    for (int x = 0; x < content.length; x++) {
      Cell[] column = content[x];
      for (int y = 0; y < column.length; y++) {
        text += content[x][y];
      }
      text += "\n";
    }
    return text;
  }

  public String pretty() {
    String text = "";
    for (int x = 0; x < content.length; x++) {
      Cell[] column = content[x];
      for (int y = 0; y < column.length; y++) {
        text += content[x][y];
      }
      text += "\n";
    }
    return text;
  }
}
