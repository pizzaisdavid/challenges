
public class Main {
  public static void main(String args[]) {
    int width = 20;
    String body = "All the leaves are brown and the sky is gray.  I've been for a walk on a winter's day.  I'd be safe and warm if I was in L.A.  California Dreamin' on such a winter day.";
    
    //int width = 5;
    //String body = "a aa aaa aaaa aaaaa aaaa aaa aa a";
    
    print(width, body);
    
  }
  
  public static void print(int width, String body) {
    String line = "";
    String tokens[] = body.split(" ");
    int i = 0;
    while ( i < tokens.length) {
      String word = tokens[i];
      if ((line.length() + 1 + word.length() <= width) || line.isEmpty() && word.length() == width) {
        if (line.isEmpty()) {
          line += word;
        } else {
          line += " " + word;
        }
        i++;
      } else {
        System.out.println(center(width, line));
        line = "";
      }
    }
    if (line.isEmpty() == false) {
      System.out.println(center(width, line));
    }
  }
  
  public static String center(int width, String line) {
    int length = line.length();
    int numberOfSpaces = (width - length) / 2;
    return spaces(numberOfSpaces) + line;
  }
  
  public static String spaces(int count) {
    String message = "";
    for (int i = 0; i < count; i++) {
      message += " ";
    }
    return message;
  }
}
