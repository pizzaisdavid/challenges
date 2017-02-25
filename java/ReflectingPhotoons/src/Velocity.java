
public class Velocity {
  public int x;
  public int y;
  public int pastX;
  public int pastY;
  public Direction direction;
  
  public Velocity(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.pastX = x;
    this.pastY = y;
    this.direction = direction;
    
  }

  public void move(char cell) {
    // cell . / \
    if (cell == '.') {
      moveStraight();
    } else if (cell == '/') {
      direction = hitsForwardSlash();
      moveStraight();
    } else if (cell == '\\') {
      direction = hitsBackwardSlash();
      moveStraight();
    }
  }

  private Direction hitsBackwardSlash() {
    //           \
    switch (direction) {
    case DOWN:
      return Direction.RIGHT;
    case LEFT:
      return Direction.UP;
    case RIGHT:
      return Direction.DOWN;
    case UP:
      return Direction.LEFT;
    default:
      break;
    }
    return direction;
  }

  private Direction hitsForwardSlash() {
    //             /
    switch (direction) {
    case DOWN:
      return Direction.LEFT;
    case LEFT:
      return Direction.DOWN;
    case RIGHT:
      return Direction.UP;
    case UP:
      return Direction.RIGHT;
    default:
      break;
    }
    return direction;
  }

  private void moveStraight() {
    pastX = x;
    pastY = y;
    switch (direction) {
    case DOWN:
      y++;
      break;
    case LEFT:
      x--;
      break;
    case RIGHT:
      x++;
      break;
    case UP:
      y--;
      break;
    default:
      break;
    }
  }
  
  public String toString() {
    return "CURRENT(x=" + x + ", y=" + y + ") PAST(x=" + pastX + ", y=" + pastY + ") DIRECTION=" + direction;
  }
}
