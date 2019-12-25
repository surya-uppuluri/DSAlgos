package surya.practice.geeks.matrix;//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RotateACWWithoutExtraSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            int[][] a = new int[n][n];
            String[] st = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    a[i][j] = Integer.parseInt(st[k++]);
            }
            new Rotation().rotateby90(a, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/**
 * Rotate by 90 degree
 * <p>
 * Given a square matrix mat[][] of size N x N. The task is to rotate it by 90 degrees in anti-clockwise direction without using any extra space.
 * <p>
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of the square matrix. The second line of each test case contains N x N space separated values of the matrix mat.
 * <p>
 * Output:
 * Corresponding to each test case, in a new line, print the rotated matrix.
 * <p>
 * User Task:
 * The task is to complete the function rotateby90() which rotates the input matrix by 90 degree. You just need to rotate the matrix, printing the matrix will be automatically done the driver code.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 50
 * 1 ≤ N ≤ 50
 * 1 <= mat[][] <= 100
 * <p>
 * Example:
 * Input:
 * 3
 * 3
 * 1 2 3 4 5 6 7 8 9
 * 2
 * 1 2 3 4
 * 1
 * 80
 * Output:
 * 3 6 9 2 5 8 1 4 7
 * 2 4 1 3
 * 80
 * <p>
 * Explanation:
 * Testcase 1: Matrix is as below:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * <p>
 * Rotating it by 90 degrees in anticlockwise directions will result as below matrix:
 * 3 6 9
 * 2 5 8
 * 1 4 7
 **/
class Rotation {  // a[][]: input matrix
    // n: size of matrix
    static void rotateby90(int[][] a, int n) {
// first transpose the matrix. Then swap the rows - First with last and so on
        transpose(a, n);
        swapRows(a, n);
    }

    static void transpose(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = a[i][j];
                int y = a[j][i];

                x = x ^ y;
                y = x ^ y;
                x = x ^ y;

                a[i][j] = x;
                a[j][i] = y;
            }
        }
    }

    static void swapRows(int[][] a, int n) {
        int fp = 0, sp = n - 1;
        while (fp < sp) {
            for (int col = 0; col < n; col++) {
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