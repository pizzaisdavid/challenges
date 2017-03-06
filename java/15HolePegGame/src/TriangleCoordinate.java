
public class TriangleCoordinate {
  private int x;
  private int y;

  public TriangleCoordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void move(Direction direction) {
    switch (direction) {
    case EAST:
      x++;
      break;
    case NORTH_EAST:
      y--;
      break;
    case NORTH_WEST:
      x--;
      y--;
      break;
    case SOUTH_EAST:
      x++;
      y++;
      break;
    case SOUTH_WEST:
      y++;
      break;
    case WEST:
      x--;
      break;
    default:
      break;
    }
  }

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

}
