
public class Main {
  
  public static void main(String args[]) {
    int first = 9;
    int second = 10;
    
    int firstLength = first * 2;
    int secondLength = second * 2;
    
    if (first > second) {
      firstTriangleIsBigger(firstLength, secondLength);
    } else {
      secondTriangleIsBigger(firstLength, secondLength);
    }
    
  }  
  
  public static void firstTriangleIsBigger(int firstLength, int secondLength) {
    int firstStemLength = firstLength / 2;
    int secondStemLength =  secondLength / 2;
    
    int firstStem = 0;
    int secondStem = 0;
    
    for (int firstIndex = 0, secondIndex = 0; firstIndex < firstLength + firstStemLength; firstIndex++, secondIndex++) {
      if (firstIndex < firstLength) {
        System.out.print(treeRow(firstLength, firstIndex));
      } else if (firstStem < firstStemLength) {
        System.out.print(spaces(firstLength - 1) + "*");
        firstStem++;
      }
      
      if (firstIndex < firstLength) {
        System.out.print(".");
      }
      
      if (secondIndex < secondLength) {
        System.out.print(treeRowWithNoSpacesOnTheRight(secondLength, secondIndex));
      } else if (secondStem < secondStemLength) {
        System.out.print(spaces(firstLength - 2) + "*");
        secondStem++;
      }
      System.out.println("");
    }
  }
  
  public static void secondTriangleIsBigger(int firstLength, int secondLength) {
    int firstStemLength = firstLength / 2;
    int secondStemLength =  secondLength / 2;
    
    int firstStem = 0;
    int secondStem = 0;
    
    for (int firstIndex = 0, secondIndex = 0; secondIndex < secondLength + secondStemLength; firstIndex++, secondIndex++) {
      if (firstIndex < firstLength) {
        System.out.print(treeRow(firstLength, firstIndex));
      } else if (firstStem < firstStemLength) {
        System.out.print(spaces(firstLength - 1) + "*" + spaces(firstLength - 1));
        firstStem++;
      } else {
        System.out.print(spaces(firstLength * 2 - 1));
      }
      
      
      if (secondIndex < secondLength) {
        System.out.print(treeRowWithNoSpacesOnTheRight(secondLength, secondIndex));
      } else if (secondStem < secondStemLength) {
        System.out.print(spaces(secondLength) + "*");
        secondStem++;
      }
      System.out.println("");
    }
  }
  
  
  public static void trianglesAreTheSame(int firstLength, int secondLength) {
    
  }
  
  public static String treeRow(int length, int row) {
    return spaces(length - 1 - row) + asterisk(row * 2 + 1) + spaces(length - 1 - row);
  }
  
  public static String treeRowWithNoSpacesOnTheRight(int length, int row) {
    return spaces(length - row) + asterisk(row * 2 + 1);
  }
  
  public static String spaces(int count) {
    return stringMultiplication(".", count);
  }
  
  public static String asterisk(int count) {
    return stringMultiplication("*", count);
  }
  
  public static String stringMultiplication(String symbol, int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
      text += symbol;
    }
    return text;
  }

}
