package surya.practice.geeks.stack;

class RemoveOuterMostParenthesis {

  // @formatter:off
    /** LC1021
     * 1021. Remove Outermost Parentheses
     * Easy
     *
     * 412
     *
     * 549
     *
     * Add to List
     *
     * Share
     * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
     *
     * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
     *
     * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
     *
     * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
     *
     *
     *
     * Example 1:
     *
     * Input: "(()())(())"
     * Output: "()()()"
     * Explanation:
     * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
     * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
     * Example 2:
     *
     * Input: "(()())(())(()(()))"
     * Output: "()()()()(())"
     * Explanation:
     * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
     * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
     * Example 3:
     *
     * Input: "()()"
     * Output: ""
     * Explanation:
     * The input string is "()()", with primitive decomposition "()" + "()".
     * After removing outer parentheses of each part, this is "" + "" = "".
     *
     *
     * Note:
     *
     * S.length <= 10000
     * S[i] is "(" or ")"
     * S is a valid parentheses string
     * @param input
     * @return
     */
    // @formatter:on
    public String removeOuterParentheses(String input) {
      StringBuffer sb = new StringBuffer("");
      int leftCount = 0;
      int outerCount = 0;
      int prev = -1;
      int i = 0;
      for (Character ch : input.toCharArray()) {
        i++;
        if (ch == '(') {
          leftCount++;
        } else if (ch == ')') {
          outerCount++;
        }
        /*
         * When leftCount == outerCount it means that a valid pair of outermost
         * parenthesis that can be removed is found. Reset the values of counters and append
         * the result
         */
        if (leftCount == outerCount) {
          leftCount = 0;
          outerCount = 0;

          String toAppend = input.substring(prev + 1, i);
          System.out.println("toAppend: " + toAppend);
          String removedPar = toAppend.substring(1, toAppend.length() - 1);
          System.out.println("removedPar: " + removedPar);

          sb.append(removedPar);
          prev = i - 1;
        }

      }
      return sb.toString();

    }
}