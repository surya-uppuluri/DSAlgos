package surya.practice.geeks.strings;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllPermutations {

    public void generatePermutations(String s) {
        permutaions(s, "");
    }

    private void permutaions(String str, String prefix) {
        if (str.length() == 0) System.out.println("RESULT:" + prefix);
        else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                String nextPrefix = prefix + str.charAt(i);
                log.info("Generating permutation for rem: {} and {}. Prefix was: {}", rem, nextPrefix, prefix);
                permutaions(rem, nextPrefix);
            }
        }
    }

}
