package surya.practice.geeks.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreatestElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            int index = -1;
            while (index++ < nums2.length) {
                if (nums2[index] == nums1[i]) {
                    break;
                }
            }
            if (index == nums2.length) continue;
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }


    /*HashMap
    Time: O(m^2)
    Space: O(m)*/
    public int[] nextGreaterElementHashMap(int[] numbers1, int[] numbers2) {
        int[] res = new int[numbers1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers2.length; i++) {
            int cur = numbers2[i];
            map.put(cur, -1);
            for (int j = i; j < numbers2.length; j++) {
                int next = numbers2[j];
                if (next > cur) {
                    map.put(cur, next);
                    break;
                }
            }
        }

        for (int i = 0; i < numbers1.length; i++) {
            res[i] = map.get(numbers1[i]);
        }
        return res;
    }


/*Stack + HashMap
Time: O(m)
Space: O(m)*/

    public int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int cur : nums2) {
            while (!stack.isEmpty() && cur > stack.peek()) {
                map.putIfAbsent(stack.pop(), cur);
            }
            stack.push(cur);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}