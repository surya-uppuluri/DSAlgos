package surya.practice.geeks.linkedList;

public class Node<T> {
    Node next;
    T data;
    Boolean visited;

    Node(T data) {
        this.data = data;
        this.visited = false;
    }
}
