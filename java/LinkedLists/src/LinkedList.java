
public class LinkedList<T> {
  private AbstractNode<Object> head;
  
  public LinkedList() {
    head = Node.NULL;
  }

  public void append(T value) {
    if (head == Node.NULL) {
      head = new Node<T>(value);
    } else {
      head.append(value);
    }
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
