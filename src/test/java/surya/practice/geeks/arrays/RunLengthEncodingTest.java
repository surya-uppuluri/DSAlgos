package surya.practice.geeks.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunLengthEncodingTest {

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

    @Test
    void decompressRLElist() {
        String line = "[1,2,3,4]";
        int[] nums = stringToIntegerArray(line);

        int[] ret = new RunLengthEncoding().decompressRLElistNaive(nums);

        String out = integerArrayToString(ret);

        System.out.print(out);
        assertEquals("[2, 4, 4, 4]", out);

    }


    @Test
    void decompressRLElistEfficiently() {
        String line = "[1,2,3,4]";
        int[] nums = stringToIntegerArray(line);

        int[] ret = new RunLengthEncoding().decompressRLEListEfficiently(nums);

        String out = integerArrayToString(ret);

        assertEquals("[2, 4, 4, 4]", out);
    }


    public String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }


}
