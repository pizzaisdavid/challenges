
public abstract class AbstractNode<T> {
  protected T value;
  protected AbstractNode<Object> next; 

  abstract public void setNext(AbstractNode<T> node);
  abstract public String toString();
  abstract public boolean isNull();
  abstract public void append(T value);
}
