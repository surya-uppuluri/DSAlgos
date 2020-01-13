package surya.practice.geeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RemoveElement {

    //@formatter:off

    /**
     * 27. Remove Element
     * <p>
     * TODO-Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * <p>
     * Example 1:
     * <p>
     * Given nums = [3,2,2,3], val = 3,
     * <p>
     * Your function should return length = 2, with the first two elements of nums being 2.
     * <p>
     * It doesn't matter what you leave beyond the returned length.
     * Example 2:
     * <p>
     * Given nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
     * <p>
     * Note that the order of those five elements can be arbitrary.
     * <p>
     * It doesn't matter what values are set beyond the returned length.
     * <p>
     * ----------
     * ALGORITHM
     * ----------
     * 1. Upon finding an element, swap it!
     * Thought this is a BruteForce Algorithm, it got 100% space and 100% time in LeetCode ;)
     * =========================
     * Space Complexity - O(1)
     * Time Complexity - O(n^2)
     * =========================
     */
    //@formatter:on
    public int removeElement(int[] nums, int val) {


        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != val)
                    //swap
                    {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) res++;
        }
        return res;
    }
}

public class RemoveElementDriver {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int val = Integer.parseInt(line);

            int ret = new RemoveElement().removeElement(nums, val);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}