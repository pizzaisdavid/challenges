import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    File file = new File("prob1.txt");
    Scanner in = new Scanner(file);
    PrintWriter out = new PrintWriter("prob1.out");
    int count = 1;
    while (true) {
      int size = in.nextInt();
      if (size == 0) {
        break;
      } else {
        
        ArrayList<String> men = new ArrayList<String>();
        ArrayList<String> women = new ArrayList<String>();
        ArrayList<String> genders = new ArrayList<String>();

        for (int i = 0; i <= size; i++) {
          String line = in.nextLine();
          String[] values = line.split(" ");
          
          if (values.length == 2) {
            String gender = values[0];
            String name = values[1];
            
            genders.add(gender);
            if (gender.equals("M")) {
              men.add(name);
            } else {
              women.add(name);
            }
          }
        }
        
        System.out.println(men);
        men.sort(null);
        System.out.println(men);
        System.out.println(women);
        women.sort(new Comparator<String>() {
          @Override
          public int compare(String a, String b) {
            return b.compareTo(a);
          }
        });
        System.out.println(women);
        
        ArrayList<String> doubleSorted = new ArrayList<String>();
        out.println("Case " + count);
        count++;
        out.println("");
        while (genders.isEmpty() == false) {
          String gender = genders.remove(0);
          String name = "";
          if (gender.equals("M")) {
            out.print("M ");
            name = men.remove(0);
          } else {
            out.print("F ");
            name = women.remove(0);
          }
          out.println(name);
          doubleSorted.add(name);
        }
        out.println("");
        System.out.println(Arrays.toString(doubleSorted.toArray()));
      }
    }
    out.close();
  }
}
