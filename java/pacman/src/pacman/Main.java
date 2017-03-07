package pacman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

enum Direction {
  UP,
  RIGHT, 
  DOWN,
  LEFT
}


public class Main {

  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob6.in"));
    PrintWriter out = new PrintWriter("prob6.out");
    
    while (in.hasNextInt()) {
      int width = in.nextInt();
      int height = in.nextInt();
      if (width == 0) {
        break;
      }
      System.out.println("WIDTH=" + width + ", HEIGHT=" + height);
      in.nextLine();
      char [][] board = new char[height][width];
      for (int i = 0; i < height; i++) {
        board[i] = in.nextLine().toCharArray();
        System.out.println(Arrays.toString(board[i]));
      }
      
      Coordinate destination = null;
      Coordinate position = null;
      Coordinate previous = null;
      
      for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
        char[] row = board[rowIndex];
        for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
          char cell = row[columnIndex];
          switch (cell) {
          case 'X':
            destination = new Coordinate(columnIndex, rowIndex, cell);
            break;
          case 'P':
            position = new Coordinate(columnIndex, rowIndex, cell);
            break;      
          case 'p':
            previous = new Coordinate(columnIndex, rowIndex, cell);
            break;
          default:
            break;
          }
        }
      }
      System.out.println("DEST=" + destination);
      System.out.println("POSI=" + position);
      System.out.println("PREV=" + previous);
      
      int x = position.getX();
      int y = position.getY();
      List<Coordinate> possibleMoves = new ArrayList<Coordinate>();
      Coordinate up = new Coordinate(x, y - 1,    get(board, x, y - 1), Direction.UP);
      Coordinate right = new Coordinate(x + 1, y, get(board, x + 1, y), Direction.RIGHT);
      Coordinate down = new Coordinate(x, y + 1,  get(board, x, y + 1), Direction.DOWN);
      Coordinate left = new Coordinate(x - 1, y,  get(board, x - 1, y), Direction.LEFT);
      
      if (up.isOpen()) {
        possibleMoves.add(up);
      }
      if (right.isOpen()) {
        possibleMoves.add(right);
      }
      if (down.isOpen()) {
        possibleMoves.add(down);
      }
      if (left.isOpen()) {
        possibleMoves.add(left);
      }
      
      System.out.println("MOVES=" + Arrays.toString(possibleMoves.toArray()));
      
      Coordinate move = null;
      if (possibleMoves.size() == 1) {
        System.out.println("1 MOVE POSSIBLE");
        move = possibleMoves.get(0);
        board[destination.getY()][destination.getX()] = ' ';
      } else {
        List<Coordinate> closest = findClosestMove(destination, possibleMoves);
        if (closest.size() == 1) {
          move = closest.get(0);
        } else {
          move = breakTie(possibleMoves);
        }
        
      }
      
      board[destination.getY()][destination.getX()] = ' ';
      board[position.getY()][position.getX()] = ' ';
      board[previous.getY()][previous.getX()] = ' ';
      board[move.getY()][move.getX()] = 'P';
      
      System.out.println("MOVE");
      for (int i = 0; i < height; i++) {
        System.out.println(Arrays.toString(board[i]));
      }
      
      for (int i = 0; i < height; i++) {
        char[] row = board[i];
        for (int j = 0; j < row.length; j++) {
          char cell = row[j];
          out.print(cell);
        }
        out.println();
      }
      out.println();
    }
    in.close();
    out.close();
  }

  private static Coordinate breakTie(List<Coordinate> possibleMoves) {
    // there was a tie
    // up, left, down
    for (int i = 0; i < possibleMoves.size(); i++) {
      Coordinate possibleMove = possibleMoves.get(i);
      if (possibleMove.getDirection() == Direction.UP) {
        return possibleMove;
      }
    }
    for (int i = 0; i < possibleMoves.size(); i++) {
      Coordinate possibleMove = possibleMoves.get(i);
      if (possibleMove.getDirection() == Direction.LEFT) {
        return possibleMove;
      }
    }
    for (int i = 0; i < possibleMoves.size(); i++) {
      Coordinate possibleMove = possibleMoves.get(i);
      if (possibleMove.getDirection() == Direction.DOWN) {
        return possibleMove;
      }
    }
    return null;
  }

  private static List<Coordinate> findClosestMove(Coordinate destination, List<Coordinate> moves) {
    List<Coordinate> smallest = new ArrayList<Coordinate>();
    double smallestDistance = findSmallestDistance(destination, moves);
    for (int i = 0; i < moves.size(); i++) {
      Coordinate move = moves.get(0);
      double distance = destination.distance(move);
      double difference = Math.abs(smallestDistance - distance);
      if (difference <= 0.00001) {
        smallest.add(move);
      }
    }
    System.out.println("smallest: " + Arrays.toString(smallest.toArray()));
    return smallest;
  }

  private static double findSmallestDistance(Coordinate destination, List<Coordinate> moves) {
    double smallest = destination.distance(moves.get(0));
    for (int i = 0; i < moves.size(); i++) {
      Coordinate current = moves.get(i);
      double distance = destination.distance(current);
      if (distance < smallest) {
        smallest = distance;
      }
    }
    return smallest;
  }


  private static char get(char[][] board, int x, int y) {
    return board[y][x];
  }
}
