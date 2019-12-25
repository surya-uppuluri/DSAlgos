package surya.practice.leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

class LC1207_Unique_Number_of_Occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        for (int i : arr) {
            int count = occ.getOrDefault(i, 0);
            occ.put(i, count + 1);
        }
        HashSet<Integer> cset = new HashSet<>();
        for (Integer counter : occ.values()) {
            return !cset.contains(counter) && cset.add(counter);
        }
        return true;
    }
}

public class Unique {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] arr = stringToIntegerArray(line);

            boolean ret = new LC1207_Unique_Number_of_Occurrences().uniqueOccurrences(arr);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}