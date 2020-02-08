package surya.practice.geeks.strings;

public class DecryptStringFromAlphabets {

    //@formatter:off
    /**
     *
     * ----------PROBLEM STATEMENT-----------
     *LC1309. Decrypt String from Alphabet to Integer Mapping
     * Easy
     *
     * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
     *
     *     Characters ('a' to 'i') are represented by ('1' to '9') respectively.
     *     Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
     *
     * Return the string formed after mapping.
     *
     * It's guaranteed that a unique mapping will always exist.
     *
     *
     * ----------
     * ALGORITHM
     * ----------
     * 1.
     * =========================
     * Time Complexity - O()
     * Space Complexity - O()
     * =========================
     * Runtime: 2 ms, faster than 40.94% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
     * Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
     */

    public String freqAlphabetsNaive(String s) {
        String[] str = new String[1000];
        int k = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 2 < s.length() && s.charAt(i + 2) == ('#')) {
                str[k++] = (String.valueOf(s.charAt(i))).concat(String.valueOf(s.charAt(i + 1)));
                i = i + 3;
            } else {
                str[k++] = String.valueOf(s.charAt(i));
                i++;
            }
        }
        char[] ch = new char['z' - 'a' + 2];
        int a = (int) 'a';
        for (int i = 1; i < ch.length; i++) {
            ch[i] = (char) a++;
        }
        StringBuilder res = new StringBuilder();
        for (String each : str) {
            if (null != each) {
                int index = Integer.parseInt(each);
                res = res.append(String.valueOf(ch[index]));
            }
        }
        return res.toString();

    }


    public String freqAlphabetsOptimized(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (i + 2 < size && s.charAt(i + 2) == '#') {
              /*  System.out.println("Substr of " + i + " " + (i + 1) + " is " + s.substring(i, i + 1));
                System.out.println("Substr of " + i + " " + (i + 2) + " is " + s.substring(i, i + 2));
*/
                sb.append((char) ((Integer.parseInt(s.substring(i, i + 2)) - 1) + 'a'));
                i = i + 2;
            } else sb.append((char) ((Integer.parseInt(String.valueOf(s.charAt(i))) - 1) + 'a'));
        }
        return sb.toString();
    }
}
