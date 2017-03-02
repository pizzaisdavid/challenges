import java.util.ArrayList;

public class Main {
  
  public static void main(String args[]) {
    
    ArrayList<Integer> fits = new ArrayList<Integer>();
    

    int containerWidth = 113;
    int containerLength = 97;
    int containerHeight = 89;
    
    int brickWidth = 13;
    int brickLength = 23;
    int brickHeight = 29;
    
    fits.add(pack(brickWidth, brickLength, brickHeight, containerWidth, containerLength, containerHeight));
    fits.add(pack(brickWidth, brickHeight, brickLength, containerWidth, containerLength, containerHeight));
    fits.add(pack(brickHeight, brickWidth, brickLength, containerWidth, containerLength, containerHeight));
    fits.add(pack(brickHeight, brickLength, brickWidth, containerWidth, containerLength, containerHeight));
    fits.add(pack(brickLength, brickWidth, brickHeight, containerWidth, containerLength, containerHeight));
    fits.add(pack(brickLength, brickHeight, brickWidth, containerWidth, containerLength, containerHeight));
    
    int max = 0;
    for (int i = 0; i < fits.size(); i++) {
      int current = fits.get(i);
      if (max < current) {
        max = current;
      }
    }
    System.out.println(max);
  }

  private static int pack(int boxWidth, int boxLength, int boxHeight, int containerWidth, int containerLength, int containerHeight) {
    System.out.println("BOX(W=" + boxWidth + ", L=" + boxLength + ", H=" + boxHeight + ")");
    System.out.println("CONTAINER(W=" + containerWidth + ", L=" + containerLength + ", H=" + containerHeight + ")");
    
    if (boxWidth > containerWidth ||
        boxHeight > containerHeight ||
        boxLength > containerLength) {
      return 0;
    }
    
    
    int takenUpWidth = 0;
    int widthCount = 0;
    int widthC = 0;
    while (isThereRoomForMore(containerWidth, takenUpWidth, boxWidth)) {
      takenUpWidth += boxWidth;
      widthCount++;
      widthC++;
    }
    
    System.out.println("width: " + widthCount); // 2
    System.out.println("widthC: " + widthC); // 2
        
    int takenUpLength = boxLength;
    int levelCount = widthCount;
    int lengthC = 1;
    while (isThereRoomForMore(containerLength, takenUpLength, boxLength)) {
      takenUpLength += boxLength;
      levelCount += widthCount;
      lengthC++;
    }
     
    System.out.println("level: " + levelCount); // 6
    System.out.println("lengthC: " + lengthC); // 6
    
    int takenUpHeight = boxHeight;
    int count = levelCount;
    int heightC = 1;
    while (isThereRoomForMore(containerHeight, takenUpHeight, boxHeight)) {
      takenUpHeight += boxHeight;
      count += levelCount;
      heightC++;
    }
    
    System.out.println("total: " + count); // 18
    System.out.println("heightC: " + heightC); // 18
    System.out.println("tototoatotol: " + widthC * lengthC * heightC);
    
    return count;
  }

  private static boolean isThereRoomForMore(int total, int usedSpace, int size) {
    return usedSpace + size <= total;
  }
}
