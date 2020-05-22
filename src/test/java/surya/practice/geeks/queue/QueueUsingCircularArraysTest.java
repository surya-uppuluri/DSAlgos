package surya.practice.geeks.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueUsingCircularArraysTest {

    QueueUsingCircularArrays queueUsingCircularArrays = new QueueUsingCircularArrays(5);

    @Test
    void isFull() {
        assertFalse(queueUsingCircularArrays.isFull());
    }

    @Test
    void isEmpty() {
        assertTrue(queueUsingCircularArrays.isEmpty());
    }

    @Test
    void enqueue() throws QueueEmptyException {
        queueUsingCircularArrays.enqueue(10);
        assertEquals(1, queueUsingCircularArrays.getSize());
        assertEquals(10, queueUsingCircularArrays.getRear());
    }

    @Test
    void dequeue() throws QueueEmptyException {
        queueUsingCircularArrays.enqueue(10);
        queueUsingCircularArrays.enqueue(20);
        queueUsingCircularArrays.enqueue(30);
        queueUsingCircularArrays.dequeue();
        assertEquals(30, queueUsingCircularArrays.getRear());
        assertEquals(20, queueUsingCircularArrays.getFront());

    }

    @Test
    void getFront() {
        assertThrows(QueueEmptyException.class, () -> queueUsingCircularArrays.getFront());
    }

    @Test
    void getRear() {
        assertThrows(QueueEmptyException.class, () -> queueUsingCircularArrays.getFront());
    }

    @Test
    void size() {
        assertEquals(queueUsingCircularArrays.getSize(), 0);
    }
}