package surya.practice.geeks.arrays;

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Next larger element
 * Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1
 * <p>
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. Each test case consists of two lines. The first line contains an integer N denoting the size of the array. The Second line of each test case contains N space separated positive integers denoting the values/elements in the array A.
 * <p>
 * Output:
 * For each test case, print in a new line, the next greater element for each array element separated by space in order.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1018
 * Example:
 * Input
 * 2
 * 4
 * 1 3 2 4
 * 4
 * 4 3 2 1
 * Output
 * 3 4 4 -1
 * -1 -1 -1 -1
 * <p>
 * Explanation:
 * Testcase1: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? since it doesn't exist hence -1.
 */
class NextLargerElement {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ntc = Integer.parseInt(br.readLine().trim());
        while (ntc-- > 0) {
            int sa = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[sa];
            String[] elem = br.readLine().split(" ");
            for (int i = 0; i < sa; i++)
                arr[i] = Integer.parseInt(elem[i]);
            int[] res = new int[sa];
            if (sa == 1) {
                System.out.println(arr[0]);
                return;
            }
            for (int i = 0; i < sa; i++) {
                res[i] = -1;
                for (int j = i + 1; j < sa; j++) {
                    if (arr[j] > arr[i]) {
                        res[i] = arr[j];
                        break;
                    }

                }
            }
            for (int re : res) System.out.print(re + " ");
            System.out.println();

        }


    }
}