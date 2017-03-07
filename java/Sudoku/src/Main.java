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
    PrintWriter out = new PrintWriter("prob6.out");
    System.out.println("SHIT");
    while (true) {
      try {
        Cell grid[][] = new Cell[WIDTH][HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
          char row[] = in.nextLine().toCharArray();
          for (int j = 0; j < WIDTH; j++) {
            char value = row[j];
            System.out.print(value);
            grid[i][j] = new Cell(value);
          }
          System.out.println();
        }
        try {
        in.nextLine();
        } catch(Exception e) {
          System.out.println("fail");
        }
        Sudoku sudoku = new Sudoku(grid);
        sudoku.solve();
        out.println("Case " + count);
        out.println();
        out.println(sudoku.pretty());
        System.out.println("Case " + count);
        System.out.println(sudoku.pretty());
        count++;
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("FAILED TO PARSE");
        break;
      }
    }
    in.close();
    out.close();
  }
  
}
