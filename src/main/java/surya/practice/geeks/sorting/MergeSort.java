package surya.practice.geeks.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MergeSort {

    public int[] sort(int[] arr, int n) {
        if (n < 2) return arr;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);
        log.info("Left is {}", Arrays.toString(left));
        log.info("Right is {}", Arrays.toString(right));
        sort(left, mid);
        sort(right, n - mid);
        log.info("Calling merge on left: {}. right: {}, leftLength: {}, rightLength[{}-{}]:{}, arr:{}", left, right, mid, n, mid, n - mid, arr);
        return merge(left, right, mid, n-mid, arr);
    }

    private int[] merge(int[] left, int[] right, int leftLength, int rightLength, int[] arr) {
       // log.info("Rxed rightLen as: {}", rightLength);
        int k = 0;
        int l = 0;
        int r = 0;
        while (l < leftLength && r < rightLength) {
            if (left[l] <= right[r])
                arr[k++] = left[l++];
            else arr[k++] = right[r++];
        }
        log.info("l: {}, left length: {}, leftArr:{} ", l, leftLength, left);

        while (l < leftLength)
            arr[k++] = left[l++];

        log.info("r: {}, right length: {}, rightArr:{} ", r, rightLength, right);
        while (r < rightLength)
            arr[k++] = right[r++];
        log.info("------------Sorted as: {}---------------", Arrays.toString(arr));
        return arr;
    }
}
