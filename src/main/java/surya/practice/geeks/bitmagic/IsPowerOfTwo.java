package surya.practice.geeks.bitmagic;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println("------Bit Magic ------");
        System.out.println("Is 99 power of 2? " + checkPowerOfTwoBitMagic(99));
        System.out.println("Is 64 power of 2? " + checkPowerOfTwoBitMagic(64));
        System.out.println("------Recursive ------");
        System.out.println("Is 99 power of 2? " + checkPowerOfTwoRecursively(99));
        System.out.println("Is 64 power of 2? " + checkPowerOfTwoRecursively(64));
        System.out.println("------Iterative ------");
        System.out.println("Is 99 power of 2? " + checkPowerOfTwoIteratively(99));
        System.out.println("Is 64 power of 2? " + checkPowerOfTwoIteratively(64));


    }

    private static Boolean checkPowerOfTwoRecursively(int i) {
        if (i == 2) return true;
        else if (i % 2 != 0) return false;
        else return checkPowerOfTwoRecursively(i / 2);
    }

    private static Boolean checkPowerOfTwoIteratively(int i) {

        while(i>=2)
        {
            if(i%2==0) i=i/2;
            else return  false;
        }
        return true;
    }

    private static boolean checkPowerOfTwoBitMagic(int i) {
        /**
         * A number is power of 2 if only 1 bit is set
         * 1. negative example:
         *
         * 9 = 1001
         * 8 = 1000
         * ---------
         * & => 1000  @@@@ !=0 => Not a power
         * ---------
         *
         * 2. Positive example
         *
         * 8 = 1000
         * 7 = 0111
         * --------
         * & => 0000 @@@@@ ==0 => Is a power
         */
        return (i & i - 1) == 0;

    }
}
