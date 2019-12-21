package surya.practice.geeks.leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class LC728SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            j = eliminate(i, j);
            if (j == 0) list.add(i);
        }
        return list;
    }

    private int eliminate(int i, int j) {
        for (; j > 0; j /= 10) {
            if ((j % 10 == 0) ) break;
            if (i % (j % 10) != 0) break;
        }
        return j;
    }
}

public class LC728_SelfDivide {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += number + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int left = Integer.parseInt(line);
            line = in.readLine();
            int right = Integer.parseInt(line);

            List<Integer> ret = new LC728SelfDividingNumbers().selfDividingNumbers(left, right);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}