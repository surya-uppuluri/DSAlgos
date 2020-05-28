package surya.practice.geeks.stack;

import java.util.Stack;
import lombok.extern.slf4j.Slf4j;
//@formatter:off

/**
 * 1047. Remove All Adjacent Duplicates In String
 * Easy
 *
 * 636
 *
 * 57
 *
 * Add to List
 *
 * Share
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 *
 * Note:
 *
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */

/**
 * Runtime: 22 ms, faster than 54.24% of Java online submissions for Remove All Adjacent Duplicates In String.
 * Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
 * Next challenges:
 * Remove All Adjacent Duplicates in String II
 */
//@formatter:on
@Slf4j
class LC1047_RemoveAllAdjacentDuplicatesInString {

  public String removeDuplicatesUsingStack(String S) {
    Stack<Character> stack = new Stack<>();
    /**
     * traversing in reverse order so that I don't have to reverse the output
     * string while returning
     */
    for (int i = S.length() - 1; i >= 0; i--) {
      char ch = S.charAt(i);
      if (stack.isEmpty()) {
        stack.push(ch);
      } else if (stack.peek() == ch) {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }

  public String removeDuplicatesWithStringManipulation(String S) {
    //load result as initial string itself and start trimming it
    StringBuilder result = new StringBuilder(S);
    int i = 0;

    while (i < result.length() - 1) {

      char curr = result.charAt(i);
      char next = result.charAt(i + 1);
      if (curr == next) {
        result.replace(i, i + 2, "");
        log.info("Replaced content between: {}, {}. Current result is: {}", i, i + 2, result);
        //because of trimming and i--, i could become negative, check that before reducing i
        //i should be reduced because comparision has to start from prev position
        if (i > 0) {
          log.info("Reducing i to {}", i - 1);
          i--;
        }
      } else {
        log.info("Incrementing i");
        i++;
      }


    }

    return result.toString();
  }

}
