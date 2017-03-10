import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    
    Scanner in = new Scanner(new File("prob2.in"));
    PrintWriter out = new PrintWriter("prob2.out");
    
    int count = 1;
    while(in.hasNextInt()) {
      int size = in.nextInt();
      if (size == 0) {
        break;
      }
      int answer = riffle(size);
      out.println("Case " + count + ": President Snow should shuffle the deck " + answer + " times.");
      out.println();
      count++;
    }
    out.close();
  }

  private static int riffle(int size) {
    Deck deck = new Deck(size);
    int count = 1;
    deck.riffle();
    while (deck.isShuffled()) {
      count++;
      deck.riffle();
    }
    return count;
  }
  
}
