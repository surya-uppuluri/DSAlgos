package surya.practice.geeks.searching;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

//@formatter:off

/**
 * todo - Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
 * <p>
 * Expected Time Complexity: O(n)
 * <p>
 * Input:
 * The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
 * <p>
 * Output:
 * Corresponding to each test case, print the kth smallest element in a new line.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * 1 <= arr[i] <= 105
 * 1 <= K <= N
 * <p>
 * Example:
 * Input:
 * 2
 * 6
 * 7 10 4 3 20 15
 * 3
 * 5
 * 7 10 4 20 15
 * 4
 * <p>
 * Output:
 * 7
 * 15
 * <p>
 * Explanation:
 * Testcase 1: 3rd smallest element in the given array is 7.
 *
 * @author surya
 * @date 12/01/20
 * @time 9:25 AM
 */
//@formatter:on

public class KthSmallestElement {
    //Needs to be done with priority queue.
    //Will revisit this
    //ToDo

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ntc = Integer.parseInt(br.readLine());
        while (ntc-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int arr[] = new int[size];
            String elements[] = br.readLine().trim().split(" ");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }
            int nthElem = Integer.parseInt(br.readLine());
            System.out.println("BruteForce " + findKthSmallestBruteForce(arr, nthElem));
            System.out.println("MinHeap " + findKthSmallestMaxHeap(arr, nthElem));
            System.out.println("QuickSelect " + findKthSmallestQuickSelect(arr, nthElem));


        }
    }


    //@formatter:off

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1.
     * =========================
     * Space Complexity - O()
     * Time Complexity - O()
     * ========================
     */
    //@formatter:on
    private static int findKthSmallestQuickSelect(int[] arr, int nthElem) {
        return kthSmallest(arr, 0, arr.length, nthElem);
    }

    static int kthSmallest(int arr[], int l, int r, int k) {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1) {

            // partitioning the array along the pivot
            int pos = randomPartition(arr, l, r);


            // check if current element gives you the kth smallest element
            if (pos - l == k - 1)
                return arr[pos];

            // else recurse for the left and right half accordingly
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        return Integer.MAX_VALUE;
    }


    static int partition(int arr[], int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;
        return i;
    }

    // Function to partition the array along the random pivot
    static int randomPartition(int arr[], int l, int r) {
        Random rand = new Random();
        int n = r - l + 1;
        int pivot = rand.nextInt(n);
        int temp = arr[r];
        arr[r] = arr[l + pivot];
        arr[l + pivot] = temp;
        return partition(arr, l, r);
    }


    private static int findKthSmallestMaxHeap(int[] arr, int nthElem) {
        return 0;
    }

    private static int findKthSmallestBruteForce(int[] arr, int nthElem) {

        //@formatter:off
        /**
         * ----------
         * ALGORITHM
         * ----------
         * 1. Sort the array in non-decreasing order using BubbleSort 
         * 2. Return arr[nthElem]
         */
        //@formatter:on

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr[nthElem - 1];
    }
}
