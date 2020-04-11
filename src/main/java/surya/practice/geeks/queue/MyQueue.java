package surya.practice.geeks.queue;


public interface MyQueue<T> {

    Boolean isFull();

    Boolean isEmpty();

    void enqueue(T element);

    void dequeue();

    T getFront() throws QueueEmptyException;


    T getRear() throws QueueEmptyException;

    Integer size();
}
