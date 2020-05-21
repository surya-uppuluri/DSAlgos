package surya.practice.geeks.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class QuickSortTest {

    @Test
    void quickSort() {
        QuickSort quickSort = new QuickSort();
        int[] result = quickSort.sort(new int[]{10, 50, 70, 20, 90, 30}, 0, 5);
        assertEquals(Arrays.toString(new int[]{10, 20, 30, 50, 70, 90}), Arrays.toString(result));
    }
}