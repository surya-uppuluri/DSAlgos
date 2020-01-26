package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {


    SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();

    @Test
    void reverseWithArrays() {
        singleLinkedList = new ReverseLinkedList().reverseWithArrays(singleLinkedList);
        String result = "SingleLinkedList{5->4->3->2->1->null}";
        assertEquals(singleLinkedList.toString(), result);
    }

    @Test
    void reverseInPlace()
    {
        singleLinkedList = new ReverseLinkedList().reverse(singleLinkedList);
        String result = "SingleLinkedList{5->4->3->2->1->null}";
        assertEquals(singleLinkedList.toString(), result);
    }
}