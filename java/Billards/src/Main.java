import java.io.File;
import java.util.Scanner;

import javax.swing.text.Position;

enum Direction {
  NORTH_WEST,
  NORTH_EAST,
  SOUTH_EAST,
  SOUTH_WEST
};

public class Main {
  
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(new File("prob5.in"));
    int count = 1;
    while (true) {
      double length = in.nextDouble();
      double width = in.nextDouble();
      if (length == 0 && width == 0) {
        break;
      }
      /*
       *    N
       *  W + E
       *    S
       */
      System.out.println(length + " " + width);
      Point NORTH_WEST_CORNER = new Point(0.0, 0.0);
      Point NORTH_EAST_CORNER = new Point(width, 0.0);
      Point SOUTH_EAST_CORNER = new Point(width, length);
      Point SOUTH_WEST_CORNER = new Point(0.0, length);
      Point[] CORNERS = {
        NORTH_WEST_CORNER,
        NORTH_EAST_CORNER,
        SOUTH_EAST_CORNER,
        SOUTH_WEST_CORNER
      };
      Direction[] directions = {
        Direction.NORTH_WEST,
        Direction.NORTH_EAST,
        Direction.SOUTH_EAST,
        Direction.SOUTH_WEST
      };
      
      Point position = new Point(width, length, Direction.NORTH_WEST);
      int bounces = 0;
      do {
        //position.move();
        bounces++;
        System.out.println(bounces);
      } while (isInCorner(CORNERS, position) == false);
      System.out.println("Case " + count + ": There will be "+ bounces + " ricochet(s).");
      count++;
    }
  }

  private static boolean isInCorner(Point[] corners, Point position) {
    for (int i = 0; i < corners.length; i++) {
      if (corners[i].equals(position)) {
        return true;
      }
    }
    return false;
  }
}
