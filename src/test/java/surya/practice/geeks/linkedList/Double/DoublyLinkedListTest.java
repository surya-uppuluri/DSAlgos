package surya.practice.geeks.linkedList.Double;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    @DisplayName("Test NSI exception - Negative Scenario")
    void testNSIExceptionOnDeleteNode() {

        Node head;
        Node temp;

        int n = 3;
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();

        int posToBeDeleted = 4;
        NoSuchIndexException noSuchIndexException = assertThrows(NoSuchIndexException.class, () -> doublyLinkedList.deleteNode(doublyLinkedList.head, posToBeDeleted));
        assertTrue(noSuchIndexException.getMessage().contains("No such index in the list"));

    }

    @Test
    @DisplayName("Test Node Deletion - Positive case")
    void testDeleteNode() throws NoSuchIndexException {

        Node head;

        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        head = doublyLinkedList.head;
        int posToBeDeleted = 2;
        doublyLinkedList.deleteNode(doublyLinkedList.head, posToBeDeleted);
        assertEquals("1 3 4 5 ", doublyLinkedList.printList());

    }

    private DoublyLinkedList getDLLWithLen5() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addToTheLast(new Node(1));
        doublyLinkedList.addToTheLast(new Node(2));
        doublyLinkedList.addToTheLast(new Node(3));
        doublyLinkedList.addToTheLast(new Node(4));
        doublyLinkedList.addToTheLast(new Node(5));

        return doublyLinkedList;
    }

    @Test
    @DisplayName("Test that count of DLL works properly")
    void getLengthOfDLL() {
        DoublyLinkedList dll = getDLLWithLen5();
        assertEquals(3, dll.getLengthOfDLL());
    }

    @Test
    @DisplayName("Test that reverse of DLL works properly")
    void reverseTest() {
        DoublyLinkedList dll = getDLLWithLen5();
        dll.printList();
        dll.reverse();
        assertEquals("5 4 3 2 1 ", dll.printList());
    }
}