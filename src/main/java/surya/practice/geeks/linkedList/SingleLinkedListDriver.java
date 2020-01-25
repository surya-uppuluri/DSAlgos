package surya.practice.geeks.linkedList;

class SingleLinkedList {

    private Node head;

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
    }

}
