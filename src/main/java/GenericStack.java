import java.util.Iterator;

public class GenericStack<T> extends GenericList<T> {

    Node<T> tail;

    //constructor stack with one node head == tail.
    public GenericStack(T inData){
        GenericList<T>.Node<T> first = new GenericList<T>.Node<T>(inData);
        tail = first;
        this.setHead(first);
        this.setLength(1);
    }

    //add a Node to the head of the stack.
    @Override
    void add(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(this.getHead());
        this.getHead().setPrev(newNode);
        this.setHead(newNode);
        setLength(this.getLength()+1);
    }

    @Override
    public Iterator<T> iterator() {
        Node<T> head = this.getHead();
        GLLIterator<T> iter = new GLLIterator<T>(head);
        return iter;
    }

    //calls add.
    public void push(T data){
        this.add(data);
    }

    //calls pop
    public T pop(){
            return this.delete();
    }

    public T removeTail(){
        T temp = tail.get();
        Node<T> tempNode = tail.prev();
        tempNode.setNext(null);
        tail = tempNode;
        return temp;
    }

}
