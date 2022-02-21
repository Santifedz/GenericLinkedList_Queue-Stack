import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GSTest {
    static GenericStack<Integer> myIntStack = new GenericStack<Integer>(1);;
    static GenericStack<Character> myCharStack = new GenericStack<Character>('A');
    static GenericStack<String> myStrStack = new GenericStack<String>("Hello");
    static GenericStack<Boolean> myBoolStack = new GenericStack<Boolean>(true);

/*
    @BeforeAll
    static void setup() {
        GenericStack myIntStack = new GenericStack<Integer>(1);
        GenericStack myCharStack = new GenericStack<Character>('A');
        GenericStack myStrStack = new GenericStack<String>("Hello");
        GenericStack myBoolStack = new GenericStack<Boolean>(true);

    }

 */

    @Test
    @Order(1)
    void stackConstructorTest(){
        System.out.println("Test 1");
        //checking if there are any nodes in our stacks
        assertEquals(false,myBoolStack.isEmpty(),"Error: Constructor");
        assertEquals(false,myStrStack.isEmpty(),"Error: Constructor");
        assertEquals(false,myCharStack.isEmpty(),"Error: Constructor");
        assertEquals(false,myIntStack.isEmpty(),"Error: Constructor");

    }

    @Test
    @Order(2)
    void stackConstructorLengthTest(){
        System.out.println("Test 2");
        //checking if there are any nodes in our stacks
        assertEquals(1,myBoolStack.getLength(),"Error: Constructor, length");
        assertEquals(1,myStrStack.getLength(),"Error: Constructor, length");
        assertEquals(1,myCharStack.getLength(),"Error: Constructor, length");
        assertEquals(1,myIntStack.getLength(),"Error: Constructor, length");

        //myCharStack.print();
        //myIntStack.print();
        //myBoolStack.print();
        //myStrStack.print();


    }

    @Test
    @Order(3)
    void stackAddTest(){
        System.out.println("Test 3");
        //adding one element to each stack
        myStrStack.add("World!");
        myIntStack.add(10);
        myBoolStack.add(false);
        myCharStack.add('B');

        //check that the length got updated
        assertEquals(2,myBoolStack.getLength(),"Error: Constructor, length");
        assertEquals(2,myStrStack.getLength(),"Error: Constructor, length");
        assertEquals(2,myCharStack.getLength(),"Error: Constructor, length");
        assertEquals(2,myIntStack.getLength(),"Error: Constructor, length");

        //myCharStack.print();
        //myIntStack.print();
        //myBoolStack.print();
        //myStrStack.print();

    }

    @Test
    @Order(4)
    void stackAddMoreTest(){
        System.out.println("Test 4");
        //adding one element to each stack
        myStrStack.add("Project");
        myIntStack.add(100);
        myBoolStack.add(true);
        myCharStack.add('C');

       // myStrStack.print();

        myStrStack.add("1");
        myIntStack.add(1000);
        myBoolStack.add(false);
        myCharStack.add('D');

        //check that the length got updated
        assertEquals(4,myBoolStack.getLength(),"Error: Constructor, length");
        assertEquals(4,myStrStack.getLength(),"Error: Constructor, length");
        assertEquals(4,myCharStack.getLength(),"Error: Constructor, length");
        assertEquals(4,myIntStack.getLength(),"Error: Constructor, length");

        myCharStack.print();
        myIntStack.print();
        myBoolStack.print();
        myStrStack.print();
    }

    @Test
    @Order(5)
    void stackDeleteTest(){
        System.out.println("Test 5");
        //deleting one element to each stack
        myBoolStack.delete();
        myStrStack.delete();
        myCharStack.delete();
        myIntStack.delete();

        //check that the length got updated
        assertEquals(3,myBoolStack.getLength(),"Error: Constructor, length");
        assertEquals(3,myStrStack.getLength(),"Error: Constructor, length");
        assertEquals(3,myCharStack.getLength(),"Error: Constructor, length");
        assertEquals(3,myIntStack.getLength(),"Error: Constructor, length");

        myCharStack.print();
        myIntStack.print();
        myBoolStack.print();
        myStrStack.print();
    }

    @Test
    @Order(5)
    void stackDeleteAllTest() {
        System.out.println("Test 5");

        for(int i = 0; i<3; i++) {
            //deleting one element to each stack
            myBoolStack.delete();
            myStrStack.delete();
            myCharStack.delete();
            myIntStack.delete();
        }

        //check that the length got updated
        assertEquals(0,myBoolStack.getLength(),"Error: Constructor, length");
        assertEquals(0,myStrStack.getLength(),"Error: Constructor, length");
        assertEquals(0,myCharStack.getLength(),"Error: Constructor, length");
        assertEquals(0,myIntStack.getLength(),"Error: Constructor, length");

        //check if ifEmpty works on truly empty stacks
        assertEquals(true,myBoolStack.isEmpty(),"Error: Constructor");
        assertEquals(true,myStrStack.isEmpty(),"Error: Constructor");
        assertEquals(true,myCharStack.isEmpty(),"Error: Constructor");
        assertEquals(true,myIntStack.isEmpty(),"Error: Constructor");

        myCharStack.print();
        myIntStack.print();
        myBoolStack.print();
        myStrStack.print();
    }







}
