package surya.practice.geeks.linkedList;

class SingleLinkedList {

    private Node head;


    public int getLength() {
        Node head = this.getHead();
        if (null == head)
            return 0;
        else {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }

    public void insertAtEnd(int elem) {
        Node temp = new Node(elem);
        if (head == null) {
            head = temp;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        traverse();
    }

    public void insertAtBeginning(int elem) {
        Node temp = new Node(elem);
        if (head == null) {
            head = temp;
            traverse();
            return;
        }
        temp.next = head;
        head = temp;
        traverse();


    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void delete(int elem) {
        if (head == null) {
            System.out.println("No elements to delete yet");
            return;
        }
        if (elem == head.data) {
            head = head.next;
            System.out.println("Deletion from start successful");
            return;

        }
        Node curr = head;

        while (curr.next != null && curr.next.data != elem) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
            System.out.println("Deletion successful");
        } else {
            System.out.println("Element to be deleted not found");
        }
        traverse();
    }


    public String traverse() {
        Node curr = head;
        if (curr == null) {
            return "No elements yet. Empty list";
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (curr.next != null) {
            stringBuffer.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        stringBuffer.append(curr.data).append(" -> null ");
        return stringBuffer.toString();
    }

    public void insertAfter(int elem) {
        if (head.data == elem) {

        }
    }

    SingleLinkedList getAnyListWithOddLength() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertAtEnd(1);
        singleLinkedList.insertAtEnd(2);
        singleLinkedList.insertAtEnd(3);
        singleLinkedList.insertAtEnd(4);
        singleLinkedList.insertAtEnd(5);
        return singleLinkedList;
    }

    SingleLinkedList getAnyListWithEvenLength() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertAtEnd(1);
        singleLinkedList.insertAtEnd(2);
        singleLinkedList.insertAtEnd(3);
        singleLinkedList.insertAtEnd(4);
        singleLinkedList.insertAtEnd(5);
        singleLinkedList.insertAtEnd(6);
        return singleLinkedList;

    }

}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }
}

public class SingleLinkedListDriver {

    public static void main(String[] args) {
        SingleLinkedList slList = new SingleLinkedList();
        slList.insertAtEnd(1);
        slList.insertAtEnd(2);
        slList.insertAtEnd(3);
        slList.insertAtEnd(4);
        slList.delete(3);
        slList.delete(5);
        slList.delete(1);
        slList.insertAtEnd(9);
        slList.insertAtBeginning(100);
        slList.insertAfter(9);
    }

}
