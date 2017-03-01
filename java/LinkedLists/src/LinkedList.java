
public class LinkedList<T> {
  private AbstractNode<Object> head;
  
  public LinkedList() {
    head = Node.NULL;
  }

  public void append(T value) {
    head = head.append(value);
  }
  
  public String toString() {
    return head.toString();
  }

  public boolean contains(T value) {
    return head.contains(value);
  }

  public void delete(T value) {
    head = head.delete(value);
  }
}
