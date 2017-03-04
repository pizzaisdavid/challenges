import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob1.in"));
    
    char[] GOAL = {
      '1', '1', '1',
      '1', '0', '1',
      '1', '1', '1'
    };
    
    Set<Integer> pool = new HashSet<>();
    for (int i = 1; i < 10; i++) {
      pool.add(i);
    }
    Set<Set<Integer>> COMBOS = powerSet(pool);

    
    while (in.hasNextLine()) {
      char[] grid;
      try {
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();
        in.nextLine();
        grid = setup(line1, line2, line3);
      } catch (Exception e) {
        break;
      }
      
      for (Set<Integer> combo : COMBOS) {
        char[] table = grid.clone();
        for (int value : combo) {
          translate(table, value);
        }
        if (isSame(table, GOAL)) {
          System.out.println(combo);
        }
      }
    }
    in.close();
  }
  
  private static char[] setup(String line1, String line2, String line3) {
    char[] grid = new char[9];
    
    grid[0] = line1.charAt(0);
    grid[1] = line1.charAt(1);
    grid[2] = line1.charAt(2);
    
    grid[3] = line2.charAt(0);
    grid[4] = line2.charAt(1);
    grid[5] = line2.charAt(2);
    
    grid[6] = line3.charAt(0);
    grid[7] = line3.charAt(1);
    grid[8] = line3.charAt(2);
    
    return grid;
  }

  public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
    Set<Set<T>> sets = new HashSet<Set<T>>();
    if (originalSet.isEmpty()) {
        sets.add(new HashSet<T>());
        return sets;
    }
    List<T> list = new ArrayList<T>(originalSet);
    T head = list.get(0);
    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
    for (Set<T> set : powerSet(rest)) {
        Set<T> newSet = new HashSet<T>();
        newSet.add(head);
        newSet.addAll(set);
        sets.add(newSet);
        sets.add(set);
    }  
    return sets;
  }

  private static boolean isSame(char[] grid, char[] s) {
    if (grid.length != s.length) {
      return false;
    }
    for (int i = 0; i < grid.length; i++) {
      if (grid[i] != s[i]) {
        return false;
      }
    }
    return true;
  }

  private static void translate(char[] grid, int i) {
    Map<Integer, int[]> rules = new HashMap<Integer, int[]>();
    
    // corners
    rules.put(1, new int[]{1, 2, 4, 5});
    rules.put(3, new int[]{2, 3, 5, 6});
    rules.put(7, new int[]{4, 5, 7, 8});
    rules.put(9, new int[]{5, 6, 8, 9});
    
    // edges
    rules.put(2, new int[]{1, 2, 3});
    rules.put(4, new int[]{1, 4, 7});
    rules.put(6, new int[]{3, 6, 9});
    rules.put(8, new int[]{7, 8, 9});
    
    // middle
    rules.put(5,  new int[]{2, 4, 5, 6, 8});

    flip(grid, rules.get(i));
  }

  private static void flip(char[] grid, int[] flips) {
    for (int i = 0; i < flips.length; i++) {
      int flip = flips[i];
      int index = flip - 1;
      grid[index] = flip(grid[index]);
    }
  }

  private static char flip(char c) {
    if (c == '0') {
      return '1';
    }
    return '0';
  }  
}
