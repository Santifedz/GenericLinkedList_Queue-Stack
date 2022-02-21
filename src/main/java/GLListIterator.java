import java.util.ListIterator;

public class GLListIterator<T> implements ListIterator<T> {
    private GenericList<T>.Node<T> current;

    GLListIterator(GenericList<T>.Node<T> node){ current = node; }

    @Override
    public boolean hasNext() {
        if (current != null){ return true; }
        else{ return false; }
    }

    @Override
    public T next() {
        T temp = current.get();
        current = current.next();
        return temp;
    }

    @Override
    public boolean hasPrevious() {
        if (current == null)
            return false;
        return true;
    }

    @Override
    public T previous() {
        T temp = current.get();
        current = current.prev();
        return temp;
    }

    @Override
    public int nextIndex() {
        GenericList<T>.Node<T> temp = current.next();
        int index = 0;
        if(temp != null) {
            while (current.next() != null) {
                index++;
                temp = temp.next();
            }
            return index;
        }else{ return -1; }
    }

    @Override
    public int previousIndex() {
        GenericList<T>.Node<T> temp = current.prev();
        int index = 0;
        if(temp != null) {
            while (current.prev() != null) {
                index++;
                temp = temp.prev();
            }
            return index;
        }else{ return -1; }
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {

    }

    @Override
    public void add(T t) {

    }
}
