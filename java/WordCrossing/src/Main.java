import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Direction {
  VERTICAL,
  HORIZONTAL
}

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob6.out");
    
    while (in.hasNextLine()) {
      int height = in.nextInt();
      int width = in.nextInt();
      in.nextLine();
      char[][] board = new char[height][width];
      for (int i = 0; i < height; i++) {
        board[i] = in.nextLine().toCharArray();
      }
      int count = in.nextInt();
      in.nextLine();
      List<String> words = new ArrayList<String>();
      for (int i = 0; i < count; i++) {
        String word = in.nextLine();
        words.add(word);
      }
      
      CrossWord game = new CrossWord(board);
      game.solve(words);
      
    }
  }
}
