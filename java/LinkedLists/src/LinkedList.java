
public class LinkedList<T> {
  private AbstractNode<Object> head;
  
  public LinkedList() {
    head = new NullNode();
  }

  public void append(T value) {
    if (head.isNull()) {
      head = new Node<T>(value, new NullNode());
    } else {
      head.append(value);
    }
    //head = head.append(value);
  }
  
  public String toString() {
    return head.toString();
  }
}
