package surya.practice.geeks.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class QuickSort {

    /*
[main] INFO surya.practice.geeks.sorting.QuickSort - Swapped: 10 10
[main] INFO surya.practice.geeks.sorting.QuickSort - Swapped: 20 50
[main] INFO surya.practice.geeks.sorting.QuickSort - Swapped: 30 70
[main] INFO surya.practice.geeks.sorting.QuickSort - Swapped: 10 10
[main] INFO surya.practice.geeks.sorting.QuickSort - Swapped: 20 20
[main] INFO surya.practice.geeks.sorting.QuickSort - Sorted array is [10, 20, 30, 50, 90, 70]
[main] INFO surya.practice.geeks.sorting.QuickSort - Swapped: 50 50
[main] INFO surya.practice.geeks.sorting.QuickSort - Swapped: 70 90
[main] INFO surya.practice.geeks.sorting.QuickSort - Sorted array is [10, 20, 30, 50, 70, 90]
[main] INFO surya.practice.geeks.sorting.QuickSort - Sorted array is [10, 20, 30, 50, 70, 90]
     */

    /**
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public int[] sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivot = getPivotIndex(arr, begin, end);
            sort(arr, begin, pivot - 1);
            sort(arr, pivot + 1, end);
            log.info("Sorted array is {}", Arrays.toString(arr));
        }
        return arr;
    }

    private int getPivotIndex(int[] arr, int low, int high) {
        // 10 50 70 20 90 30
        //choose 30 as partition, sort the elements and return
        //the new pivot
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                //increment i and swap i and j
                //10<30, swap has no effect
                //10 50 70 20 90 30
                // i = 1
                // j = 1
                // 50 !<30 no effect, go on, j =2
                //70!<30 no effect, go on j = 3
                //20 <30 swap arr[1] and arr[3]
                //10 20 70 50 90 30 i = 2
                // j =4
                //90!<30 no effect
                //that's all high -1 is reached
                i++;
                swap(arr, i, j);
            }
        }
        //finally, 30 should be kept in it's sorted place
        //swap arr[i+1] and pivot
        //10 20 30 50 90 70
        swap(arr, i + 1, high);
        //return new pivot as 50

        return i + 1;

    }

    private void swap(int[] arr, int first, int next) {
        int temp = arr[first];
        arr[first] = arr[next];
        arr[next] = temp;
        log.info("Swapped: {} {}", arr[first], arr[next]);
    }

}
