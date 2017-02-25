import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String args[]) {
    ArrayList<Integer> jedis = new ArrayList();
    for (int i = 0; i < 1000; i++) {
      jedis.add(i);
    }
    ArrayList<Integer> empty = new ArrayList();
    permutations(empty, jedis);
  }
  
  public static void permutations(ArrayList<Integer> prefix, ArrayList<Integer> content) {
    if (content.size() == 0) {
      System.out.println(Arrays.toString(prefix.toArray()));
    } else {
      for (int i = 0; i < content.size(); i++) {
        ArrayList<Integer> ass = new ArrayList(content);
        ArrayList<Integer> leading = new ArrayList(prefix);
        leading.add(ass.remove(i));
        permutations(leading, ass);
      }
    }
    
  }
}
