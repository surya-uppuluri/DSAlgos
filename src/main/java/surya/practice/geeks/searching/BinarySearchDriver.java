package surya.practice.geeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinarySearch {
    public int search(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (arr[mid] < target)
                low = mid + 1;
            else if (arr[mid] > target)
                high = mid - 1;
            else if (arr[mid] == target)
                return mid;
        }
        return -1;
    }
}

public class BinarySearchDriver {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new BinarySearch().search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}