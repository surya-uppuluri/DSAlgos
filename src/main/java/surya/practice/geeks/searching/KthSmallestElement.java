package surya.practice.geeks.searching;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        return 0;
        //TODO after sorting
    }

    private static int findKthSmallestMaxHeap(int[] arr, int nthElem) {
        return 0;
        //TODO after heaps
    }

    private static int findKthSmallestBruteForce(int[] arr, int nthElem) {

        //@formatter:off
        /**
         * ----------
         * ALGORITHM
         * ----------
         * 1. Sort the array in non-decreasing order using BubbleSort 
         * 2. Return arr[nthElem]
         * =========================
         * Space Complexity - O(1)
         * Time Complexity - O(n^2)
         * ========================
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
