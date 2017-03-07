package pacman;

public class Coordinate {
  private int x;
  private int y;
  private char value;
  private Direction direction;
  
  public Coordinate(int x, int y, char value, Direction direction) {
    this(x, y, value);
    this.direction = direction;
  }
  
  public Coordinate(int x, int y, char value) {
    this.x = x;
    this.y = y;
    this.value = value;
  }
  
  public String toString() {
    return "(X=" + x + ", Y=" + y + ") VALUE='" + value + "'";
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
  
  public Direction getDirection() {
    return direction;
  }

  public boolean isOpen() {
    return value == ' ' || value == 'X';
  }

  public double distance(Coordinate other) {
    return Math.sqrt(Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2));
  }
}
