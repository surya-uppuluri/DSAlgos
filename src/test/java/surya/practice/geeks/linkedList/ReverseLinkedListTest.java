package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {


    SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();

    @Test
    void reverseWithArraysTest() {
        singleLinkedList = new ReverseLinkedList().reverseWithArrays(singleLinkedList);
        String expected = "SingleLinkedList{5->4->3->2->1->25->null}";
        assertEquals( expected, singleLinkedList.toString());
    }

    @Test
    void reverseInPlaceTest() {
        singleLinkedList = new ReverseLinkedList().reverseIteratively(singleLinkedList);
        String expected = "SingleLinkedList{5->4->3->2->1->25->null}";
        assertEquals(expected, singleLinkedList.toString());
    }



    @Test
    void reverseRecursivelyTest() {
        singleLinkedList = new ReverseLinkedList().reverseRecursively(singleLinkedList);
        String expected = "SingleLinkedList{5->4->3->2->1->25->null}";
        assertEquals(expected, singleLinkedList.toString());
    }


}