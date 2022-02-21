import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {

    private GenericList<T>.Node<T> current;

    ReverseGLLIterator(GenericList<T>.Node<T> node){
        current = node;
    }

    @Override
    public boolean hasNext() {
        if (current != null){ return true; }
        else{ return false; }
    }

    @Override
    public T next() {
        T temp = current.get();
        current = current.prev();
        return temp;
    }

}
