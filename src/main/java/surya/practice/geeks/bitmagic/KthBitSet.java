package surya.practice.geeks.bitmagic;

public class KthBitSet {

    /**
     * 4 = 010
     * 2nd bit from right set? = Yes
     * 1st bit from right set? = No
     * <p>
     * =========
     * ALGORITHM
     * =========
     * <p>
     * 1. Right shift the number by k-1 digits
     * 2. Bitwise and with 1
     * 3. If result is 1, true
     * ----
     * How?
     * ----
     * Check 2nd bit set?
     * ==============
     *  RIGHT SHIT 010 BY (2-1) => 1 DIGIT
     * res: 001
     * AND 001 with 001 => 1 => true
     * <p>
     * Check 1st bit set?
     * ==============
     *  RIGHT SHIT 010 BY (1-1) => 0 DIGIT
     * res: 010
     * AND 010 with 001 => 0 (not equal to 1) => false
     */


    public static void main(String[] args) {
        System.out.println("Is kth bit set? ; " + isKthBitSet(9, 3));
        System.out.println("Is kth bit set? ; " + isKthBitSet(9, 4));

    }

    private static boolean isKthBitSet(int number, int bit) {
        return (number >> (bit - 1) & 1) == 1;

    }
}
