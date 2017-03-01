
public class Node<T> extends AbstractNode<Object> {
  private T value;
  private AbstractNode<Object> next; 
  
  public Node(T value) {
    this(value, Node.NULL);
  }

  public Node(T value, AbstractNode<Object> next) {
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
  public AbstractNode<Object> append(Object value) {
    next = next.append(value);
    return this;
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
