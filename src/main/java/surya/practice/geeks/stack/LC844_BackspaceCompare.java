package surya.practice.geeks.stack;

import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC844_BackspaceCompare {

  /**
   * 844. Backspace String Compare Easy
   * <p>
   * 1535
   * <p>
   * 81
   * <p>
   * Add to List
   * <p>
   * Share Given two strings S and T, return if they are equal when both are typed into empty text
   * editors. # means a backspace character.
   * <p>
   * Note that after backspacing an empty text, the text will continue empty.
   * <p>
   * Example 1:
   * <p>
   * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become "ac". Example 2:
   * <p>
   * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become "". Example 3:
   * <p>
   * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become "c". Example 4:
   * <p>
   * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T becomes "b". Note:
   * <p>
   * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase letters and '#'
   * characters. Follow up:
   * <p>
   * Can you solve it in O(N) time and O(1) space?
   **/
  public boolean backspaceCompareWithStack(String S, String T) {
    Stack<Character> s = new Stack<>();
    Stack<Character> t = new Stack<>();
    for (char ch : S.toCharArray()) {
      if (ch == '#') {
        if (!s.isEmpty()) {
          s.pop();
        }
      } else {
        s.push(ch);
      }
    }

    for (char ch : T.toCharArray()) {
      if (ch == '#') {
        if (!t.isEmpty()) {
          t.pop();
        }
      } else {
        t.push(ch);
      }
    }
    while (!s.isEmpty() && !t.isEmpty()) {
      if (s.pop() != t.pop()) {
        return false;
      }
    }
    return s.isEmpty() && t.isEmpty();
  }

  //TODO-Review this to comprehend 2 pointer approach better. Not-intuitive
  public boolean backspaceCompareWithWith2Pointer(String S, String T) {
    int idxS = S.length() - 1, idxT = T.length() - 1;
    int skipS = 0, skipT = 0;
    log.info("-------------------------------------------");

    while (idxS >= 0 || idxT >= 0) { // While there may be chars in build(S) or build (T)
      log.info("Looping over strings: {} and {}", S, T);
      while (idxS >= 0) { // Find position of next possible char in build(S)
        log.info("Current character in first string: {} ", S.charAt(idxS));

        if (S.charAt(idxS) == '#') {
          log.info("found a #, incrementing skipS as {} ", skipS + 1);
          skipS++;
          idxS--;
        } else if (skipS > 0) {
          log.info("Decrementing skipS as {}", skipS - 1);
          skipS--;
          idxS--;
        } else {
          break;
        }
      }
      while (idxT >= 0) { // Find position of next possible char in build(T)
        log.info("Current character in second string : {} ", T.charAt(idxT));

        if (T.charAt(idxT) == '#') {
          log.info("found a #, incrementing skipT as {} ", skipT + 1);

          skipT++;
          idxT--;
        } else if (skipT > 0) {
          log.info("Decrementing skipT as {}", skipT - 1);

          skipT--;
          idxT--;
        } else {
          break;
        }
      }
      // If two actual characters are different

      if (idxS >= 0 && idxT >= 0 && S.charAt(idxS) != T.charAt(idxT)) {
        return false;
      }
      // If expecting to compare char vs nothing
      if ((idxS >= 0) != (idxT >= 0)) {
        return false;
      }
      idxS--;
      idxT--;
    }
    return true;
  }
}
