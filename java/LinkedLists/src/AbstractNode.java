
public interface AbstractNode<T> {
  abstract public void setNext(AbstractNode<T> node);
  abstract public String toString();
  abstract public void append(T value);
}
