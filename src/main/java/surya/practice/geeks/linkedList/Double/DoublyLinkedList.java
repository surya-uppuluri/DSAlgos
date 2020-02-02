package surya.practice.geeks.linkedList.Double;

public class DoublyLinkedList {

    Node head;

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    String printList() {
        Node temp = head;
        StringBuffer stringBuffer = new StringBuffer();
        while (temp != null) {
            stringBuffer.append(temp.data).append(" ");
            temp = temp.next;
        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    //@formatter:off
                    /**
                    * ----------
                    * ALGORITHM
                    * ----------
                    * 1. Traverse till the given index and mark the prev and next indices accordingly
                    * =========================
                    * Space Complexity - O(n) for len check + O(n) for traverse during deletion
                    * Time Complexity - O(1)
                    * =========================
                    */
                    //@formatter:on

                    Node deleteNode(int x) throws NoSuchIndexException {

                        int len = getLengthOfDLL();
                        if (x > len || x < 0) {
                            throw new NoSuchIndexException("No such index in the list");
                        }
                        if (x == 1) {
                            head.next.prev = null;
                            head = head.next;
                            return head;
                        }

                        Node temp = head;
                        for (int ctr = 1; ctr < x; ctr++) {
                            temp = temp.next;
                        }
                        if (temp.next != null)
                            temp.next.prev = temp.prev;

                        temp.prev.next = temp.next;

                        return head;
                    }

    public int getLengthOfDLL() {
        int ctr = 0;
        while (head != null) {
            ctr++;
            head = head.next;
        }
        return ctr;
    }


    Node reverse() {
        if (head.next == null) return head;
        Node temp = null;
        Node curr = head;
        while (curr != null) {

            //prev and next shall be interchanged
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null)
            head = temp.prev;

        return head;

    }
}
