package surya.practice.geeks.linkedList;

public class NthElementFromEnd {

    public static void main(String[] args) {

        SingleLinkedList evenList = new SingleLinkedList().getIntegerListWithEvenLength();
        getElementNaive(evenList, 3);
        SingleLinkedList oddList = new SingleLinkedList().getIntegerListWithOddLength();
        getElementNaive(oddList, 2);

        getElementInOnePassWithHM(evenList, 3);

    }

    private static void getElementInOnePassWithHM(SingleLinkedList evenList, int pos) {
        if (checkifPositionIsOutOfBounds(pos, evenList.getLength())) return;

    }

    //@formatter:On
    /**
    ---------
    ALGORITHM
    ---------
    1. Compute length first
    2. Traverse again to get nth element from end
     */
    //@formatter:Off

    private static void getElementNaive(SingleLinkedList singleLinkedList, int pos) {
        int len = singleLinkedList.getLength();
        if (checkifPositionIsOutOfBounds(pos, len)) return;
        Node head = singleLinkedList.getHead();
        for (int i = 0; i < len - pos; i++) {
            head = head.next;
        }
        System.out.println("Element at: " + (pos) + " position from end is " + head.data);
    }

    private static boolean checkifPositionIsOutOfBounds(int pos, int len) {
        if (pos > len) {
            System.out.println("No such index exists");
            return true;
        }
        return false;
    }

}
