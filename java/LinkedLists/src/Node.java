
public class Node<T> extends AbstractNode<Object> {  
  
  public Node(T value) {
    this.value = value;
    this.next = new NullNode();
  }
  
  public Node(T value, NullNode next) {
    this.value = value;
    this.next = next;
  }

  @Override
  public void setNext(AbstractNode<Object> node) {
    next = node;
  }
  
  @Override
  public String toString() {
    return value.toString() + next.toString();
  }

  @Override
  public boolean isNull() {
    return false;
  }

  @Override
  public void append(Object value) {
    if (next.isNull()) {
      next = new Node<Object>(value);
    }  else {
      next.append(value);
    }
  }
}
