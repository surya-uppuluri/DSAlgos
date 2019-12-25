package surya.practice.geeks.matrix;//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class MakeMatrixBoolean {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int r = 0, c = 0;
            String[] str = read.readLine().trim().split("\\s+");
            r = Integer.parseInt(str[0]);
            c = Integer.parseInt(str[1]);
            int[][] mat = new int[r][c];

            for (int i = 0; i < r; i++) {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for (int j = 0; j < c; j++) {
                    mat[i][j] = Integer.parseInt(str[k]);
                    k++;
                }
            }
            new BooleanMatrix().booleanMatrix(r, c, mat);
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class BooleanMatrix {
    static void booleanMatrix(int row, int col, int[][] mat) {
        HashMap<Integer, Boolean> rowV = new HashMap<>();
        HashMap<Integer, Boolean> colV = new HashMap<>();
        int r = 0, c = 0;
        while (r < row) {
            while (c < col) {
                if (rowV.getOrDefault(r, false).equals(false) || colV.getOrDefault(c, false).equals(false)) {
                    if (mat[r][c] == 1) {
                        mark(r, c, mat);
                        rowV.put(r, true);
                        colV.put(c, true);
                    }
                }
                r++;
                c++;
            }
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
                if (j == col - 1)
                    System.out.println();
            }


    }

    static void mark(int row, int col, int[][] mat) {
        for (int c = 0; c < mat[0].length; c++)
            mat[row][c] = 1;
        for (int r = 0; r < mat.length; r++)
            mat[r][col] = 1;
    }
}
