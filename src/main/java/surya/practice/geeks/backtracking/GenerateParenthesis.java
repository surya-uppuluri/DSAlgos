package surya.practice.geeks.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GenerateParenthesis {

  public List<String> generateParenthesisBackTracking(int n) {
    List<String> combos = new ArrayList<>();
    generateParenthesisBackTracking(n, combos, "", 0, 0);
    return combos;
  }

  private void generateParenthesisBackTracking(int n, List<String> combos, String curr, int open,
      int closed) {
    if (curr.length() == 2 * n) {
      combos.add(curr);
      return;
    }
    if (open < n) {
      generateParenthesisBackTracking(n, combos, curr + "(", open + 1, closed);
    }
    if (closed < open) {
      generateParenthesisBackTracking(n, combos, curr + ")", open, closed + 1);
    }


  }

  public List<String> generateParenthesisBruteForce(int i) {
    List<String> combos = new ArrayList<>();

    generateParenthesisBruteForce(0, new char[2 * i], combos);
    return combos;
  }

  private void generateParenthesisBruteForce(int i, char[] ch, List<String> combos) {
    if (ch.length == i) {
      if (isValid(ch)) {
        combos.add(new String(ch));
      }
    } else {
      ch[i] = '(';
      generateParenthesisBruteForce(i + 1, ch, combos);
      ch[i] = ')';
      generateParenthesisBruteForce(i + 1, ch, combos);
    }

  }


  private boolean isValid(char[] s) {
    int balance = 0;
    for (char c : s) {
      if (c == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    return (balance == 0);
  }
}


