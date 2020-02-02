package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectLoopTest {

    SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();


    @Test
    public void detectLoopTest() {

        assertFalse(new DetectLoop().hasLoopNaive(singleLinkedList));
    }


    @Test()
    public void detectLoopPositiveTest() {
        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        //TODO - Even print() goes on infinite loop as it doesn't find null.
        //Have to fix this later when time is abundant.
        /*singleLinkedList.toString();
        assertTrue(new DetectLoop().hasLoopNaive(singleLinkedList));
*/
    }


    @Test()
    @DisplayName("Negative test - loop doesn't exist")
    public void detectLoopNegativeTest() {

        assertFalse(new DetectLoop().hasLoop_extraVariable(singleLinkedList));
    }


    @Test()
    @DisplayName("Positive test - loop exists")
    public void detectLoopUsingVisitedNode() {

        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        assertTrue(new DetectLoop().hasLoop_extraVariable(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Hashing - Positive test - loop exists")
    public void detectLoopUsingHashing() {

        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        assertTrue(new DetectLoop().hasLoop_hashing(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Hashing - Negative test - loop exists")
    public void detectLoopUsingHashingNegativeTest() {

        assertFalse(new DetectLoop().hasLoop_hashing(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Floyd - Positive test - loop exists")
    public void detectLoopUsingFloyd() {

        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        assertTrue(new DetectLoop().hasLoop_Floyd(singleLinkedList));
    }


    @Test()
    @DisplayName("Using Floyd - Negative test - loop exists")
    public void detectLoopUsingFloydNegativeTest() {

        assertFalse(new DetectLoop().hasLoop_Floyd(singleLinkedList));
    }

    @Test
    @DisplayName("Detect and remove loop Floyd")
    public void removeLoop() {
        singleLinkedList.insertAtEnd(singleLinkedList.traverse()[3]);
        System.out.println("Formed a loop after 5 that points to 3");
        //TODO
//        assertTrue(new DetectLoop().removeLoop(singleLinkedList));

    }

}