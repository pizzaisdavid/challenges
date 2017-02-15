
public class PotentialPeg {
  private String content;
  
  public PotentialPeg() {
    this.content = "ROYGBV";
  }
  
  public PotentialPeg(String content) {
    this.content = content;
  }
  
  public void remove(char color) {
    String string = String.valueOf(color);
    content = content.replace(string,  "");
  }
  
  public int count() {
    return content.length();
  }
  
  public String toString() {
    return content;
  }
}
