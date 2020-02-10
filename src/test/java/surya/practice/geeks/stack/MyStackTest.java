package surya.practice.geeks.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyStackTest {

    MyStack myStack;

    @BeforeEach
    void generateStack() {
        myStack = new MyStack();
        myStack.push(5);
        myStack.push(6);
    }

    @Test
    void popTest() {
        assertEquals(6, myStack.pop());
    }

    @Test
    void pushTest() {

        assertEquals(6, myStack.peek());
    }


}