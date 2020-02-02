package surya.practice.geeks.linkedList;

public class FindMiddleElement {


    public Node findMiddleElementUsing2Pointers(SingleLinkedList singleLinkedList) throws EmptyListException {
        Node head = singleLinkedList.getHead();
        if (head == null) {
            System.out.println("No middle element exists as the list is empty");
            throw new EmptyListException("The list is empty");
        }
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("Middle element of " + singleLinkedList.printLinkedList() + " is " + slow.data);
        return slow;
    }


    public Node findMiddleElementNaive(SingleLinkedList singleLinkedList) throws EmptyListException {
        int length = singleLinkedList.getLength();
        if (length > 0) {
            int subCount = 0;
            Node head = singleLinkedList.getHead();
            while (subCount != length / 2) {
                head = head.next;
                subCount++;
            }
            System.out.println("Middle element of " + singleLinkedList.printLinkedList() + " is " + head.data);
            return head;
        } else {
            System.out.println("No middle element exists as the list is empty");
            throw new EmptyListException("The list is empty");
        }


    }

    public Node findMiddleElementEfficiently(SingleLinkedList singleLinkedList) throws EmptyListException {
        Node head = singleLinkedList.getHead();
        int count = 0;
        Node current = head;
        Node middle = head;
        if (head == null) {
            System.out.println("No middle element exists as the list is empty");
            throw new EmptyListException("The list is empty");
        }
        while (current != null) {
            if (count % 2 == 1) {
                middle = middle.next;
            }
            count++;
            current = current.next;
        }
        System.out.println("Middle element of " + singleLinkedList.printLinkedList() + " is " + middle.data);
        return middle;
    }

}
