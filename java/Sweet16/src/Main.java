import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    /*
     * 
     *  MAKE IT REMEMBER THE ANSWER TO PREVIOUS AND BUILD OFF THAT.
     */
    Scanner in = new Scanner (new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob6.out");
    
    int count = 1;
    while (in.hasNextInt()) {
      
      int size = in.nextInt();
      if (size == 0) {
        break;
      }
      
      System.out.println(size);
      
      List<Integer> teams = new ArrayList<Integer>();
      teams.add(1);
      
      int v = 1; 
      while (v < size) {
        teams = timetravel(teams, v);
        v *= 2;
      }
      
      String text = "";
      while (teams.isEmpty() == false) {
        int team = teams.remove(teams.size() - 1);
        text += " " + team;
      }      
      out.println("Case " + count + ":" + text);
      out.println();
      count++;
    }
    System.out.println("DONE");
    in.close();
    out.close();
  }

  private static List<Integer> timetravel(List<Integer> teams, int v) {
    List<Integer> defeated = makeDefeated(max(teams), v);
    return insertDefeated(teams, defeated);
    
  }

  private static List<Integer> insertDefeated(List<Integer> teams, List<Integer> defeated) {
    
    // find smallest by index
    // pop the last of defeated off right behind it
    // repeat
    int smallest = 1;
    while (defeated.isEmpty() == false) {
      int index = teams.indexOf(smallest);
      int largestLoser = defeated.remove(defeated.size() - 1);
      teams.add(index + 1, largestLoser);
      smallest++;
    }
    return teams;
  }

  private static List<Integer> makeDefeated(int max, int v) {
    List<Integer> d = new ArrayList<Integer>();
    for (int i = max + 1; i <= max + v; i++) {
      d.add(i);
    }
    //System.out.println(Arrays.toString(d.toArray()));
    return d;
  }

  private static int max(List<Integer> teams) {
    int max = teams.get(0);
    for (int t : teams) {
      if (t > max) {
        max = t;
      }
    }
    return max;
  }
}
