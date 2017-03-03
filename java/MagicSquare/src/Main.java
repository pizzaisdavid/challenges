import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  
  
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("prob1.in"));
    
    boolean[] goal = {
        true, true, true,
        true, false, true,
        true, true, true
      };
    
    while (in.hasNextLine()) {
      boolean[] grid;
      try {
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();
        in.nextLine();
        grid = setup(line1, line2, line3);
      } catch (Exception e) {
        break;
      }
      
      Set<Integer> pool = new HashSet<>();
      for (int i = 1; i < 10; i++) {
        pool.add(i);
      }
      Set<Set<Integer>> combos = powerSet(pool);
      
      int lengthOfCurrentSolution = 1000000;
      Set<Integer> solution = new HashSet<>();
      for (Set<Integer> combo : combos) {
        if (combo.size() < lengthOfCurrentSolution) {
          boolean[] table = grid.clone();
          for (int value : combo) {
            translate(table, value);
          }
          if (isSame(table, goal)) {
            lengthOfCurrentSolution = combo.size();
            solution = combo;
          }
        }      
      }
      System.out.println(solution);
    }
  }
  
  private static boolean[] setup(String line1, String line2, String line3) {
    boolean[] grid = new boolean[9];
    
    grid[0] = line1.charAt(0) == '1';
    grid[1] = line1.charAt(1) == '1';
    grid[2] = line1.charAt(2) == '1';
    
    grid[3] = line2.charAt(0) == '1';
    grid[4] = line2.charAt(1) == '1';
    grid[5] = line2.charAt(2) == '1';
    
    grid[6] = line3.charAt(0) == '1';
    grid[7] = line3.charAt(1) == '1';
    grid[8] = line3.charAt(2) == '1';
    
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

  private static boolean isSame(boolean[] grid, boolean[] s) {
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

  private static void translate(boolean[] grid, int i) {
    switch (i) {
    case 1:
      flip(grid, new int[]{1, 2, 4, 5});
      break;
    case 2:
      flip(grid, new int[]{1, 2, 3});
      break;
    case 3:
      flip(grid, new int[]{2, 3, 5, 6});
      break;
    case 4:
      flip(grid, new int[]{1, 4, 7});
      break;
    case 5:
      flip(grid, new int[]{2, 4, 5, 6, 8});
      break;
    case 6:
      flip(grid, new int[]{3, 6, 9});
      break;
    case 7:
      flip(grid, new int[]{4, 5, 7, 8});
      break;
    case 8:
      flip(grid, new int[]{7, 8, 9});
      break;
    case 9:
      flip(grid, new int[]{5, 6, 8, 9});
      break;
    default:
        break;
    }
  }

  private static void flip(boolean[] grid, int[] flips) {
    for (int i = 0; i < flips.length; i++) {
      int flip = flips[i];
      int index = flip - 1;
      grid[index] = !grid[index];
    }
  }  
}
