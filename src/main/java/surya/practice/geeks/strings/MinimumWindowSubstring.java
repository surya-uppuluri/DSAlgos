package surya.practice.geeks.strings;

import java.util.HashMap;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
    System.out.println(minimumWindowSubstring.minWindow("SuryaUppuluri", "yuri"));
  }

  public String minWindow(String s, String t) {

    HashMap<Character, Integer> needs = new HashMap<Character, Integer>();
    HashMap<Character, Integer> window = new HashMap<Character, Integer>();

    for (Character ch : t.toCharArray()) {
      needs.put(ch, needs.getOrDefault(ch, 0) + 1);
    }
    int right = 0, left = 0;
    int start = 0, minLen = Integer.MAX_VALUE;

    int match = 0;
    while (right < s.length()) {
      char c1 = s.charAt(right);
      if (needs.containsKey(c1)) {
        window.put(c1, window.getOrDefault(c1, 0) + 1);
        if (window.get(c1).equals(needs.get(c1))) {
          match++;
        }
      }
      right++;

      while (match == needs.size()) {
        if (right - left < minLen) {
          start = left;
          minLen = right - left;
        }

        char c2 = s.charAt(left);
        //if you are moving left pointer by 1, you have to decrement it's count in the window
        if (needs.containsKey(c2)) {
          window.put(c2, window.get(c2) - 1);

          //after decrementing if the match doesn't happen, reduce the match count

          if (window.get(c2) < needs.get(c2)) {
            match--;
          }
        }
        left++;

      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
  }
}


