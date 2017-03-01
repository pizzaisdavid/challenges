
public class Node<T> extends AbstractNode<Object> {
  private T value;
  private AbstractNode<Object> next; 
  
  public Node(T value) {
    this.value = value;
    this.next = Node.NULL;
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
  public void append(Object value) {
    if (next == Node.NULL) {
      next = new Node<Object>(value);
    }  else {
      next.append(value);
    }
  }

  @Override
  public boolean contains(Object other) {
    return other.equals(value) || next.contains(other);
  }

  @Override
  public AbstractNode<Object> delete(Object other) {
    if (other.equals(value)) {
      return next;
    } else {
      next = next.delete(other);
      return this;
    }
    
  }
}
