
public class Position {
  private double x;
  private double y;
  private Direction direction;
  private int index;

  public Position(int x, int y) {
    this(x, y, Direction.NORTH);
  }

  public Position(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.index = 0;
  }

  public void move(double distance) {
    switch (direction) {
    case EAST:
      x += distance;
      break;
    case NORTH:
      y += distance;
      break;
    case SOUTH:
      y -= distance;
      break;
    case WEST:
      x -= distance;
      break;
    default:
      break;
    
    }
  }

  public void rotate(String command) {
    Direction[] directions = {
        Direction.NORTH,
        Direction.EAST,
        Direction.SOUTH,
        Direction.WEST      
    };
    int modifier = -1;
    if (command.equals("R")) {
      modifier = 1;
    }
    index = (index + modifier) % directions.length;
    if (index < 0) {
      index = 3;
    }
    direction = directions[index];
  }
  
  public String toString() {
    return "(X=" + x + ", Y=" + y + "), DIRECTION=" + direction;
  }

  public double distance(Position position) {
    double distance = Math.sqrt(Math.pow(x - position.x, 2) + Math.pow(y - position.y, 2));
    return Math.round(distance * 100.0) / 100.0;
  }
}
