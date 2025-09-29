package org.dp.oneSequence;

public class Knapsack {

    // Returns the maximum value that
    // can be put in a knapsack of capacity W
    static int knapsackRec(int W, int[] val, int[] wt, int n) {

        /**
         * initialization
         */
        if (n == 0 || W == 0)
            return 0;

        int pick = 0;

        /**
         * iterative solution
         */
        if (wt[n - 1] <= W)
            pick = val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1);

        // Don't pick the nth item
        int notPick = knapsackRec(W, val, wt, n - 1);

        return Math.max(pick, notPick);
    }

    public int solution(int W, int[] val, int[] wt) {
        int n = val.length;
        return knapsackRec(W, val, wt, n);
    }
}
