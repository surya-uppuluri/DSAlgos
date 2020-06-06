package surya.practice.geeks.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> lowHeap; // Max Heap
	PriorityQueue<Integer> highHeap; // Min Heap

    /** initialize your data structure here. */
    public MedianFinder() {
        lowHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		highHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
      if (isEmpty() || lowHeap.size() <= highHeap.size()) {
        lowHeap.add(num);
      } else {
        highHeap.add(num);
      }
      if (highHeap.size() == 0 || lowHeap.size() == 0) {
        return;
      }
		if (lowHeap.peek() > highHeap.peek())
		{
			int temp = lowHeap.poll();
			lowHeap.add(highHeap.poll());
			highHeap.add(temp);
		}
    }

    public double findMedian() {
      if (lowHeap.size() > highHeap.size()) {
        return lowHeap.peek();
      } else if (lowHeap.size() < highHeap.size()) {
        return highHeap.peek();
      } else {
        return (double) (lowHeap.peek() + highHeap.peek()) / 2;
      }
    }

    public boolean isEmpty()
	{
		return lowHeap.isEmpty() && highHeap.isEmpty();
	}
}