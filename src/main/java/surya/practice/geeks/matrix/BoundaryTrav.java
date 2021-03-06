package surya.practice.geeks.matrix;

import java.util.Scanner;

class BoundaryTrav {
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
            new BoundaryTraversal().boundaryTraversal(n1, m1, arr1);
            System.out.println();

        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class BoundaryTraversal {
    /*  n1, m1: rows and cols of matrix
        a[][]: input matrix
   */
    static void boundaryTraversal(int row, int col, int[][] a) {

        if (row == 1 || col == 1) {
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    System.out.print(a[i][j] + " ");
            return;
        }

        for (int i = 0; i < col; i++)
            System.out.print(a[0][i] + " ");
        for (int i = 1; i < row; i++)
            System.out.print(a[i][col - 1] + " ");
        for (int i = col - 2; i > 0; i--)
            System.out.print(a[row - 1][i] + " ");
        for (int i = row - 2; i > 0; i--)
            System.out.print(a[i][0] + " ");

    }

}