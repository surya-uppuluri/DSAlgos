package surya.practice.geeks.arrays;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 * <p>
 * Output:
 * Print the maximum sum of the contiguous sub-array in a separate line for each test case.
 * <p>
 * User Task:
 * The task is to complete the function maxSubArraySum() which finds subarray with maximum sum.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 110
 * 1 ≤ N ≤ 106
 * -107 ≤ A[i] <= 107
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 -2 5
 * 4
 * -1 -2 -3 -4
 * <p>
 * Output:
 * 9
 * -1
 * <p>
 * Explanation:
 * Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
 */
class KadanesDriver {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Kadane obj = new Kadane();

            System.out.println(obj.maxSubArraySum(arr, n));
        }
    }
}


class Kadane {

    int maxSubArraySum(@NotNull int[] arr, int n) {

        int max_cur = arr[0];
        int max_global = arr[0];

        for (int i = 1; i < n; i++) {

            max_cur = Math.max(max_cur + arr[i], arr[i]);
            if (max_cur > max_global) max_global = max_cur;

        }

        return max_global;

    }

}
