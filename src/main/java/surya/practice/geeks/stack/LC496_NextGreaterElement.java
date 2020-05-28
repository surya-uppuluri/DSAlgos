package surya.practice.geeks.stack;

import java.util.HashMap;
import java.util.Stack;
//@formatter:off
/**
 * 496. Next Greater Element I
 * Easy
 *
 * 1440
 *
 * 1989
 *
 * Add to List
 *
 * Share
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */
//@formatter:on

public class LC496_NextGreaterElement {

  /**
   * Runtime: 2 ms, faster than 98.68% of Java online submissions for Next Greater Element I. Memory
   * Usage: 39.4 MB, less than 7.41% of Java online submissions for Next Greater Element I.
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] nextGreaterElementWithHashMap(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length];
    HashMap<Integer, Integer> nmap = new HashMap<>();
    int resI = 0;
    for (int i = 0; i < nums2.length; i++) {
      nmap.put(nums2[i], i);
    }

    for (int value : nums1) {
      int index = nmap.get(value);
      boolean present = false;
      for (int j = index + 1; j < nums2.length; j++) {
        if (nums2[j] > value) {
          res[resI++] = nums2[j];
          present = true;
          break;
        }
      }
      if (!present) {
        res[resI++] = -1;
      }
    }

    return res;
  }

  /**
   * From https://nifannn.github.io/2018/10/24/Algorithm-Notes-Leetcode-496-Next-Greater-Element-I/
   * <p>
   * Traverse nums2, find the greater numbers of all numbers in nums2 and store in a hash table.
   * Then iterate elements in nums1 and output the corresponding next greater numbers. To get the
   * hash table, which has numbers in nums2 and corresponding greater numbers, I need a stack to put
   * all numbers that I haven’t found corresponding greater numbers. Then traverse nums2, if a
   * number is larger than any values in stack, it should be the next greater number of those
   * values, remove those values from stack and store in hash table, and put the number in the
   * stack. For example, nums1 = [4,1,2], nums2 = [1,3,4,2]. Iterate numbers in nums2, the first
   * value is 1, put it in the stack (stack = [1]). The second value is 3, which is larger than 1,
   * remove 1 from stack, put (1, 3) in hash table and add 3 in stack (stack = [3], hash_map = { 1:3
   * }). Do the same thing for the third value 4 (stack = [4], hash_map = { 1:3, 3:4 }). The last
   * value is 2, which is not larger than 4, put it in stack (stack = [4, 2], hash_map = { 1:3, 3:4
   * }). Finally, iterate number in nums1, if a number is in hash table, return corresponding
   * greater number, otherwise return -1 (output = [-1, 3, -1]).
   *
   * @param nums1
   * @param nums2
   * @return Runtime: 3 ms, faster than 83.88% of Java online submissions for Next Greater Element
   * I. Memory Usage: 39.1 MB, less than 7.41% of Java online submissions for Next Greater Element
   * I.
   */
  public int[] nextGreaterElementWithStack(int[] nums1, int[] nums2) {

    /**
     * In simple terms, traverse nums2 and store all elements and their greater elements (if greater exists)
     * into a hashmap.
     * Traverse nums1 and lookup the hashmap. if element exists, return in response. else return -1
     */
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums2) {
      //if curr element is > the top of stack, pop the stack and put the vals in hashmap
      while (!stack.isEmpty() && num > stack.peek()) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }

    int length = nums1.length;
    int[] res = new int[length];
    for (int i = 0; i < length; i++) {
      res[i] = map.getOrDefault(nums1[i], -1);
    }

    return res
        ;

  }
}