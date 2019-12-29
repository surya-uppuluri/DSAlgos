package surya.practice.geeks.searching;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/count-1s-in-binary-array/
 * <p>
 * Given a binary sorted non-increasing array arr of size N. You need to print the count of 1's in the binary array.
 * <p>
 * Input:
 * The input line contains T, denotes the number of testcases. Each input contains two lines. The first line contains N(size of binary array). The second line contains N elements of binary array separated by space.
 * <p>
 * Output:
 * For each testcase in new line, print the count 1's in binary array.
 * <p>
 * User Task:
 * The task is to complete the function countOne() which return count of 1s in the input array.
 * <p>
 * Constraint:
 * 1 <= T <= 100
 * 1 <= N <= 5*106
 * 0 <= arr[i] <= 1
 * <p>
 * Example:
 * Input:
 * 2
 * 8
 * 1 1 1 1 1 0 0 0
 * 8
 * 1 1 0 0 0 0 0 0
 * <p>
 * Output:
 * 5
 * 2
 * <p>
 * Explanation:
 * Testcase 1: Number of 1's in given binary array : 1 1 1 1 1 0 0 0 is 5.
 */
class CountOnesInBinaryArray {

    static int arr[] = new int[5000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            CountOfOneFinder obj = new CountOfOneFinder();
            System.out.println(obj.countOnes(n));


        }

    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class CountOfOneFinder {

    // Object of Arrays class to access array declared
    // in Arrays class
    // To access i-th element of array, use obj.arr[i]
    static CountOnesInBinaryArray obj = new CountOnesInBinaryArray();

    // Function to count number of ones in the binary array
    // n: size of array
    // To access i-th element of array, use obj.arr[i]
    public static int countOnes(int n) {

        int low = 0;
        int high = obj.arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //Finding the greatest extent till which the non-decreasing array has ones
            //Corner case: What if array contains all ones?? Then all the elements will be 1s. mid+1 will never be zero.
            //So, add that condition
            if (obj.arr[mid] == 1 && (obj.arr[mid + 1] == 0 || mid == n - 1)) {
                return mid + 1;
            } // Actual count of ones is 1+ the array count (which starts from zero).
            else if (obj.arr[mid] == 0)
                high = mid - 1;
            else if (obj.arr[mid] == 1)
                low = mid + 1;
        }

        return -1;
    }
}
