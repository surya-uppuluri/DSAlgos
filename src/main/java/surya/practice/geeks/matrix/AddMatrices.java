package surya.practice.geeks.matrix;

import java.util.*;
import java.io.*;
import java.lang.*;

class AddMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n1 = sc.nextInt();
            int m1 = sc.nextInt();

            int arr1[][] = new int[n1][m1];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++)
                    arr1[i][j] = sc.nextInt();
            }
            int n2 = sc.nextInt();
            int m2 = sc.nextInt();
            int arr2[][] = new int[n2][m2];
            for (int i = 0; i < n2; i++) {
                for (int j = 0; j < m2; j++)
                    arr2[i][j] = sc.nextInt();
            }

            new Add_matrices().sumMatrix(n1, m1, n2, m2, arr1, arr2);
            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Add_matrices {
    /*  Function to find sum of matrices
     *   n1, m1, n2, m2: rows and columns of matrices respectively
     *   arr1[][], arr2[][]: two input matrices
     */
    static void sumMatrix
    (int ro1, int co1, int ro2, int co2, int arr1[][], int arr2[][]) {

        if (ro1 != ro2 || co1 != co2) {
            System.out.println("-1");
            return;
        } else {
            StringBuffer resp = new StringBuffer("");
            for (int i = 0; i < ro1; i++) {
                for (int j = 0; j < co1; j++) {
                    resp.append(String.valueOf(arr1[i][j] + arr2[i][j]));
                    resp.append(" ");
                }
            }
            System.out.println(resp);

        }
    }
}