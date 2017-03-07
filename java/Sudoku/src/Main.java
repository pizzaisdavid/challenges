import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    int HEIGHT = 9;
    int WIDTH = 9;
    
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob.out");
    
    Cell grid[][] = new Cell[HEIGHT][WIDTH];
    
    for (int i = 0; i < HEIGHT; i++) {
      char row[] = in.nextLine().toCharArray();
      for (int k = 0; k < WIDTH; k++) {
        char value = row[k];
        Coordinate position = new Coordinate(k, i);
        grid[i][k] = new Cell(value);
      }
    }
    
    Sudoku sudoku = new Sudoku(grid);
    sudoku.solve();
    System.out.println(sudoku);
    
    
    in.close();
    out.close();
  }
  
}
