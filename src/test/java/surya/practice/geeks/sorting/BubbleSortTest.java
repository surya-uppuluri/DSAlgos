package surya.practice.geeks.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(new int[]{10, 50, 70, 20, 90, 30});
        assertEquals(Arrays.toString(new int[]{10, 20, 30, 50, 70, 90}), Arrays.toString(result));
    }
}