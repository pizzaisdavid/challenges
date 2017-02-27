import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(new File("prob4.txt"));
    int count = 1;
    while (in.hasNextLine()) {
      double distance = journey(in.nextLine());
      String formattedDistance = distance + "";
      if (formattedDistance.endsWith("0")) {
        formattedDistance += "0";
      }
      String message = "Case " + count + ": Frodo is " + formattedDistance + " miles from the starting point.";
      System.out.println(message);
      System.out.println();
      count++;
    }
  }

  private static double journey(String raw) {
    Position position = new Position(0, 0, Direction.NORTH);
    String[] commands = raw.split(" ");
    
    for (int i = 0; i < commands.length; i++) {
      String command = commands[i];
      try {
        double distance = Double.parseDouble(command);
        position.move(distance);
      } catch (Exception e) {
        position.rotate(command);
      }
    }
    Position end = new Position(0, 0);    
    return end.distance(position);
  }
}
