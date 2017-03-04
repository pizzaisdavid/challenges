
public class Main {
  
  public static void main(String args[]) {
    int rings = 2;
    int core = 4;
    
    for (int i = 1; i <= rings; i++) {
      System.out.println(space(rings - i) + forwardSlash(i) + dash(core) + backwardSlash(i));
    }
    
    for (int i = 0; i < core; i++) {
      System.out.println(pipe(rings) + space(core) + pipe(rings));
    }
    
    for (int i = 0; i < rings; i++) {
      System.out.println(space(i) + backwardSlash(rings - i) + dash(core) + forwardSlash(rings - i));
    }
    
  }

  private static String backwardSlash(int count) {
    return stringMultiplication("\\", count);
  }

  private static String dash(int count) {
    return stringMultiplication("-", count);
  }

  private static String forwardSlash(int count) {
    return stringMultiplication("/", count);
  }

  private static String space(int count) {
    return stringMultiplication(".", count);
  }

  private static String pipe(int count) {
    return stringMultiplication("|", count);
  }

  private static String stringMultiplication(String string, int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += string;
    }
    return text;
  }
}
