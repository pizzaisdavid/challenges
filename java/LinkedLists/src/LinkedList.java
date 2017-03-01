
public class LinkedList<T> {
  private AbstractNode<Object> head;
  private AbstractNode<Object> tail;
  
  public LinkedList() {
    head = Node.NULL;
    tail = Node.NULL;
  }

  public void append(T value) {
    Node<T> node = new Node<T>(value);
    if (head == Node.NULL) {
      head = node;
      tail = node;
    } else {
      tail.setNext(node);
      tail = node;
    }
  }
  
  public String toString() {
    return head.toString();
  }
}
