import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
      Stack and Queue implementation of a Generic Linked list, List class implements iterable interface.
            Santiago Fernandez UIC CS342
*/

abstract class GenericList<T> implements Iterable<T>{

    public class Node<T>{

        private T data;
        private Node<T> next;
        private Node<T> prev;

        //Node constructor
        public Node(T inData){
            data = inData;
            next = null;
            prev = null;
        }

        //getter
        public T get(){
            return data;
        }

        //setter
        public void set(T inData){
            data = inData;
        }

        //mutators: Used to traverse/modify list by accessing the adjacent nodes.

        public Node<T> next(){
            return this.next;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public Node<T> prev(){ return this.prev; }

        public void setPrev(Node<T> node) {
            this.prev = node;
        }

    }

    private Node<T> head;
    private int length;

    /*
    public GenericList(T inData){
        Node<T> first = new Node<T>(inData);
        head = first;
        length = 1;
    }
     */

    //NOTE: No default constructor!

    //check to see if there are any nodes in the list. false if empty.
    public boolean isEmpty(){
        if(this.length < 1){ return true;}
        else { return false; }
    }

    //traverse linked list, printing values along the way.
    public void print(){
        Node<T> curr = head;

        if(length == 0){
            System.out.println("empty list");
        }else{
            for(int i = 0; i < length; i++) {
                System.out.print(" "+curr.get());
                curr = curr.next;
            }
            System.out.println();
        }

    }

    //Stack and Queue will have different implementations of add.
    abstract void add(T data);

    //remove node from the beginning of the list.
    public T delete(){
        if(length > 0) { //there is at least one node.
            T temp = head.get();
            if(length > 1) { //there is more than one node.
                Node<T> tempNd = head;
                //advance list one node and make this node the head.
                head = head.next;
                //dangling pointer handling.
                head.prev = null;
                tempNd.next = null;
                tempNd = null;
            }else{ head = null; }
            length--;
            return temp;
        }
        else return null;
    }

    //delete all nodes in the list, adding them into an ArrayList
    //along the way.
    public ArrayList<T> dumpList(){
        ArrayList<T> all = new ArrayList<T>();
        while(length > 0){
            all.add(this.delete());
        }
        return all;
    }

    //implementation of get() finds and returns a node at a given index.
    public Node<T> find(int index){

        Node<T> curr = head;

        if(index >= length){ //out of bounds.
            return null;
        }else{
            while(index != 0){
                curr = curr.next;
                index--;
            }
            return curr;
        }

    }

    //using find() returns the data at a given index.
    public T get(int index){ return this.find(index).get(); }

    //sets the data of a node at a given index
    public T set(int index, T element){

        Node<T> temp = this.find(index);
        this.find(index).set(element);
        return temp.get();

    }

    public int getLength(){
        return length;
    }

    public void setLength(int newLen){
        //this WILL cause problems if we set the length to an untrue length.
        length = newLen;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public void setHead(Node<T> node){
        this.head = node;
    }

    public ListIterator<T> listIterator(int index){
        Node<T> elem = head;
        int i = 0;

        if(index >= length){
            System.out.println("index out of bounds");
        }

        //finding node at given index.
        while(i != index){
            i++;
            elem = elem.next;
        }

        GLListIterator<T> ListIterator = new GLListIterator<T>(elem);
        return ListIterator;
    };

    public Iterator<T> descendingIterator( ){
        Node<T> tail = head;
        while(tail != null){
            tail = tail.next;
        }

        ReverseGLLIterator<T> reverseIter = new ReverseGLLIterator<T>(tail);

        return reverseIter;
    };


}
