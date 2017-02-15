package brains;


public class Main {
  
  public static void main(String args[]) {
    int length = 3;
    
    for (int i = length; i > 0; i--) {
      System.out.println(spaces(i)  + fowardSlashes(i, length) + "^" + backwardSlashes(i, length));
    }
    
    String front = "";
    String back = "";
    for (int i = 0; i < length; i ++) {
      front += "<";
      back += ">";
    }
    
    System.out.println(front + " " + back);

    
    for (int i = 0; i < length; i++) {
      System.out.println(spaces(i + 1)  + backwardSlashes(i, length -1) + "v" + fowardSlashes(i, length -1));
    }
  }
  
  public static String spaces(int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += " ";
    } 
    return text;
  }
  
  public static String fowardSlashes(int poop, int length) {
    // return loop(length-pooop, "/");
    String text = "";
    for (int i = 0; i < length-poop; i++) {
      text += "/";
    }
    return text; 
  }

  public static String backwardSlashes(int poop, int length) {
    String text = "";
    for (int i = 0; i < length-poop; i++) {
      text += "\\";
    }
    return text; 
  }
}
