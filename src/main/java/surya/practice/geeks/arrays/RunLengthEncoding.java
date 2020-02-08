package surya.practice.geeks.arrays;

import java.util.ArrayList;

public class RunLengthEncoding {
    /**
     * ----------PROBLEM STATEMENT-----------
     * LC1313. Decompress Run-Length Encoded List
     * Easy
     *
     * We are given a list nums of integers representing a list compressed with run-length encoding.
     *
     * Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.
     *
     * Return the decompressed list.
     */
    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1.
     * =========================
     * Time Complexity - O()
     * Space Complexity - O()
     * =========================
     * Runtime: 3 ms, faster than 64.42% of Java online submissions for Decompress Run-Length Encoded List.
     * Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
     */


    public int[] decompressRLElistNaive(int[] nums) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int k = 0; k < freq; k++)
                list.add(val);

        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;

    }

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1. Precompute the size of result rather than using arraylist and array copy
     * =========================
     * Time Complexity - O()
     * Space Complexity - O()
     * =========================
     * Runtime: 1 ms, faster than 99.02% of Java online submissions for Decompress Run-Length Encoded List.
     * Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
     */

    public int[] decompressRLEListEfficiently(int[] nums) {
        int outSize = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            outSize += nums[i];
        }
        int[] res = new int[outSize];
        int rv = 0;

        for (int i = 0; i < nums.length - 1; i = i + 2) {
            int freq = nums[i];
            int num = nums[i + 1];
            for (int n = 0; n < freq; n++)
                res[rv++] = num;
        }
        return res;
    }
}
