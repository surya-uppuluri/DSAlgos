package surya.practice.geeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PlusOne {
    public int[] plusOne(int[] digits) {
        //Iterate from the end of array
        //If digit is 9, mark it 0 and keep going till you find non 9 digit
        //Increment it and return.
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        //If it's not returned yet, it means all digits are 9's. Then, create a new array with greater length

        int[] newarr = new int[digits.length + 1];
        newarr[0] = 1;
        for (int i = 1; i < digits.length; i++) {
            newarr[i] = 0;
        }
        return newarr;

    }
}

public class PlusOneDriver {
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
            int[] digits = stringToIntegerArray(line);

            int[] ret = new PlusOne().plusOne(digits);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}