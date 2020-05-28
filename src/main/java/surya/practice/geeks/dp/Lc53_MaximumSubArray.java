package surya.practice.geeks.dp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lc53_MaximumSubArray {

    public int maxSubArray_bruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int runningSum = 0;
            for (int j = i; j < length; j++) {
                runningSum += nums[j];
                if (runningSum > maxSum) {
                    maxSum = runningSum;
                    start = i;
                    end = j;
                }
            }
        }
        log.info("Maximum subArray is between {} and {}", start, end);
        return maxSum;
    }
}
