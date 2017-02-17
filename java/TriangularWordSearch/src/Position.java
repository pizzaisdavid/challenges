
class Position {
  public int height;
  public int width;
  
  public static Position copy(Position position) {
    return new Position(position.height, position.width);
  }
  
  public Position(int height, int width) {
    this.height = height;
    this.width = width;
  }
  
  public void move(Direction direction) {
    switch (direction) {
    case SOUTH_WEST:
      height++;
      break;
    case SOUTH_EAST:
      height++;
      width++;
      break;
    case NORTH_WEST:
      height--;
      width--;
      break;
    case NORTH_EAST:
      height--;
      break;
    case WEST:
      width--;
      break;
    case EAST:
      width++;
      break;
    }
  }
  
  public String toString() {
    return "(h: " + height + ", w: " + width + ")";
  }
  
}