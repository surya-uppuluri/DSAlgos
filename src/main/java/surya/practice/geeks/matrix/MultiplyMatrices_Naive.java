package surya.practice.geeks.matrix;

import java.util.Scanner;

class MultiplyMatrices_Naive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int row1 = sc.nextInt();
            int col1 = sc.nextInt();

            int[][] arr1 = new int[row1][col1];
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++)
                    arr1[i][j] = sc.nextInt();
            }
            int n2 = sc.nextInt();
            int col2 = sc.nextInt();

            int[][] arr2 = new int[n2][col2];
            for (int i = 0; i < n2; i++) {
                for (int j = 0; j < col2; j++)
                    arr2[i][j] = sc.nextInt();
            }

            new Multiplication().multiplyMatrix(row1, col1, n2, col2, arr1, arr2);
            System.out.println();

        }
    }
}


class Multiplication {
    //Complete this function
    static void multiplyMatrix
    (int row1, int col1, int row2, int col2, int[][] arr1, int[][] arr2) {
        if (col1 != row2) {
            System.out.print("-1");
            return;
        }
        /**
         *
         * Iterate over the rows of first with columns of second. by multipying and adding the corresponding value
         *  from each column1 of that particular row1
         */
        int[][] product = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {

                    //  row1 (i) * col1 (k) with  row2 (k) and col2(j)

                    product[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }


        for (int i = 0; i < row1; i++)
            for (int j = 0; j < col2; j++)
                System.out.print(product[i][j] + " ");
    }
}
