package surya.practice.geeks.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class LC1441_BuildAnArrayWithStackOperations {
  //@formatter:off

  /**
   * 1441. Build an Array With Stack Operations
   * Easy
   *
   * 82
   *
   * 68
   *
   * Add to List
   *
   * Share
   * Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.
   *
   * Build the target array using the following operations:
   *
   * Push: Read a new element from the beginning list, and push it in the array.
   * Pop: delete the last element of the array.
   * If the target array is already built, stop reading more elements.
   * You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.
   *
   * Return the operations to build the target array.
   *
   * You are guaranteed that the answer is unique.
   *
   *
   *
   * Example 1:
   *
   * Input: target = [1,3], n = 3
   * Output: ["Push","Push","Pop","Push"]
   * Explanation:
   * Read number 1 and automatically push in the array -> [1]
   * Read number 2 and automatically push in the array then Pop it -> [1]
   * Read number 3 and automatically push in the array -> [1,3]
   * Example 2:
   *
   * Input: target = [1,2,3], n = 3
   * Output: ["Push","Push","Push"]
   * Example 3:
   *
   * Input: target = [1,2], n = 4
   * Output: ["Push","Push"]
   * Explanation: You only need to read the first 2 numbers and stop.
   * Example 4:
   *
   * Input: target = [2,3,4], n = 4
   * Output: ["Push","Pop","Push","Push","Push"]
   *
   *
   * Constraints:
   *
   * 1 <= target.length <= 100
   * 1 <= target[i] <= 100
   * 1 <= n <= 100
   * target is strictly increasing.
   * @param target
   * @param n
   * @return
   */
  //@formatter:on

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Build an Array With Stack
   * Operations. Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Build an
   * Array With Stack Operations.
   *
   * @param target
   * @param n
   * @return
   */
  public List<String> buildArrayWithoutStack(int[] target, int n) {

    final String PUSH = "Push";
    final String POP = "Pop";
    List<String> res = new ArrayList<>();
    int j = 0;
    for (int i = 1; i <= n; i++) {
      if (j >= target.length) {
        break;
      }
      if (i == target[j]) {
        j++;
        res.add(PUSH);
      } else {
        res.add(PUSH);
        res.add(POP);
      }
    }
    return res;
  }

  /**
   * Runtime: 1 ms, faster than 36.72% of Java online submissions for Build an Array With Stack
   * Operations. Memory Usage: 39.8 MB, less than 100.00% of Java online submissions for Build an
   * Array With Stack Operations. Next challenges: Largest Rectangle in Histogram Binary Tree Zigzag
   * Level Order Traversal Remove K Digits
   *
   * @param target
   * @param n
   * @return
   */
  public List<String> buildArrayWithStack(int[] target, int n) {
    final String PUSH = "Push";
    final String POP = "Pop";
    List<String> res = new ArrayList<>();
    Stack<Integer> stack = new Stack();
    /* Since stack is LIFO, I will push the elements in reverse order so that 1 comes on top */
    for (int i = n; i >= 1; i--) {
      stack.push(i);
    }
    int j = 0;
    while (!stack.isEmpty()) {
      if (j == target.length) {
        break;
      }
      if (stack.pop() == target[j]) {
        j++;
        res.add(PUSH);
      } else {
        res.add(PUSH);
        res.add(POP);
      }
    }
    return res;
  }

}
