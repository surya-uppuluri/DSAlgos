package surya.practice.geeks.heap;

public class MinHeapWithArrays {

    public final int FRONT = 1;
    private int size;
    private int min;
    private int[] heap;
    private int maxSize;


    //@formatter:off

    /**
     * --------------------------------------
     * ALGORITHM - Initialization of min heap
     * --------------------------------------
     * 1.  Implement it using an array
     * 2. Since the 0th elem is always fixed at INTEGER.MIN_VALUE, allow one extra space for the given size.
     */
    //@formatter:on
    public MinHeapWithArrays(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.min = Integer.MIN_VALUE;
        this.heap = new int[maxSize + 1];
    }

    public static void main(String[] args) {

        System.out.println("The Min Heap is ");
        MinHeapWithArrays minHeap = new MinHeapWithArrays(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.constructMinHeap();
        minHeap.print();
        System.out.println("The Min val removed is " + minHeap.extractMin());
        System.out.println("Now the Min val is " + minHeap.getMin());
        System.out.println("-----------------------The tree after removal of min ----------------");
        minHeap.print();
    }

    private void constructMinHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            sinkDown(pos);
        }
    }

    private int getMin() {
        return heap[FRONT];
    }

    private int extractMin() {
        int toBeRemoved = heap[FRONT];
        //Assign the recent most inserted element as FRONT (root) and do rearranging
        heap[FRONT] = heap[size--];
        sinkDown(FRONT);
        return toBeRemoved;
    }


    //@formatter:off
    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1. If the node is non-leafy and greater than any of it's children
     *  i) If left child is lesser than right child
     *      a) Swap the node with left child
     *      b) sinkDown on the left child
     *  ii) Else
     *      a) Swap the node with right child
     *      b) sinkDown on the right child
     * =========================
     * Space Complexity - O()
     * Time Complexity - O()
     * =========================
     */
    //@formatter:on
    private void sinkDown(int front) {
        if (!isLeaf(front)) {
            if (heap[front] > heap[left(front)] || heap[front] > heap[right(front)]) {
                if (heap[left(front)] < heap[right(front)]) {
                    swap(front, left(front));
                    sinkDown(left(front));
                } else {
                    swap(front, right(heap[front]));
                    sinkDown(right(front));
                }
            }
        }
    }

    private int left(int front) {
        return 2 * front;
    }

    private int right(int front) {
        return 2 * front + 1;
    }

    private boolean isLeaf(int front) {
        return front >= (size / 2) && front <= size;
    }

    private void print() {
        /**
         * size/2 as we are accessing 2*i
         * <= size/2 since even the last row has to be accessed
         */
        for (int i = 1; i <= size / 2; i++) {
            System.out.println("PARENT: " + heap[i] + " LEFT: " + heap[2 * i] + " RIGHT: " + heap[2 * i + 1]);
        }
    }
    //@formatter:off

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1. Check the corner case of overflow. current size shall be always less than maxSize.
     * 2. Parents shall be having elements lesser  than children. So, take care of that restructuring too by swapping.
     * =========================
     * Space Complexity - O()
     * Time Complexity - O()
     * =========================
     */
    //@formatter:on
    private void insert(int elem) {

        if (size >= maxSize)
            return;

        heap[++size] = elem;
        int current = size;

        //if current inserted element is greater than the parent, no swapping is needed.
        //Else, keep swapping the nodes and move up till the root
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void swap(int current, int parent) {
        int temp = heap[current];
        heap[current] = heap[parent];
        heap[parent] = temp;
    }


    private int parent(int pos) {
        return pos / 2;
    }

}
