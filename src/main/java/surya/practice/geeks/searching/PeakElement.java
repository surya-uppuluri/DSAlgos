package surya.practice.geeks.searching;

import java.util.Scanner;

/**
 * todo - Find the peak element in the given array
 *
 * @author surya
 * @date 11/01/20
 * @time 1:14 PM
 */


class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int A = new Peak().peakElement(a, n);
            int f = 0;
            if (n == 1)
                f = 1;
            else if (A == 0 && a[0] >= a[1])
                f = 1;
            else if (A == n - 1 && a[n - 1] >= a[n - 2])
                f = 1;
            else if (a[A] >= a[A + 1] && a[A] >= a[A - 1])
                f = 1;
            else
                f = 0;
            System.out.println(f);
        }
    }
}// } Driver Code Ends
/*Complete the function below*/

class Peak {
    // Function to find the peak element
    // a[]: input array
    // n: size of array a[]
    public int peakElement(int[] a, int n) {
        //add code here.
        return 0;
    }
}