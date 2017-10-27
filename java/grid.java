import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob6.out");

    while (in.hasNextInt()) {
      int width = in.nextInt();
      int height = in.nextInt();
      if (width == 0) {
        break;
      }
      System.out.println("WIDTH=" + width + ", HEIGHT=" + height);
      in.nextLine();
      char [][] board = new char[height][width];
      for (int i = 0; i < height; i++) {
        board[i] = in.nextLine().toCharArray();
        System.out.println(Arrays.toString(board[i]));
      }
    }
  }
}