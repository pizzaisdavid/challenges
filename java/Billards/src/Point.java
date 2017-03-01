
public class Point {
  private double x;
  private double y;
  private Direction direction;
  
  public Point(double x, double y) {
    this(x, y, Direction.NORTH_WEST);
  }
  
  public Point(double x, double y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }
  
  public boolean equals(Point other) {
    return x == other.x && y == other.y;
  }
}
