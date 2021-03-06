package surya.practice.geeks.linkedList.Double;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    @DisplayName("Test NSI exception - Negative Scenario")
    public void testNSIExceptionOnDeleteNode() {
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();

        int posToBeDeleted = 45;
        NoSuchIndexException noSuchIndexException = assertThrows(NoSuchIndexException.class, () -> doublyLinkedList.deleteNode(doublyLinkedList.head, posToBeDeleted));
        assertTrue(noSuchIndexException.getMessage().contains("No such index in the list"));

    }

    @Test
    @DisplayName("Test Node Deletion - Positive case")
    public void testDeleteNode() throws NoSuchIndexException {

        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        int posToBeDeleted = 2;
        System.out.println("Head is :" + doublyLinkedList.head);
        doublyLinkedList.deleteNode(doublyLinkedList.head, posToBeDeleted);
        assertEquals("1 3 4 5 ", doublyLinkedList.printList());

    }

    public DoublyLinkedList getDLLWithLen5() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addToTheLast(new Node(1));
        doublyLinkedList.addToTheLast(new Node(2));
        doublyLinkedList.addToTheLast(new Node(3));
        doublyLinkedList.addToTheLast(new Node(4));
        doublyLinkedList.addToTheLast(new Node(5));
        return doublyLinkedList;
    }

    public DoublyLinkedList getDLLWithLen6() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addToTheLast(new Node(1));
        doublyLinkedList.addToTheLast(new Node(2));
        doublyLinkedList.addToTheLast(new Node(3));
        doublyLinkedList.addToTheLast(new Node(4));
        doublyLinkedList.addToTheLast(new Node(5));
        doublyLinkedList.addToTheLast(new Node(6));

        return doublyLinkedList;
    }

    @Test
    @DisplayName("Test that count of DLL works properly")
    void getLengthOfDLL() {
        DoublyLinkedList dll = getDLLWithLen5();
        assertEquals(5, dll.getLengthOfDLL(dll.head));
    }

    @Test
    @DisplayName("Test that reverse of DLL works properly")
    void reverseTest() {
        DoublyLinkedList dll = getDLLWithLen5();
        dll.printList();
        dll.reverse();
        assertEquals("5 4 3 2 1 ", dll.printList());
    }

    @Test
    @DisplayName("Test that insert in random location works properly")
    void insertAtPosTest() {
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        doublyLinkedList.insertAtPos(doublyLinkedList.head, 3, 999);
        assertEquals("1 2 999 3 4 5 ", doublyLinkedList.printList());
    }

    @Test
    @DisplayName("Test that insert in beginning works properly")
    void insertAtZeroPosTest() {
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        doublyLinkedList.insertAtPos(doublyLinkedList.head, 0, 999);
        assertEquals("999 1 2 3 4 5 ", doublyLinkedList.printList());
    }

    @Test
    @DisplayName("Test that insert in random location works properly")
    void insertAfterPosTest() {
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        doublyLinkedList.insertAfterPos(doublyLinkedList.head, 3, 999);
        assertEquals("1 2 3 999 4 5 ", doublyLinkedList.printList());
    }

    @Test
    @DisplayName("Test that insert in beginning works properly")
    void insertAfterZeroNormalTest() {
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        doublyLinkedList.insertAfterPos(doublyLinkedList.head, 0, 999);
        assertEquals("1 999 2 3 4 5 ", doublyLinkedList.printList());
    }


    @Test
    @DisplayName("Test that insert in middle for odd list works properly")
    void insertInOddMidTest() {
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        doublyLinkedList.insertInMid(doublyLinkedList.head, 999);
        assertEquals("1 2 999 3 4 5 ", doublyLinkedList.printList());
    }

    @Test
    @DisplayName("Test that insert in middle for even list works properly")
    void insertInEvenMidTest() {
        DoublyLinkedList doublyLinkedList = getDLLWithLen5();
        doublyLinkedList.insertAtPos(doublyLinkedList.head, doublyLinkedList.getLengthOfDLL(doublyLinkedList.head) + 1, 6);
        doublyLinkedList.insertInMid(doublyLinkedList.head, 999);
        assertEquals("1 2 3 999 4 5 6 ", doublyLinkedList.printList());
    }

    @Test
    @DisplayName("Test that two lists are identical - Positive")
    void identicalLinkedListPositiveTest() {
        DoublyLinkedList dll1 = getDLLWithLen5();
        DoublyLinkedList dll2 = getDLLWithLen5();
        assertTrue(dll1.isEqualTo(dll2));
    }

    @Test
    @DisplayName("Test that two lists are identical - Negative")
    void identicalLinkedListNegativeTest() {
        DoublyLinkedList dll1 = getDLLWithLen5();
        DoublyLinkedList dll2 = getDLLWithLen6();
        assertFalse(dll1.isEqualTo(dll2));
    }

}