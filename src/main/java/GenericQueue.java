import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> {

    Node<T> tail;

    public GenericQueue(T inData){
        Node<T> first = new Node<T>(inData);
        tail = first;
        this.setHead(first);
        this.setLength(1);
    }

    //add element to the back of the queue, this will be the new tail
    @Override
    void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if(getLength() == 0){ //edgecase, queue is empty.
            this.setHead(newNode);
        }
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        setLength(this.getLength()+1);
    }

    @Override
    public Iterator<T> iterator() {
        Node<T> head = this.getHead();
        GLLIterator<T> iter = new GLLIterator<T>(head);
        return iter;
    }

    public void enqueue(T data){
        this.add(data);
    }

    public T dequeue(){
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
