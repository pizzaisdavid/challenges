import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  
  private static int caseNumber;
  
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob.in"));
    PrintWriter out = new PrintWriter("prob.out");
    
    caseNumber = 1;
    
    while (true) { 
      Person player = new Main().new Person(in.nextInt(), in.nextInt(), in.next());
      if (player.direction.equals("0")) {
        break;
      }
      in.nextLine();
      
      int count = in.nextInt();
      ArrayList<Person> ghosts = new ArrayList<Person>();
      for (int i = 0; i < count; i++) {
        try {
          ghosts.add(new Main().new Person(in.nextInt(), in.nextInt(), in.next()));
          in.nextLine(); 
        } catch (Exception e) {
          
        }
      }
      
      double time = simulate(player, ghosts);
      System.out.print("case " + caseNumber + ": ");
      if (time < 0) {
        System.out.println("SAFE");
      } else {
        System.out.println(time);
      }
      caseNumber++;
    }
    in.close();
    out.close();
  }
  
  private static double simulate(Person player, ArrayList<Person> ghosts) {
    
  }
}