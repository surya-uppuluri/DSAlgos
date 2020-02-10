package surya.practice.misc.leetcode.contests.weekly175;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumStepsForAnagramsTest {

    @Test
    void minStepsNaiveTest() {
        String s = "bab";
        String t = "aba";
        int ret = new MinimumStepsForAnagrams().minSteps(s, t);
        assertEquals(1, ret);
    }

    @Test
    void minStepsEfficientTest() {
        String s = "bab";
        String t = "aba";
        int ret = new MinimumStepsForAnagrams().minStepsEfficient(s, t);
        assertEquals(1, ret);
    }

}
