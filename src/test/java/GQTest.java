import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GQTest {
    static GenericQueue<Integer> myIntQueue = new GenericQueue<Integer>(1);
    static GenericQueue<Character> myCharQueue = new GenericQueue<Character>('A');
    static GenericQueue<String> myStrQueue = new GenericQueue<String>("Hello");
    static GenericQueue<Boolean> myBoolQueue = new GenericQueue<Boolean>(true);

/*
    @BeforeAll
    static void setup() {
        GenericQueue myIntQueue = new GenericQueue<Integer>(1);
        GenericQueue myCharQueue = new GenericQueue<Character>('A');
        GenericQueue myStrQueue = new GenericQueue<String>("Hello");
        GenericQueue myBoolQueue = new GenericQueue<Boolean>(true);

    }

 */

    @Test
    @Order(1)
    void QueueConstructorTest() {
        System.out.println("Test 1");
        //checking if there are any nodes in our Queues
        assertEquals(false, myBoolQueue.isEmpty(), "Error: Constructor");
        assertEquals(false, myStrQueue.isEmpty(), "Error: Constructor");
        assertEquals(false, myCharQueue.isEmpty(), "Error: Constructor");
        assertEquals(false, myIntQueue.isEmpty(), "Error: Constructor");

    }

    @Test
    @Order(2)
    void QueueConstructorLengthTest() {
        System.out.println("Test 2");
        //checking if there are any nodes in our Queues
        assertEquals(1, myBoolQueue.getLength(), "Error: Constructor, length");
        assertEquals(1, myStrQueue.getLength(), "Error: Constructor, length");
        assertEquals(1, myCharQueue.getLength(), "Error: Constructor, length");
        assertEquals(1, myIntQueue.getLength(), "Error: Constructor, length");

        //myCharQueue.print();
        //myIntQueue.print();
        //myBoolQueue.print();
        //myStrQueue.print();


    }

    @Test
    @Order(3)
    void QueueAddTest() {
        System.out.println("Test 3");
        //adding one element to each Queue
        myStrQueue.add("World!");
        myIntQueue.add(10);
        myBoolQueue.add(false);
        myCharQueue.add('B');

        //check that the length got updated
        assertEquals(2, myBoolQueue.getLength(), "Error: Constructor, length");
        assertEquals(2, myStrQueue.getLength(), "Error: Constructor, length");
        assertEquals(2, myCharQueue.getLength(), "Error: Constructor, length");
        assertEquals(2, myIntQueue.getLength(), "Error: Constructor, length");

        //myCharQueue.print();
        //myIntQueue.print();
        //myBoolQueue.print();
        //myStrQueue.print();

    }

    @Test
    @Order(4)
    void QueueAddMoreTest() {
        System.out.println("Test 4");
        //adding one element to each Queue
        myStrQueue.add("Project");
        myIntQueue.add(100);
        myBoolQueue.add(true);
        myCharQueue.add('C');

        // myStrQueue.print();

        myStrQueue.add("1");
        myIntQueue.add(1000);
        myBoolQueue.add(false);
        myCharQueue.add('D');

        //check that the length got updated
        assertEquals(4, myBoolQueue.getLength(), "Error: Constructor, length");
        assertEquals(4, myStrQueue.getLength(), "Error: Constructor, length");
        assertEquals(4, myCharQueue.getLength(), "Error: Constructor, length");
        assertEquals(4, myIntQueue.getLength(), "Error: Constructor, length");

        //myCharQueue.print();
        //myIntQueue.print();
        //myBoolQueue.print();
        //myStrQueue.print();
    }

    @Test
    @Order(5)
    void QueueDeleteTest() {
        System.out.println("Test 5");
        //deleting one element to each Queue
        myBoolQueue.delete();
        myStrQueue.delete();
        myCharQueue.delete();
        myIntQueue.delete();

        //check that the length got updated
        assertEquals(3, myBoolQueue.getLength(), "Error: Constructor, length");
        assertEquals(3, myStrQueue.getLength(), "Error: Constructor, length");
        assertEquals(3, myCharQueue.getLength(), "Error: Constructor, length");
        assertEquals(3, myIntQueue.getLength(), "Error: Constructor, length");

        //myCharQueue.print();
        //myIntQueue.print();
        //myBoolQueue.print();
        //myStrQueue.print();
    }

    @Test
    @Order(5)
    void QueueDeleteAllTest() {
        System.out.println("Test 5");

        for (int i = 0; i < 3; i++) {
            //deleting one element to each Queue
            myBoolQueue.delete();
            myStrQueue.delete();
            myCharQueue.delete();
            //myIntQueue.delete();
        }

        //check that the length got updated
        assertEquals(0, myBoolQueue.getLength(), "Error: Constructor, length");
        assertEquals(0, myStrQueue.getLength(), "Error: Constructor, length");
        assertEquals(0, myCharQueue.getLength(), "Error: Constructor, length");
       // assertEquals(0, myIntQueue.getLength(), "Error: Constructor, length");

        //check if ifEmpty works on truly empty Queues
        assertEquals(true, myBoolQueue.isEmpty(), "Error: Constructor");
        assertEquals(true, myStrQueue.isEmpty(), "Error: Constructor");
        assertEquals(true, myCharQueue.isEmpty(), "Error: Constructor");
        //assertEquals(true, myIntQueue.isEmpty(), "Error: Constructor");

        //myCharQueue.print();
        //myIntQueue.print();
        //myBoolQueue.print();
        //myStrQueue.print();
    }

    @Test
    @Order(6)
    void IteratorTest(){
        System.out.println("Test 6");
        //populate Queue
        myCharQueue.enqueue('A');
        myCharQueue.enqueue('B');
        myCharQueue.enqueue('C');
        myCharQueue.enqueue('D');
        myCharQueue.enqueue('E');
        myCharQueue.enqueue('F');

        myIntQueue.enqueue(1);
        myIntQueue.enqueue(2);
        myIntQueue.enqueue(3);
        myIntQueue.enqueue(4);
        myIntQueue.enqueue(5);
        myIntQueue.enqueue(6);


        ArrayList<Integer> allInt = new ArrayList<Integer>();
        ArrayList<Character> allChar = new ArrayList<Character>();

        //initialize iterators
        Iterator<Character> charQiter =  myCharQueue.iterator();
        Iterator<Integer> intQiter = myIntQueue.iterator();

        //myIntQueue.print();

        //populate ArrayList using iterators
        while(intQiter.hasNext()) {
            allInt.add(intQiter.next());
            //System.out.println(intQiter.next());
        }

        //check if iterator was succesfull using dumpList()
        assertEquals(myIntQueue.dumpList(), allInt, "Error: Iterator");
        //assertEquals(myCharQueue.dumpList(), allChar, "Error: Iterator");

    }

    @Test
    @Order(7)
    void reverseIteratorTest(){

        System.out.println("Test 7");
        GenericQueue<Integer> myReverseeIntQueue = new GenericQueue<Integer>(1);


        myReverseeIntQueue.enqueue(2);
        myReverseeIntQueue.enqueue(3);
        myReverseeIntQueue.enqueue(4);
        myReverseeIntQueue.enqueue(5);
        myReverseeIntQueue.enqueue(6);

        //create reverse iterator.
        Iterator<Integer> intReverseQiter = myReverseeIntQueue.descendingIterator();

        while(intReverseQiter.hasNext()){
            System.out.println(intReverseQiter.next());
        }
    }

}
