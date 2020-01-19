package surya.practice.geeks.bitmagic;
//Initial Template for Java

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

//Position this line where user code will be pasted.
class BinaryToGray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Gray obj = new Gray();

            System.out.println(obj.greyConverter(n));
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
//Back-end complete function Template for Java
class Gray {

    //  Function to find the gray code of given number N
    public static int greyConverter(int n) {

        return n ^ (n >> 1);

    }

}