package surya.practice.geeks.linkedList;


public class SingleLinkedList<T> {

    private Node head;

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    public SingleLinkedList() {
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" + printLinkedList() + '}';
    }

    public String printLinkedList() {
        Node head = this.getHead();
        StringBuffer stringBuffer = new StringBuffer();
        while (head != null) {
            stringBuffer.append(head.data).append("->");
            head = head.next;
        }
        stringBuffer.append("null");
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }

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

    public SingleLinkedList insertAtEnd(T value) {
        Node currNode;
        if (!(value.getClass() == new Node(5).getClass())) {
            currNode = new Node(value);

        } else {
            currNode = (Node) value;
        }
        if (head == null) {
            head = currNode;
            return this;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = currNode;

        // traverse();
        return this;
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

    public void delete(T elem) {
        if (head == null) {
            System.out.println("No elements to delete yet");
            return;
        }
        if (elem.equals(head.data)) {
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


    public Node[] traverse() {
        if (this.hasLoop() != null) {
            System.out.println("Loop is detected in the List at " + this.hasLoop().data + ". Not printing the list..");
            return null;
        }
        this.getLength();
        Node[] listOfNodes = new Node[this.getLength()];

        int i = 0;
        Node curr = head;
        if (curr == null) {
            return new Node[0];
        }
        while (curr != null) {
            Node node = new Node(curr.data);
            node.next = curr.next;
            curr = curr.next;
            listOfNodes[i++] = node;
        }
        printLinkedList();
        return listOfNodes;
    }

    private Node hasLoop() {

        Node slow = this.getHead();
        Node fast = slow;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /**
             * Do comparision only after moving because, their initial point is same
             */
            if (fast == slow)
                return fast;
        }
        return null;
    }

    public SingleLinkedList<T> insertAfter(T elem, T newElem) {
        Node curr = this.head;
        while (curr.next != null) {
            if (curr.data.equals(elem)) {
                Node newNode = new Node(newElem);
                newNode.next = curr.next;
                curr.next = newNode;
                System.out.println("Insert after " + elem + " is success");
                traverse();
                return this;
            } else {
                curr = curr.next;
            }
        }
        return this;
    }

    SingleLinkedList getIntegerListWithOddLength() {
        SingleLinkedList singleLinkedList = new SingleLinkedList(new Node(25));
        singleLinkedList.insertAtEnd(1);
        singleLinkedList.insertAtEnd(2);
        singleLinkedList.insertAtEnd(3);
        singleLinkedList.insertAtEnd(4);
        singleLinkedList.insertAtEnd(5);
        System.out.print("Initial list :: ");
        singleLinkedList.printLinkedList();
        return singleLinkedList;
    }

    SingleLinkedList getIntegerListWithEvenLength() {
        return getIntegerListWithOddLength().insertAtEnd(6);
    }

    public Node<T> getLastNode() {
        Node<T> reference = getHead();
        while (reference.next != null) {
            reference = reference.next;
        }
        return reference;
    }
}

