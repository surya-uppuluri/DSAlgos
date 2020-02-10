package surya.practice.geeks.arrays;

public class ReplaceWithGreatestRight {
//@formatter:off
    /**
     *
     * ----------PROBLEM STATEMENT-----------
     *LC1299. Replace Elements with Greatest Element on Right Side
     * Easy
     *
     * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
     *
     * After doing so, return the array.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [17,18,5,4,6,1]
     * Output: [18,6,6,6,1,-1]
     *
     *
     *
     * Constraints:
     *
     *     1 <= arr.length <= 10^4
     *     1 <= arr[i] <= 10^5/

     * ----------
     * ALGORITHM - Brute Force
     * ----------
     * 1.
     * =========================
     * Time Complexity - O()
     * Space Complexity - O(n^2)
     * =========================
     *Verdict:
     * Runtime: 243 ms, faster than 5.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     * Memory Usage: 43.3 MB, less than 100.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     */

    public int[] replaceElements(int[] arr) {
        //bruteforce first

        for (int i = 0; i < arr.length; i++) {
            int currMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > currMax)
                    currMax = arr[j];
            }
            arr[i] = currMax;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }


}
