package surya.practice.geeks.linkedList;

public class ReverseLinkedList<T> {

    //@formatter:off
    /**
     * ------------------
     * PROBLEM STATEMENT
     * ------------------
     * A SLL is given, reverse the list.
     *
     */
    //@formatter:on


    //@formatter:off

    /**
     * Method1- Naive array technique
     * ----------
     * ALGORITHM
     * ----------
     * 1. Store elements of linkedList in an array
     * 2. Reverse the array
     * 3. Put the elements back into linkedList
     * =========================
     * Space Complexity - O(n)
     * Time Complexity - O(n) + O(n) = O(n)
     * =========================
     * Verdict: Extra space, copying data is not economical always
     */
    //@formatter:on
    public SingleLinkedList reverseWithArrays(SingleLinkedList singleLinkedList) {

        T[] arr = (T[]) new Object[singleLinkedList.getLength()];
        int i = 0;
        for (Node n : singleLinkedList.traverse()) {
            if (n != null)
                arr[i++] = (T) n.data;
        }

        reverseIteratively(arr);
        Node head = singleLinkedList.getHead();

        for (T elem : arr) {
            head.data = elem;
            head = head.next;
        }

        return singleLinkedList;
    }

    private T[] reverseIteratively(T[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            T temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }


    //@formatter:off

    /**
     * METHOD2 - Reverse linkedList in place with 2 extra Nodes
     * ----------
     * ALGORITHM
     * ----------
     * 1. Keep forming the links in reverse order and make last node as head so that the list is reversed
     * 2. We can't simply say curr.next=prev because we'll lose the track of next element. That's why make use of a
     * reference and call it 'pointer'.
     * 3. Initially head will be the current element.
     * 4. Store curr-> next address in reference pointer and then change the next reference to previous
     * 5. Slide the previous and current to right
     * 6. Finally mark the last previous as head.
     * =========================
     * Space Complexity - O(1)
     * Time Complexity - O(n)
     * =========================
     * Verdict: Optimal solution
     */
    //@formatter:on
    public SingleLinkedList reverseIteratively(SingleLinkedList singleLinkedList) {

        Node previous = null;
        Node current = singleLinkedList.getHead();
        while (current != null) {
            Node pointer = current.next;
            current.next = previous;
            previous = current;
            current = pointer;
        }
        singleLinkedList.setHead(previous);
        return singleLinkedList;
    }

    public SingleLinkedList reverseRecursively(SingleLinkedList singleLinkedList) {
         singleLinkedList.setHead(reverseRec(singleLinkedList.getHead()));
         return singleLinkedList;
    }

    private Node reverseRec(Node head) {
        if (head == null || head.next == null)
            return head;
        Node nextNode = head.next;
        Node newHead = reverseRec(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
