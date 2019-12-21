package surya.practice.geeks.bitmagic;


//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

//Position this line where user code will be pasted.
// Driver code
class TotalSetBits {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x, n;
        while (t-- > 0) {
            n = sc.nextInt();
            CountBits_BrianKernighan obj = new CountBits_BrianKernighan();
            System.out.println(CountBits_BrianKernighan.countSetBits(n));
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class CountBits_BrianKernighan {

    // Function to count number of set bits
    public static int countSetBits(int n) {


        int setbits = 0;

        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j > 0) {
                j = j & (j - 1);
                setbits++;
            }

        }
        return setbits;

    }
}