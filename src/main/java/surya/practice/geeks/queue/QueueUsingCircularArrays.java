package surya.practice.geeks.queue;

public class QueueUsingCircularArrays<T> implements MyQueue<T> {

    private int size;
    private int capacity;
    int front;
    int rear;
    T[] arr;

    public int getSize() {
        return size;
    }

    QueueUsingCircularArrays(int capacity) {
        arr = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public Boolean isFull() {
        return size == capacity;
    }

    @Override
    public Boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(Object element) {
        rear = (front + size - 1) % capacity;
        rear = (rear + 1) % capacity;
        arr[rear] = (T) element;
        size++;
    }

    @Override
    public void dequeue() {
        front = (front + 1) % capacity;
        size--;
    }

    @Override
    public T getFront() throws QueueEmptyException {
        if (this.size == 0)
            throw new QueueEmptyException();
        return arr[front];
    }

    @Override
    public T getRear() throws QueueEmptyException {
        if (this.size == 0)
            throw new QueueEmptyException();
        return arr[rear];
    }

    @Override
    public Integer size() {
        return null;
    }
}
