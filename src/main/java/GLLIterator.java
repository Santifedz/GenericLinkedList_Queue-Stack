import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T>{

    private GenericList<T>.Node<T> current;

    GLLIterator(GenericList<T>.Node<T> node){ current = node; }

    //checks if the current node is pointing to a next node
    @Override
    public boolean hasNext() {
        if (current != null){ return true; }
        else{ return false; }
    }

    //returns the current value in the data structure and advances to the next item.
    @Override
    public T next() {
        T temp = current.get();
        current = current.next();
        return temp;
    }
}
