package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NthElementFromEndTest {

    @Test
    @DisplayName(" NthElementFromEnd - Positive Test")
    public void TestThatNthElementFromEndUsingHashMap() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();
        Node nthElem = new NthElementFromEnd().getElementInOnePassWithHM(singleLinkedList, 6);
        assertEquals(25, nthElem.data);
    }


    @Test
    @DisplayName(" NthElementFromEnd Naive- Positive Test")
    public void TestThatNthElementFromEndNaive() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();
        Node nthElem = new NthElementFromEnd().getElementNaive(singleLinkedList, 6);
        assertEquals(25, nthElem.data);
    }

}