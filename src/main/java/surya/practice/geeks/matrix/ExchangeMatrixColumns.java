package surya.practice.geeks.matrix;

import java.util.Scanner;

class ExchangeMatrixColumns {
    /*https://practice.geeksforgeeks.org/problems/exchange-matrix-columns/1/?track=SPC-Matrix&batchId=1408*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n1 = sc.nextInt();
            int m1 = sc.nextInt();

            int[][] arr1 = new int[n1][m1];

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++)
                    arr1[i][j] = sc.nextInt();
            }
            new ModifyMat().exchangeColumns(n1, m1, arr1);
            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class ModifyMat {
    //Complete this function
    static void exchangeColumns(int n1, int m1, int[][] arr) {
        for (int i = 0; i < n1; i++) {
            int temp = arr[i][m1 - 1];
            arr[i][m1 - 1] = arr[i][0];
            arr[i][0] = temp;
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
