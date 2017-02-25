import java.util.HashMap;
import java.util.Map;


public class Main {
  private static Map<Integer, Integer> solutions;
  private static char[][] map;
  private static int width;
  private static int height;
  
  public static void main(String args[]) {
    solutions = new HashMap<Integer, Integer>();
    /*
    width = 3;
    height = 2;
    map = new char[][] {
      {'.', '/', '.'},
      {'.', '.', '\\'}
    };
    */
    
    width = 3;
    height = 3;
    map = new char[][] {
      {'.', '.', '.'},
      {'/', '/', '/'},
      {'.', '.', '.'},
    };
    
    
    for (int i = 0; i < width; i++) {
      Velocity start = new Velocity(i, 0, Direction.DOWN);
      int startNumber = convertReverse(start);
      Velocity end = transverse(start);
      int endNumber = convert(end);
      if (startNumber < endNumber) {
        System.out.println(startNumber + "<-->" + endNumber);
      }
    }
    
    for (int i = 0; i < height; i++) {
      Velocity start = new Velocity(width - 1, i, Direction.LEFT);
      int startNumber = convertReverse(start);
      Velocity end = transverse(start);
      int endNumber = convert(end);
      if (startNumber < endNumber) {
        System.out.println(startNumber + "<-->" + endNumber);
      }
    }
    
    for (int i = 0; i < width; i++) {
      Velocity start = new Velocity(i, height - 1, Direction.UP);
      int startNumber = convertReverse(start);
      Velocity end = transverse(start);
      int endNumber = convert(end);
      if (startNumber < endNumber) {
        System.out.println(startNumber + "<-->" + endNumber);
      }
    }
    
    for (int i = 0; i < height; i++) {
      Velocity start = new Velocity(0, i, Direction.RIGHT);
      int startNumber = convertReverse(start);
      Velocity end = transverse(start);
      int endNumber = convert(end);
      if (startNumber < endNumber) {
        System.out.println(startNumber + "<-->" + endNumber);
      }
    }
  }

  private static Velocity transverse(Velocity velocity) {
    char cell = getContent(velocity);
    while(cell != ' ') {
      velocity.move(cell);
      cell = getContent(velocity);
    }
    return velocity;
  }
  
  private static int convertReverse(Velocity velocity) {
    //System.out.println(velocity.toString());

    int x = velocity.x;
    int y = velocity.y;
    int max = width * 2 + height * 2;
    switch (velocity.direction) {
    case UP:
      return max - (x + height);
    case RIGHT:
      return max - y;
    case LEFT:
      return x + y + 2;
    case DOWN:
      return x + 1;
    default:
      return 0;
    }
  }
  
  private static int convert(Velocity velocity) {
    //System.out.println(velocity.toString());
    int x = velocity.pastX;
    int y = velocity.pastY;
    int max = width * 2 + height * 2;
    switch (velocity.direction) {
    case DOWN:
      return max - (x + height);
    case LEFT:
      return max - y;
    case RIGHT:
      return x + y + 2;
    case UP:
      return x + 1;
    default:
      return 0;
    }
  }

  private static char getContent(Velocity velocity) {
    try {
      return map[velocity.y][velocity.x];
    } catch (Exception e) {
      return ' ';
    }
  }
}
