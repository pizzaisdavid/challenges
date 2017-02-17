import java.util.ArrayList;

public class Main {
  
  public static void main(String args[]) {
    String characters = "AAAAAA";
    ArrayList<String> list = permutation(characters);
    System.out.println(list);
  }
  
  public static ArrayList<String> permutation(String string) {
    ArrayList<String> list = new ArrayList<String>();
    permutation("", string, list);
    return list;
  }
  
  private static void permutation(String prefix, String string, ArrayList<String> list) {
    if (string.isEmpty() && list.contains(prefix) == false) {
      list.add(prefix);
    } else {
      for (int i = 0; i < string.length(); i++) {
        String leading = prefix + string.charAt(i);
        String rest = string.substring(0, i) + string.substring(i + 1);
        permutation(leading, rest, list);
      }
    }
  }
}
