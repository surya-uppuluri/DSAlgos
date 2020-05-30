package surya.practice.geeks.strings;

import com.eclipsesource.json.JsonArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC5_LongestPalindromeSubstring {

  //Times out on leetCode
  public String longestPalindromeBruteForce(String s) {
    String currPal = "";
    if (s.length() == 1) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String currStr = s.substring(i, j + 1);
        //System.out.println("Running for: "+ currStr);

        if (isPalindrome(currStr)) {
          //System.out.println("is a pal: "+ currStr);
          //System.out.println( (i-j) + " " +currPal.length());

          if ((j - i) >= currPal.length()) {
            // System.out.println("Currpal: "+ currPal);
            //System.out.println("currStr: "+ currStr);
            currPal = currStr;
          }
        }

      }
    }
    return currPal;
  }

  private boolean isPalindrome(String s) {
    int lp = 0;
    int rp = s.length() - 1;
    while (lp < rp) {
      //System.out.println(s.charAt(lp) + ":" + s.charAt(rp) );
      if (s.charAt(lp) != s.charAt(rp)) {
        return false;
      } else {
        lp++;
        rp--;
      }
    }

    return true;
  }
//TODO--Understand the update of s&e indices better
  public String longestPalindromeExtendFromMiddle(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      log.info("Expanding from middle with left index: {} and right index: {}", i, i);
      int len1 = expandFromMiddle(s, i, i);
      log.info("Also, expanding from middle with left index: {} and right index: {}", i, i + 1);

      int len2 = expandFromMiddle(s, i, i + 1);
      log.info("First expansion length: {}, second's: {}", len1, len2);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
        log.info("length is > curr start and end pos length. Updating as start: {} end: {}", start,
            end);


      }
    }

    return s.substring(start, end + 1);

  }

  private int expandFromMiddle(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

//TODO
  /*public String longestPalindromeDP(String input) {
    int n = input.length();
    boolean dp[][] = new boolean[n][2];
    int currCol = 0;
    int maxLen = 0;
    int ans = 0;
    for (int len = 0; len < n; len++) {

      for (int start = len; start < n; start++) {

      }
    }

  }

*/
}

class LC5_LongestPalindromeSubstringDriver {

  public static String stringToString(String input) {
    return JsonArray.readFrom("[" + input + "]").get(0).asString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      String s = stringToString(line);

      String ret = new LC5_LongestPalindromeSubstring().longestPalindromeBruteForce(s);

      String out = (ret);

      System.out.print(out);
    }
  }
}