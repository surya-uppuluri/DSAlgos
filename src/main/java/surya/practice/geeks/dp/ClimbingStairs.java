package surya.practice.geeks.dp;

public class ClimbingStairs {

    /*
     * You can climb 1 or 2 stairs with one step. How many different ways can
     * you climb n stairs?
     * Naive Solution:
     * Let f(n) be the number of different ways to climb n stairs.
     * How can we reach the nth stair??
     * (1) Be at the (n-2)th stair, then climb 2 Steps
     * (2) Be at the (n-1) stair, then climb 1 Step
     * For (1 ), number of ways to reach the (n-2)th Stair is f(n-2)
     * For (2), number of ways to reach the (n-1 )th Stair is f(n-1 )
     */
    public int stairsRecursion(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        else return stairsRecursion(n - 1) + stairsRecursion(n - 2);
    }

    public int stairsDp(int n) {
        int[] stairs = new int[n];
        stairs[1] = 1;
        stairs[2] = 2;
        for (int i = 3; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n-1];
    }


}
