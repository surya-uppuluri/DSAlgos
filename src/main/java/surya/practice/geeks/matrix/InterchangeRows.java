package surya.practice.geeks.matrix;

import java.util.Scanner;

class InterchangeRows {
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
            new RowInterchange().interchangeRows(n1, m1, arr1);
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++)
                    System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
class RowInterchange {
    //Complete this function
    static void interchangeRows(int n1, int m1, int[][] a) {
        int fp = 0, sp = n1 - 1;
        while (fp < sp) {
            for (int col = 0; col < m1; col++) {
                int x = a[fp][col];
                int y = a[sp][col];
                x = x ^ y;
                y = x ^ y;
                x = x ^ y;
                a[fp][col] = x;
                a[sp][col] = y;
            }
            fp++;
            sp--;
        }
    }

}
