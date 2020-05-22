package surya.practice.geeks.sorting;

import java.io.*;

public class FindMinimumDaysToBuyStock {


    // Complete the findMinDays function below.
    static int findMinDays(int n, int m) {
     return   findDays(n,m,0);
    }

    static int findDays(int initial, int target, int res)
    {
       /* findDays(initial-1, target, res+1);
        if(initial==target) return res;
        findDays(initial*2, target, res+1);   */
        return -1;    
    }
    public static void main(String[] args) throws IOException {

        int res = findMinDays(10, 1);
    }
}
