
public class Node<T> implements AbstractNode<Object> {
  public static final AbstractNode<Object> NULL = new NullNode();
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
  
  private static class NullNode implements AbstractNode<Object> {
    @Override
    public void setNext(AbstractNode<Object> node) {
      throw new NullPointerException();
    }

    @Override
    public String toString() {
      return "";
    }

    @Override
    public void append(Object value) {
      throw new NullPointerException();
    }
  }
}
