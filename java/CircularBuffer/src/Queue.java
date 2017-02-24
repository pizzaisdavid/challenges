
public class Queue {
  private int size;
  private char content[];
  private int writeIndex;
  private int readIndex;
  
  public Queue(int size) {
    this.size = size;
    content = new char[size];
    readIndex = 0;
    writeIndex = 0;
  }
  
  public String read(int count) {
    String message = "";
    if (isEmpty() == false) {
      
    }
    
    return message;
  }
  
  public void write(String text) {
    if (text.length() > getFreeSpaceCount()) {
      for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        content[writeIndex] = c;
        writeIndex++;
        writeIndex %= size;
      }
    }
  }
  
  public String toString() {
    String message = "";
    for (int i = readIndex; i < writeIndex; i++) {
      char c = content[i];
      if (c != '\0') {
        message += c;
      }
    }
    return message;
  }
  
  public int getNextAvailablePosition() {
    return 0;
  }
  
  public int getFreeSpaceCount() {
    return 0;
  }
  
  public boolean isEmpty() {
    return readIndex == writeIndex;
  }
}
