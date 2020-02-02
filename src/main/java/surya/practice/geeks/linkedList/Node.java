package surya.practice.geeks.linkedList;

public class Node<T> {
    Node next;
    T data;
    Boolean visited;

    Node(T data) {
        this.data = data;
        this.visited = false;
    }


    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
