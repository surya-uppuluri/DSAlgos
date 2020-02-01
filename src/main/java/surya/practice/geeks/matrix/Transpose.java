package surya.practice.geeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Transpose {
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
            new TransposeMatrixInPlace().transpose(a, n);
            new TransposeMatrixInPlaceArithmeticSwap().transpose(a, n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(a[i][j] + " ");
            }

            System.out.println();
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class TransposeMatrix {


    //Read question thoroughly.

    //If only printing was needed, then the following function would have been okay.
        static void transpose(int[][] a, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i][j] + " ");
            }
        }
    }


}

class TransposeMatrixInPlace
{
    // Function to find the transpose of matrix
    // a[][]: input matrix
    // n: given size of matrix
    static void transpose(int[][] a, int n)
    {

        //do swap on the upper triangular matrix. That'll be sufficient

        for(int i=0; i<a.length; i++)
        {
            for(int j=i+1; j<a.length; j++)
            {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }
}

class TransposeMatrixInPlaceArithmeticSwap
{
    // Function to find the transpose of matrix
    // a[][]: input matrix
    // n: given size of matrix
    static void transpose(int[][] a, int n)
    {

        //do swap on the upper triangular matrix. That'll be sufficient

        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
               int x = a[i][j];
               int y = a[j][i];

               x = x^y;
               y = x^y;
               x = x^y;
            }
        }
    }
}