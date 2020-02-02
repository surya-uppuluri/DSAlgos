package surya.practice.geeks.linkedList;

import java.util.HashMap;

public class NthElementFromEnd {

    private static boolean isPosOOB(int pos, int len) {
        if (pos > len) {
            System.out.println("No such position exists");
            return true;
        }
        return false;
    }

    //@formatter:On

    /**
     * ---------
     * ALGORITHM
     * ---------
     * 1. Compute length first
     * 2. Traverse again to get nth element from end
     */
    //@formatter:Off

     Node getElementNaive(SingleLinkedList singleLinkedList, int pos) {
        int len = singleLinkedList.getLength();
        if (isPosOOB(pos, len)) return null;
        Node head = singleLinkedList.getHead();
        for (int i = 0; i < len - pos; i++) {
            head = head.next;
        }
         System.out.println("Element at: " + (pos) + " position from end is " + head.data);
         return head;
    }

    public Node getElementInOnePassWithHM(SingleLinkedList evenList, int pos) {
//        System.out.println("Obtained list: "+ evenList.printLinkedList());
        if (isPosOOB(pos, evenList.getLength())) return null;
        HashMap<Integer, Node> addressMap = new HashMap<>();
        Node temp = evenList.getHead();
        addressMap.put(0, temp);
        Integer counter = new Integer(1);
        while (temp != null) {
            addressMap.put(counter, temp.next);
            counter++;
            temp = temp.next;
        }
        System.out.println(addressMap.toString());
        int size = addressMap.size();
        return addressMap.get(size - pos - 1);

    }

}
