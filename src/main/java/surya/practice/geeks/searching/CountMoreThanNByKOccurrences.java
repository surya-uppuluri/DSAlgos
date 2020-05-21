package surya.practice.geeks.searching;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

//@formatter:off

/**
 * todo - Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. Then the next line contains n space separated integers forming the array. The last line of input contains an integer k.
 * <p>
 * Output:
 * Print the count of elements in array that appear more than n/k times.
 * <p>
 * User Task:
 * The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.
 * <p>
 * Constraints:
 * 1 <= T <= 102
 * 1 <= N <= 106
 * 1 <= a[i] <= 106
 * 1 <= k <= N
 * <p>
 * Example:
 * Input:
 * 2
 * 8
 * 3 1 2 2 1 2 3 3
 * 4
 * 4
 * 2 3 3 2
 * 3
 * <p>
 * Output:
 * 2
 * 2
 * <p>
 * Explanation:
 * Testcase 1: In the given array, 3 and 2 are the only elements that appears more than n/k times.
 *
 * @author surya
 * @date 12/01/20
 * @time 1:17 PM
 */
//@formatter:on

public class CountMoreThanNByKOccurrences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(countOccurrence(arr, n, k));
        }
    }

    //@formatter:off

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1. Store all values and occurrences in hashMap
     * 2. Get count and return
     * =========================
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     * =========================
     */
    //@formatter:on
    private static int countOccurrence(int[] arr, int n, int k) {
        HashMap<Integer, Integer> resMap = new HashMap();
        for (int i = 0; i < n; i++)
            resMap.put(arr[i], resMap.getOrDefault(arr[i], 0) + 1);

        int threshold = n / k;

        System.out.println("getCountBySorting" + getCountBySorting(threshold, arr)); //Way 6

        /**
         Good use case for looking into various ways of iterating a hashmap
         */
        System.out.println(getCountUsingHMLambda(threshold, resMap)); //Way1
        System.out.println(getCountUsingForEachEntrySetIteration(threshold, resMap));//Way2
        System.out.println(getCountUsingIterateKeyThenGetValue(threshold, resMap));//Way3 - Inefficient
        System.out.println(getCountUsingValuesIteration(threshold, resMap)); //Way4
        return getCountUsingPlainOldIterator(threshold, resMap); //Way5

    }

    //@formatter:off

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1. Sort the array
     * 2. Compare adjacent elements and increase the frequency op on finding a match
     * 3. If count of a specific sequence is greater than n/k, increment.
     * 4. Else, re-initiate the count and repeat till elements are exhausted
     * ===================================================
     * Space Complexity - O(1)
     * Time Complexity - O(n^2) due to sorting
     * ===================================================
     */
    //@formatter:on
    private static int getCountBySorting(int threshold, int[] arr) {
        int res = 0;
        int freq = 1; // frequency is already 1 when you traverse any element
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                freq = freq + 1;
            else freq = 1; //reset the freq if a new element is encountered

            //if(freq>(threshold)) // There could be many elements of same value even after it's added to result. So don't consider like this
            if (freq == threshold + 1) //This check, contrary to above one makes sure that an element is added to res only once.
            {
                res += 1;
            }
        }
        return res;
    }

    private static int getCountUsingPlainOldIterator(int threshold, HashMap<Integer, Integer> resMap) {
        Iterator<Map.Entry<Integer, Integer>> iterator = resMap.entrySet().iterator();
        int res = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getValue() > threshold) res++;
        }
        return res;
    }

    private static int getCountUsingIterateKeyThenGetValue(int threshold, HashMap<Integer, Integer> resMap) {
        int count = 0;
        for (Integer key : resMap.keySet()) {
            if (resMap.get(key) > threshold)
                count++;
        }
        return count;
    }

    private static int getCountUsingValuesIteration(int threshold, HashMap<Integer, Integer> resMap) {
        int count = 0;
        for (Integer val : resMap.values()) {
            if (val > threshold)
                count++;
        }
        return count;
    }

    private static int getCountUsingForEachEntrySetIteration(int threshold, HashMap<Integer, Integer> resMap) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : resMap.entrySet()) {
            if (entry.getValue() > threshold) {
                count++;
            }
        }
        return count;
    }

    private static int getCountUsingHMLambda(int threshold, HashMap<Integer, Integer> resMap) {
        AtomicInteger res = new AtomicInteger();
        resMap.forEach((key, val) -> {
            if (val > threshold) {
                res.getAndIncrement();
            }
        });
        return res.get();
    }
}
