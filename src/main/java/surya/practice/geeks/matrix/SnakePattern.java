package surya.practice.geeks.matrix;//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SnakePattern {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(reader.readLine());
            int[][] a = new int[n][n];
            String[] st = reader.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    a[i][j] = Integer.parseInt(st[k++]);
            }
            new SnakePatternNaive().print(a, n);
            new SnakePatternModLogic().print(a, n);

            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java

//This took 1.49 sec
class SnakePatternNaive {
    //Complete this function
    //a is matrix
    static void print(int[][] a, int n) {
        int row = 0, col = 0;
        while (row < n) {
            printForward(row, n, a);
            row++;
            if (row < n) {
                printBackward(row, n, a);
                row++;
            }
        }

    }

    static void printBackward(int row, int col, int[][] a) {
        for (int i = col - 1; i >= 0; i--)
            System.out.print(a[row][i] + " ");

    }

    static void printForward(int row, int col, int[][] a) {
        for (int i = 0; i < col; i++)
            System.out.print(a[row][i] + " ");
    }
}

//This took 1.75! Naive was better ;)
class SnakePatternModLogic {

    static void print(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                for (int j = 0; j < n; j++)
                    System.out.print(a[i][j] + " ");
            else
                for (int j = n - 1; j >= 0; j--)
                    System.out.print(a[i][j] + " ");
        }
    }
}