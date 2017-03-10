import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
  private int size;
  private List<Integer> content;

  public Deck(int size) {
    this.size = size;
    content = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      content.add(i);
    }
    //System.out.println(Arrays.toString(content.toArray()));
  }

  public boolean isShuffled() {
    for (int i = 0; i < size; i++) {
      int value = content.get(i);
      if (value != i) {
          return true;
      }
    }
    return false;
  }

  public void riffle() {
    int left = (int) Math.ceil(size / 2.0);
    int right = size / 2;
    //.out.println(left);
    //System.out.println(right);
    
    List<Integer> leftHand = new ArrayList<Integer>();
    List<Integer> rightHand = new ArrayList<Integer>();
    
    for (int i = 0; i < left; i++) {
      leftHand.add(content.remove(0));
    }
    
    for (int i = 0; i < right; i++) {
      rightHand.add(content.remove(0));
    }
    //System.out.println("L: " + Arrays.toString(leftHand.toArray()));
    //System.out.println("R: " + Arrays.toString(rightHand.toArray()));
    
    riffle(leftHand, rightHand);
    //System.out.println(Arrays.toString(content.toArray()));
  }

  private void riffle(List<Integer> leftHand, List<Integer> rightHand) {
    if (leftHand.size() > rightHand.size()) {
      System.out.println("ODD");
      riffleLeftIsLonger(leftHand, rightHand);
    } else {
      System.out.println("EVEN");
      riffleEven(leftHand, rightHand);
    }
  }

  private void riffleLeftIsLonger(List<Integer> leftHand, List<Integer> rightHand) {
    content.add(leftHand.remove(leftHand.size() - 1));
    while (leftHand.isEmpty() == false) {
      content.add(0, rightHand.remove(leftHand.size() - 1));
      content.add(0, leftHand.remove(leftHand.size() - 1));
    }
  }
  
  private void riffleEven(List<Integer> leftHand, List<Integer> rightHand) {
    while (leftHand.isEmpty() == false) {
      content.add(0, leftHand.remove(leftHand.size() - 1));
      content.add(0, rightHand.remove(rightHand.size() - 1));
    }
  }
}
