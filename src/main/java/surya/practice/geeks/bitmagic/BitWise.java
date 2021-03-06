package surya.practice.geeks.bitmagic;//Initial Template for Java

import java.io.*;
import java.util.*;

//Position this line where user code will be pasted.
class MaximumANDBruteForce {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String inputLine[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            AND obj = new AND();

            System.out.println(obj.maxAND(arr, n));
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class AND {

    // Function for finding maximum and value pair
    public static int maxAND(int arr[], int n) {
        int glomax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                glomax = Math.max(glomax, arr[i] & arr[j]);
            }

        }
        return glomax;


    }

}