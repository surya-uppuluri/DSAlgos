package surya.practice.geeks.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc53_MaximumSubArrayTest {

    @Test
    void maxSubArray() {
        Lc53_MaximumSubArray lc53_maximumSubArray = new Lc53_MaximumSubArray();
        int maxSumRes = lc53_maximumSubArray.maxSubArray_bruteForce(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, maxSumRes);
    }
}