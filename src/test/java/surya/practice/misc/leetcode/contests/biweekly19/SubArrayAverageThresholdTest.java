package surya.practice.misc.leetcode.contests.biweekly19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubArrayAverageThresholdTest {

    @Test
    void numSubArrays() {
        SubArrayAverageThreshold subArrayAverageThreshold = new SubArrayAverageThreshold();
        assertEquals(1,subArrayAverageThreshold.numSubArrays(new int[]{2,2,2,2,5,5,5,8}, 3, 6));
    }
}