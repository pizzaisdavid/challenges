import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    int WIDTH = 9;
    int HEIGHT = 9;
    
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob.out");
    
    Cell grid[][] = new Cell[WIDTH][HEIGHT];
    
    for (int i = 0; i < HEIGHT; i++) {
      char row[] = in.nextLine().toCharArray();
      for (int j = 0; j < WIDTH; j++) {
        char value = row[j];
        Coordinate position = new Coordinate(j, i);
        grid[i][j] = new Cell(position, value);
      }
    }
    
    Sudoku sudoku = new Sudoku(grid);
    sudoku.solve();
    System.out.println(sudoku);
    
    
    in.close();
    out.close();
  }
  
}
