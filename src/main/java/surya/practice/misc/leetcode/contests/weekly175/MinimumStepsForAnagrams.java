package surya.practice.misc.leetcode.contests.weekly175;

import java.util.HashMap;
import java.util.Map;

public class MinimumStepsForAnagrams {
    //@formatter:off
    /**
     *
     * ----------PROBLEM STATEMENT-----------
     *LC1347. Minimum Number of Steps to Make Two Strings Anagram
     * Medium
     *
     * Given two equal-size strings firstString and secondString. In one step you can choose any character of secondString and replace it with another character.
     *
     * Return the minimum number of steps to make secondString an anagram of firstString.
     *
     * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
     *
     *
     *
     * Example 1:
     *
     * Input: firstString = "bab", secondString = "aba"
     * Output: 1
     * Explanation: Replace the first 'a' in secondString with b, secondString = "bba" which is anagram of firstString.
     *
     * Example 2:
     *
     * Input: firstString = "leetcode", secondString = "practice"
     * Output: 5
     * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from secondString with proper characters to make secondString anagram of firstString.
     *
     * Example 3:
     *
     * Input: firstString = "anagram", secondString = "mangaar"
     * Output: 0
     * Explanation: "anagram" and "mangaar" are anagrams.
     *
     * Example 4:
     *
     * Input: firstString = "xxyyzz", secondString = "xxyyzz"
     * Output: 0
     *
     * Example 5:
     *
     * Input: firstString = "friend", secondString = "family"
     * Output: 4
     *
     *
     *
     * Constraints:
     *
     *     1 <= firstString.length <= 50000
     *     firstString.length == secondString.length
     *     firstString and secondString contain lower-case English letters only.
     */
    /* Way 1
                    * ALGORITHM
                    * ----------
                    * 1.
                    * =========================
                    * Time Complexity - O()
                    * Space Complexity - O()
                    * =========================
             * Verdict: INEFFICIENT
             * Runtime: 44 ms, faster than 16.67% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
             * Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
     */

    //@formatter:on
    public int minSteps(String firstString, String secondString) {
        int res = 0;
        HashMap<Character, Integer> firstMap = new HashMap();
        HashMap<Character, Integer> secondMap = new HashMap();
        for (char ch : firstString.toCharArray()) {
            int occurrenceCount = firstMap.getOrDefault(ch, 0);
            firstMap.put(ch, occurrenceCount + 1);
        }
        for (char ch : secondString.toCharArray()) {
            int occurrenceCount = secondMap.getOrDefault(ch, 0);
            secondMap.put(ch, occurrenceCount + 1);
        }
        for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
            char sc = entry.getKey();
            //Only if the difference between first and second is positive, count it
            if ((firstMap.get(sc)) - (secondMap.getOrDefault(sc, 0)) > 0)
                res += (firstMap.get(sc)) - (secondMap.getOrDefault(sc, 0));
        }
        return res;


    }


    /* Way 2
     * ALGORITHM
     * ----------
     * 1. Maintain a array of alphabets. Inc and Dec the counts as per occurrence.
     * =========================
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * =========================
     * Verdict: Efficient
     * Runtime: 1 ms, faster than 100% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
     * Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
     */

    public int minStepsEfficient(String s, String t) {
        int[] chArr = new int['z' - 'a'];
        int res = 0;
        for (char ch : s.toCharArray()) chArr[ch - 'a']++;
        for (char ch : t.toCharArray()) chArr[ch - 'a']--;
        for (int i = 0; i < chArr.length; i++)
            if (chArr[i] > 0) res += chArr[i];
        return res;
    }
}
