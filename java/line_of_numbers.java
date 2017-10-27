  
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
      go(x, y, type);
    }
  }

  public static void go(int x, int y, int type) {
    
  }
}