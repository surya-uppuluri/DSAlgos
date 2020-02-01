package surya.practice.geeks.matrix;

import java.util.Scanner;

class SearchInLinearTime {
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
            int x = sc.nextInt();
            //new SearchinMat().search(n1, m1, arr1, x);
            SearchInMatrix obj = new SearchInMatrix();
            System.out.println(SearchInMatrix.search(n1, m1, arr1, x));
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
class SearchInMatrix {
    //Complete this function
    static int search(int row, int col, int[][] arr, int x) {

        /**
         ----------
         ALGORITHM
         ----------
         1) Start with top right element.
         2) Loop: compare this element e with x
         …i) if e = x, then return position of e, since we found x in the given matrix.
         …ii) if e > x then move left to check elements smaller than e
         (if out of bound of matrix, then break and return false)
         …iii) if e < x then move below to check elements greater than e
         (if out of bound of matrix, then break and return false)
         3) repeat the i), ii) and iii) until you find the element or return false
         **/

        //Position of start is r=0, col=col-1
        int r = 0, c = col - 1;
        int start = arr[r][c];
        while (true) {
            if (start == x)
                return 1;
            else if (start < x) {
                r++;
                if (r >= row) return 0;
                start = arr[r][c];
            } else if (start > x) {
                c--;
                if (c < 0) return 0;
                start = arr[r][c];
            }

        }
    }
}