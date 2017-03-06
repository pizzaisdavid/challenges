
public class Cell {
  private int id;
  private boolean isFull;

  public Cell(int id) {
    this.id = id;
    this.isFull = true;
  }
  
  public int getId() {
    return id;
  }
  
  public void setStatus(boolean status) {
    isFull = status;
  }
  
  public String toString() {
    if (isFull) {
      return "|";
    }
    return " ";
  }
  
  public boolean hasPeg() {
    return isFull;
  }

}
