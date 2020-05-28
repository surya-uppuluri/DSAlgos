package surya.practice.geeks.recursion;/*package whatever //do not write package name here */

import lombok.extern.slf4j.Slf4j;

/**
 * Longest Increasing Subsequence
 * Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
 * The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 * <p>
 * Note: Duplicate numbers are not counted as increasing subsequence.
 * <p>
 * Input:
 * The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.
 * <p>
 * Output:
 * For each testcase, in a new line, print the Max length of the subsequence in a separate line.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 1000
 * 0 ≤ A[i] ≤ 300
 * <p>
 * Example:
 * Input:
 * 2
 * 16
 * 0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
 * 6
 * 5 8 3 7 9 1
 * <p>
 * Output:
 * 6
 * 3
 * <p>
 * Explanation:
 * Testcase 2: Longest increasing subsequence is of size 3 with elements (there are many subsequence, but listing one of them): 5 7 9.
 **/
@Slf4j
class LongestIncreasingSubsequence {
    /**
     * Following method proves that simple iteration cannot work here
     * To generate permutations of data, iteration is ineffective.
     * 0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
     * For example, starting from 0, 8 will be the next big element on which another premutation
     * is needed by not including it as well. Only recursion can do it well.
     */
    private static int maxLenIterativeThatCantWork(int[] arr) {
        int length = arr.length;
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int locMax = 0;
            int maxSoFar = 0;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] > arr[i] && arr[j] > maxSoFar) {
                    locMax++;
                    maxSoFar = arr[j];
                    if (locMax > currMax)
                        currMax = locMax;
                }
            }
        }
        return currMax;
    }

    public int maxLenRecursive(int[] arr, int n, int currMax) {

        if (n == arr.length) return 0;
        int included = 0;
        boolean incl = false;
        if (arr[n] > currMax) {
            incl = true;
            log.info("including {}. CurrMax is: {}", arr[n], currMax);
            included = 1 + maxLenRecursive(arr, n + 1, arr[n]);
        }
        if (!incl)
            log.info("Going ahead by not including {} as {} !> {}. CurrMax is: {}", arr[n], arr[n], currMax, currMax);
        else {
            log.info("Going ahead for a fresh call for {}. CurrMax is: {}", arr[n], currMax);

        }
        int ni = maxLenRecursive(arr, n + 1, currMax);
        int res = Math.max(included, ni);
        log.info("Comparing {} with {}. Returning result as {}", included, ni, res);
        return res;

    }
}