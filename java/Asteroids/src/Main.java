import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  private static char SPACE = ' ';
  private static char[][] screen;
  
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob4.in"));
    PrintWriter out = new PrintWriter("prob4.out");
    screen = setupBlankScreen();
    while (in.hasNextInt()) {
      int x = in.nextInt();
      int y = in.nextInt();
      int type = in.nextInt();
      System.out.println("X=" + x + " Y=" + y + " TYPE=" + type);
      addAsteriod(x, y, type);
    }
    for (int i = 0; i < screen.length; i++) {
      char[] row = screen[i];
      for (int j = 0; j < row.length; j++) {
        char cell = row[j];
        out.print(cell);
      }
      out.println();
    }
    out.close();
    System.out.println("DONE");
  }

  private static void addAsteriod(int x, int y, int type) {
    char[][] asteriod = getAsteriod(type);
    add(x, y, asteriod);
  }

  private static void add(int x, int y, char[][] asteriod) {
    int tempY = y;
    for (int i = 0; i < asteriod.length; i++) {
      char[] row = asteriod[i];
      int tempX = x;
      for (int j = 0; j < row.length; j++) {
        char cell = row[j];
        if (cell == '\0') {
          System.out.print(" ");
        } else {
          System.out.print(cell);
          System.out.println("X=" + tempX + " Y=" + tempY);
          screen[tempY][tempX] = cell;   
        }
        tempX++;
        if (tempX == 20) {
          tempX = 0;
        }
      }
      tempY++;
      if (tempY == 20) {
        tempY = 0;
      }
      System.out.println();
    }
  }

  private static char[][] getAsteriod(int type) {
    switch (type) {
    case 1:
      return new char[][] {
        {'/', '-', '\\'},
        {'|', ' ', '|'},
        {'|', ' ', '\\', '-', '-', '-', '\\'},
        {'|', ' ',  ' ', ' ', ' ', ' ', '|'},
        {'\\', '-', '-', '-', '-', '-', '/'}
      };
    case 2:
      return new char[][] {
        {'\\', '-', '-', '-', '\\'},
        {'\0', '\\', ' ', ' ', ' ', '\\'},
        {'\0', '\0', '\\', ' ', ' ', ' ', '\\'},
        {'\0', '\0', '\0', '\\', '-', '-', '-', '\\'}
      };
    case 3:
      return new char[][] {
        {'/', '-', '-', '\\'},
        {'|', ' ', '/'},
        {'|', ' ', '\\'},
        {'\\', '-', '-', '/'}
      };
    default:
      System.out.println("ERROR");
      return new char[][] {{}};
    }
  }

  private static char[][] setupBlankScreen() {
    int width = 20;
    int height = 20;
    
    char[][] screen = new char[height][width];
    
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        screen[i][j] = SPACE;
      }
    }
    return screen;
  }

}
