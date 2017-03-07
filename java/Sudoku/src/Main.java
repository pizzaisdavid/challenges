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
    
    for (int x = 0; x < WIDTH; x++) {
      char column[] = in.nextLine().toCharArray();
      for (int y = 0; y < HEIGHT; y++) {
        char value = column[y];
        Coordinate position = new Coordinate(x, y);
        grid[x][y] = new Cell(position, value);
      }
    }
    
    Sudoku sudoku = new Sudoku(grid);
    //sudoku.solve();
    System.out.println(sudoku);
    
    
    in.close();
    out.close();
  }
  
}
