package surya.practice.geeks.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    @Test
    void maxLenRecursive() {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int maxValue = longestIncreasingSubsequence.maxLenRecursive(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}, 0, Integer.MIN_VALUE);
        assertEquals(6, maxValue);
    }


}