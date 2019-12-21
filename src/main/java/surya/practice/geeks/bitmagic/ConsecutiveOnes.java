package surya.practice.geeks.bitmagic;//Initial Template for Java

import java.io.*;
import java.util.*;

//Position this line where user code will be pasted.
class ConsecutiveOnes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            ConsecutiveOne obj = new ConsecutiveOne();

            System.out.println(obj.maxConsecutiveOnes(n));
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class ConsecutiveOne {

    /*  Function to calculate the largest consecutive ones
     *   x: given input to calculate the largest consecutive ones
     */
    public static int maxConsecutiveOnes(int x) {

        int currmax = 0, glomax = 0;
        while (x > 0) {
            if ((x & 1) == 1) {
                currmax++;
                x = x >> 1;
                if (currmax > glomax)
                    glomax = currmax;
            } else {
                currmax = 0;
                x = x >> 1;
            }


        }
        return glomax;
    }
}
