package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteNodeTest {

    SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();


    @Test
    public void deleteNodeTest() {
        System.out.println("Before deletion-> " + singleLinkedList.printLinkedList());
        System.out.println("Trying to delete - " + singleLinkedList.traverse()[2]);
        singleLinkedList.deleteNodeWithoutAnyOtherReferences(singleLinkedList.getHead().next.next); //TODO-Scope of next availability
        System.out.println("After deletion-> " + singleLinkedList.printLinkedList());
        assertEquals("25->1->3->4->5->null", singleLinkedList.printLinkedList());
    }

}