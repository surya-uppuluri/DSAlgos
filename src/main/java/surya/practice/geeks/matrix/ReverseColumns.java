package surya.practice.geeks.matrix;

import java.util.Scanner;

class ReverseColumns {
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
            new Reversal().reverseCol(n1, m1, arr1);
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++)
                    System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
class Reversal {
    //Complete this function
    static void reverseCol(int row, int col, int[][] arr) {
        int low = 0, high = col - 1;
        while (low < high) {
            for (int i = 0; i < row; i++) {
                int temp = arr[i][high];
                arr[i][high] = arr[i][low];
                arr[i][low] = temp;
            }
            low++;
            high--;
        }

       /* for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }*/
    }
}
