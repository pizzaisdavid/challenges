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
    double time = 0;
    while (true) {
      if (player.isInBounds() == false || ghosts.isEmpty()) {
        return -1;
      }
      time += 0.5;
      player.move();
      for (int i = 0; i < ghosts.size(); i++) {
        Person ghost = ghosts.get(i);
        if (ghost.isStandingOn(player)) {
          return time;
        }
      }
      time += 0.5;
      for (int i = 0; i < ghosts.size(); i++) {
        Person ghost = ghosts.get(i);
        ghost.move();
        if (ghost.isStandingOn(player)) {
          return time;
        }
        if (ghost.isInBounds() == false) {
          ghosts.remove(i);
        }
      }
    }
  }

  public class Person {
    private int x;
    private int y;
    private String direction;

    public Person(int x, int y, String direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }
    
    public boolean isStandingOn(Person player) {
      return x == player.x && this.y == player.y;
    }

    public String toString() {
      return x + " " + y + " " + direction;
    }
    
    public boolean isInBounds() {
      return isBetween(-100, x, 100) && isBetween(-100, y, 100);
    }
    
    public boolean isBetween(int min, int value, int max) {
      return value >= min && value <= max;
    }
    
    public void move() {
      switch (direction) {
      case "N":
        y++;
        break;
      case "E":
        x++;
        break;
      case "S":
        y--;
        break;
      case "W":
        x--;
        break;
      }
    }
  }
}
