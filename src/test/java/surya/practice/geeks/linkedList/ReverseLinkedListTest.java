package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {


    SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();

    @Test
    void reverseWithArrays() {
        singleLinkedList = new ReverseLinkedList().reverseWithArrays(singleLinkedList);
        String expected = "SingleLinkedList{5->4->3->2->1->null}";
        assertEquals( expected, singleLinkedList.toString());
    }

    @Test
    void reverseInPlace() {
        singleLinkedList = new ReverseLinkedList().reverseIteratively(singleLinkedList);
        String expected = "SingleLinkedList{5->4->3->2->1->null}";
        assertEquals(expected, singleLinkedList.toString());
    }



    @Test
    void reverseRecursively() {
        singleLinkedList = new ReverseLinkedList().reverseRecursively(singleLinkedList);
        String expected = "SingleLinkedList{5->4->3->2->1->null}";
        assertEquals(expected, singleLinkedList.toString());
    }
}