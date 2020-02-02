package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMiddleElementTest {

    @Test
    @DisplayName("emptyListExceptionTest - naive")
    void emptyListExceptionTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        FindMiddleElement fme = new FindMiddleElement();
        EmptyListException customExcep = assertThrows(EmptyListException.class, () -> fme.findMiddleElementNaive(singleLinkedList));
        assertTrue(customExcep.getMessage().contains("The list is empty"));
    }

    @Test
    @DisplayName("middle of odd sized list - 2 ptr test")
    void oddElement2PointerTest() throws EmptyListException {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();
        FindMiddleElement fme = new FindMiddleElement();
        assertEquals(3, fme.findMiddleElementUsing2Pointers(singleLinkedList).data);
    }

    @Test
    @DisplayName("middle of even sized list - 2 ptr test")
    void evenElement2PointerTest() throws EmptyListException {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithEvenLength();
        FindMiddleElement fme = new FindMiddleElement();

        assertEquals(3, fme.findMiddleElementUsing2Pointers(singleLinkedList).data);

    }

    @Test
    @DisplayName("emptyListExceptionTest - 2 pointer")
    void emptyList2PointerTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        FindMiddleElement fme = new FindMiddleElement();
        EmptyListException emptyListException = assertThrows(EmptyListException.class, () -> fme.findMiddleElementUsing2Pointers(singleLinkedList));
        assertTrue(emptyListException.getMessage().contains("The list is empty"));
    }

    @Test
    @DisplayName("middle of odd sized list - NaiveTest")
    void oddElementNaiveTest() throws EmptyListException {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();
        FindMiddleElement fme = new FindMiddleElement();
        assertEquals(3, fme.findMiddleElementNaive(singleLinkedList).data);
    }

    @Test
    @DisplayName("middle of even sized list - NaiveTest")
    void evenElementNaiveTest() throws EmptyListException {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithEvenLength();
        FindMiddleElement fme = new FindMiddleElement();

        assertEquals(3, fme.findMiddleElementNaive(singleLinkedList).data);
    }

    @Test
    @DisplayName("middle of even sized list - Efficient Test")
    void findMiddleElementEfficiently() throws EmptyListException {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithEvenLength();
        FindMiddleElement fme = new FindMiddleElement();
        assertEquals(3, fme.findMiddleElementEfficiently(singleLinkedList).data);
    }

    @Test
    @DisplayName("middle of odd sized list - Efficient Test")
    void findMiddleElementOddEfficiently() throws EmptyListException {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getIntegerListWithOddLength();
        FindMiddleElement fme = new FindMiddleElement();
        assertEquals(3, fme.findMiddleElementEfficiently(singleLinkedList).data);
    }

    @Test
    @DisplayName("emptyListExceptionTest - Efficient Test")
    void emptyListEfficientTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        FindMiddleElement fme = new FindMiddleElement();
        EmptyListException emptyListException = assertThrows(EmptyListException.class, () -> fme.findMiddleElementEfficiently(singleLinkedList));
        assertTrue(emptyListException.getMessage().contains("The list is empty"));
    }
}