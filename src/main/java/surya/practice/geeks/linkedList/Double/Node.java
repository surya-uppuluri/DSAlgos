package surya.practice.geeks.linkedList.Double;

public class Node
{
    int data;
    Node next;
    Node prev;
    Node(int d)
    {
        data = d;
        next = prev = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
