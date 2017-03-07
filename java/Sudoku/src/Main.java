import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    int WIDTH = 9;
    int HEIGHT = 9;
    int count = 1;
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob.out");
    
    while (true) {
      try {
        Cell grid[][] = new Cell[WIDTH][HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
          char row[] = in.nextLine().toCharArray();
          for (int j = 0; j < WIDTH; j++) {
            char value = row[j];
            Coordinate position = new Coordinate(j, i);
            grid[i][j] = new Cell(position, value);
          }
        }
        in.nextLine();
        Sudoku sudoku = new Sudoku(grid);
        sudoku.solve();
        out.println("Case " + count);
        out.println();
        out.println(sudoku.pretty());
        count++;
        System.out.println(sudoku.pretty());
      } catch (Exception e) {
        break;
      }
    }
    in.close();
    out.close();
  }
  
}
