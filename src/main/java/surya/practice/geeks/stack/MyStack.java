package surya.practice.geeks.stack;

import java.util.LinkedList;

public class MyStack<T> {
    Integer top;
    private LinkedList<T> list;

    public MyStack() {
        list = new LinkedList<>();
    }


    T pop() {
        return list.remove(list.size() - 1);
    }

    void push(T data) {
        list.add(data);
        System.out.println(list.toString());
        top = list.size();
    }

    public T peek() {
        return list.get(list.size() - 1);
    }
}
