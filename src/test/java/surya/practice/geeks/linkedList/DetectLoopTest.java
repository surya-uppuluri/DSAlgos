package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
//        singleLinkedList.insertAtEnd(singleLinkedList.getHead());
        detectLoop.hasLoopNaive(singleLinkedList);
    }
}