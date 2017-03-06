import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

enum Direction {
  NORTH_EAST,
  EAST,
  SOUTH_EAST,
  SOUTH_WEST,
  WEST,
  NORTH_WEST
}

public class Main {
  
  private static Cell[][] board;
  
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob6.out");
    int END_FLAG = -1;
    int JUMP_PEG_DISTANCE = 1;
    int LAND_PEG_DISTANCE = 2;
    int count = 1;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      List<Integer> tokens = parse(line);
      if (tokens.get(0) == END_FLAG) {
        break;
      }
      System.out.println(Arrays.toString(tokens.toArray()));
      board = setupBoard(tokens);
      out.println("Case " + count);
      count++;
      
      for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
        Cell[] row = board[rowIndex];
        System.out.println(Arrays.toString(row));
      }
      
      for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
        Cell[] row = board[rowIndex];
        for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
          Cell cell = row[columnIndex];
          if (cell.hasPeg()) {
            for (Direction direction : Direction.values()) {
              
              if (hasPeg(columnIndex, rowIndex, JUMP_PEG_DISTANCE, direction) && isOpen(columnIndex, rowIndex, LAND_PEG_DISTANCE, direction)) {
                System.out.println(direction);
                TriangleCoordinate position = new TriangleCoordinate(columnIndex, rowIndex);
                position.move(direction);
                position.move(direction);
                try {
                  Cell destination = getCell(position);
                  System.out.println(cell.getId() + " -> " + destination.getId());
                  out.println(cell.getId() + " -> " + destination.getId());
                } catch (Exception e) {
                  
                }
              }
            }
          }
        }
      }
      out.println();
    }
    out.close();
  }

  private static boolean hasPeg(int columnIndex, int rowIndex, int JUMP_PEG_DISTANCE, Direction direction) {
    TriangleCoordinate position = new TriangleCoordinate(columnIndex, rowIndex);
    position.move(direction);
    try {
      Cell cell = getCell(position);
      return cell.hasPeg();
    } catch (Exception e) {
      return false;
    }
    
  }
  
  private static boolean isOpen(int columnIndex, int rowIndex, int LAND_PEG_DISTANCE, Direction direction) {
    TriangleCoordinate position = new TriangleCoordinate(columnIndex, rowIndex);
    position.move(direction);
    position.move(direction);
    try {
      Cell cell = getCell(position);
      return cell.hasPeg() == false;
    } catch (Exception e) {
      return false;
    }
  }

  private static Cell getCell(TriangleCoordinate position) throws Exception {
    return board[position.getY()][position.getX()];
  }

  private static Cell[][] setupBoard(List<Integer> tokens) {
    Cell[][] board = {
                                  {new Cell(1)},
                           {new Cell(2), new Cell(3)},
                    {new Cell(4), new Cell(5), new Cell(6)},
             {new Cell(7), new Cell(8), new Cell(9), new Cell(10)},
      {new Cell(11), new Cell(12), new Cell(13), new Cell(14), new Cell(15)}
    };
    
    for (int i = 0; i < tokens.size(); i++) {
      int id = tokens.get(i);
      board = setEmpty(board, id);
    }
    
    return board;
  }

  private static Cell[][] setEmpty(Cell[][] board, int id) {
    for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
      Cell[] row = board[rowIndex];
      for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
        Cell cell = row[columnIndex];
        if (cell.getId() == id) {
          cell.setStatus(false);
          board[rowIndex][columnIndex] = cell;
          break;
        }
      }
    }
    return board;
  }

  private static List<Integer> parse(String line) {
    String tokens[] = line.split(" ");
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i < tokens.length; i++) {
      String text = tokens[i];
      int value = Integer.parseInt(text);
      numbers.add(value);
    }
    return numbers;
  }

}
