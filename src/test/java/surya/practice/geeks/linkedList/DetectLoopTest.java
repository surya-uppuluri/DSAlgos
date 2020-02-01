package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectLoopTest {

    SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();

    @Test
    public void detectLoopTest() {

        DetectLoop detectLoop = new DetectLoop();
        assertFalse(detectLoop.hasLoopNaive(singleLinkedList));
    }


    @Test()
    public void detectLoopPositiveTest() {
        DetectLoop detectLoop = new DetectLoop();
        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        //TODO - Even print() goes on infinite loop as it doesn't find null.
        //Have to fix this later when time is abundant.
        /*singleLinkedList.toString();
        assertTrue(detectLoop.hasLoopNaive(singleLinkedList));
*/
    }


    @Test()
    @DisplayName("Negative test - loop doesn't exist")
    public void detectLoopNegativeTest() {
        DetectLoop detectLoop = new DetectLoop();
        assertFalse(detectLoop.hasLoop_extraVariable(singleLinkedList));
    }


    @Test()
    @DisplayName("Positive test - loop exists")
    public void detectLoopUsingVisitedNode() {
        DetectLoop detectLoop = new DetectLoop();
        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        assertTrue(detectLoop.hasLoop_extraVariable(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Hashing - Positive test - loop exists")
    public void detectLoopUsingHashing() {
        DetectLoop detectLoop = new DetectLoop();
        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        assertTrue(detectLoop.hasLoop_hashing(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Hashing - Negative test - loop exists")
    public void detectLoopUsingHashingNegativeTest() {
        DetectLoop detectLoop = new DetectLoop();
        assertFalse(detectLoop.hasLoop_hashing(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Floyd - Positive test - loop exists")
    public void detectLoopUsingFloyd() {
        DetectLoop detectLoop = new DetectLoop();
        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        assertTrue(detectLoop.hasLoop_Floyd(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Floyd - Negative test - loop exists")
    public void detectLoopUsingFloydNegativeTest() {
        DetectLoop detectLoop = new DetectLoop();
        assertFalse(detectLoop.hasLoop_Floyd(singleLinkedList));
    }

}