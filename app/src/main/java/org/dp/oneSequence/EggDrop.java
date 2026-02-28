package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.ITopDown;

/**
 * Name: Edd Droping puzzle
 * Description:
 * You are given n identical eggs and you have access to a k-floored building from 1 to k.
 *
 * There exists a floor f where 0 <= f <= k such that any egg dropped from a floor higher than f will break, and any egg dropped from or below floor f will not break. There are a few rules given below:
 *
 * An egg that survives a fall can be used again.
 * A broken egg must be discarded.
 * The effect of a fall is the same for all eggs.
 * If the egg doesn't break at a certain floor, it will not break at any floor below.
 * If the egg breaks on a certain floor, it will break on any floor above.
 * Your task is to find the minimum number of moves you need to determine the value of f with certainty.
 */
public class EggDrop implements ITopDown, IBottomUp {

    int n;
    int k;

    public EggDrop(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public int helper_topdown(int n, int k) {

        /**
         * Initialization
         */
        if (k == 1 || k == 0)
            return k;

        if (n == 1)
            return k;

        int res = Integer.MAX_VALUE;

        /**
         * Iterative solution
         */
        for (int i = 1; i <= k; i++) {
            int cur = 1 + Math.max(helper_topdown(n - 1, i - 1), helper_topdown(n, k - i));
            if (cur < res)
                res = cur;
        }
        /**
         * return the minimum number of attempts
         */
        return res;
    }

    public int helper_bottomup() {

        // create a 2D table to store the results
        int[][] dp = new int[k + 1][n + 1];

        // to count the number of moves
        int cnt = 0;

        // while the number of floors is less than k
        while (dp[cnt][n] < k) {
            cnt++;

            // for each egg
            for (int i = 1; i <= n; i++) {
                dp[cnt][i] = 1 + dp[cnt - 1][i - 1] + dp[cnt - 1][i];
            }
        }
        return cnt;
    }

    public int solution_topdown(){
        return helper_topdown(n, k);
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution(){
        return solution_bottomup();
    }
}
