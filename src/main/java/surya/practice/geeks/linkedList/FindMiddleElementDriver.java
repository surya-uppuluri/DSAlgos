package surya.practice.geeks.linkedList;

public class FindMiddleElementDriver {

    public static void main(String[] args) {
        System.out.println("Method 1 - Naive 2 pass approach");
        oddElementNaiveTest();
        evenElementNaiveTest();
        emptyListNaiveTest();
        System.out.println("Method 2 - Fast and slow pointers");
        oddElement2PointerTest();
        evenElement2PointerTest();
        emptyList2PointerTest();
        System.out.println("Method3 - Efficient traversal");
        oddElementEfficientTest();
        evenElementEfficientTest();
        emptyListEfficientTest();

    }


    private static void emptyListNaiveTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        findMiddleElementNaive(singleLinkedList);
    }

    private static void oddElement2PointerTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getAnyListWithOddLength();
        findMiddleElementUsing2Pointers(singleLinkedList);
    }


    private static void evenElement2PointerTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getAnyListWithEvenLength();
        findMiddleElementUsing2Pointers(singleLinkedList);


    }

    private static void emptyList2PointerTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        findMiddleElementUsing2Pointers(singleLinkedList);
    }

    private static void findMiddleElementUsing2Pointers(SingleLinkedList singleLinkedList) {
        Node head = singleLinkedList.getHead();
        if (head == null) {
            System.out.println("No middle element exists as the list is empty");
            return;
        }
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("Middle element of " + singleLinkedList.traverse() + "is " + slow.data);

    }

    private static void oddElementNaiveTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getAnyListWithOddLength();
        findMiddleElementNaive(singleLinkedList);
    }

    private static void evenElementNaiveTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getAnyListWithEvenLength();
        findMiddleElementNaive(singleLinkedList);
    }


    private static void findMiddleElementNaive(SingleLinkedList singleLinkedList) {
        int length = singleLinkedList.getLength();
        if (length > 0) {
            int subCount = 0;
            Node head = singleLinkedList.getHead();
            while (subCount != length / 2) {
                head = head.next;
                subCount++;
            }
            System.out.println("Middle element of " + singleLinkedList.traverse() + "is " + head.data);
        } else {
            System.out.println("No middle element exists as the list is empty");

        }

    }


    private static void evenElementEfficientTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getAnyListWithEvenLength();
        findMiddleElementEfficiently(singleLinkedList);
    }

    private static void oddElementEfficientTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList().getAnyListWithOddLength();
        findMiddleElementEfficiently(singleLinkedList);
    }

    private static void emptyListEfficientTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        findMiddleElementEfficiently(singleLinkedList);
    }

    private static void findMiddleElementEfficiently(SingleLinkedList singleLinkedList) {
        Node head = singleLinkedList.getHead();
        int count = 0;
        Node current = head;
        Node middle = head;
        if (head == null) {
            System.out.println("No middle element exists as the list is empty");
            return;
        }
        while (current != null) {
            if (count % 2 == 1) {
                middle = middle.next;
            }
            count++;
            current = current.next;
        }
        System.out.println("Middle element of " + singleLinkedList.traverse() + "is " + middle.data);
    }

}
