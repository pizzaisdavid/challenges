
public abstract class AbstractNode<T> {
  public static final AbstractNode<Object> NULL = new NullNode();
  
  abstract public void setNext(AbstractNode<T> node);
  abstract public String toString();
  abstract public AbstractNode<Object> append(T value);
  abstract public boolean contains(T other);
  abstract public AbstractNode<Object> delete(T other);
  
  private static class NullNode extends AbstractNode<Object> {
    
    @Override
    public void setNext(AbstractNode<Object> node) {
      throw new NullPointerException();
    }

    @Override
    public String toString() {
      return "";
    }

    @Override
    public AbstractNode<Object> append(Object value) {
      return new Node<Object>(value, this);
    }

    @Override
    public boolean contains(Object other) {
      return false;
    }

    @Override
    public AbstractNode<Object> delete(Object other) {
      return this;
    }
  }
}
