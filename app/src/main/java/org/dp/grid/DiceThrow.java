package org.dp.grid;
import org.dp.IBottomUp;
import org.dp.ITopDown;

import java.util.Arrays;

/**
 * Name: Dice Throw
 * Description:
 * Given n dices each with m faces, numbered from 1 to m, find the number of ways to get sum x,
 * which is the summation of values on each face
 *
 * Example:
 * m=2, n=3, x=6
 * there is only 1 way to get the sum 6 using 3 dices from 1 to 2
 */

public class DiceThrow implements ITopDown, IBottomUp {

    int m;
    int n;
    int x;

    public DiceThrow(int m, int n, int x) {
        this.m = m;
        this.n = n;
        this.x = x;
    }
    static int helper_topdown(int m, int n, int x, int[][] memo) {

        // Base case: Valid combination
        /**
         * initialization
         */
        if (n == 0 && x == 0) return 1;

        // Base case: Invalid combination
        if (n == 0 || x <= 0) return 0;

        // If value is memoized
        if (memo[n][x] != -1) return memo[n][x];

        int ans = 0;

        /**
         * iterative
         */
        for (int i = 1; i <= m; i++) {
            ans += helper_topdown(m, n - 1, x - i, memo);
        }

        return memo[n][x] = ans;
    }

    public int helper_bottomup() {

        // Create a 2D dp array with (n+1) rows and (x+1)
        // columns dp[i][j] will store the number of ways to
        // get a sum of 'j' using 'i' dice
        int[][] dp = new int[n + 1][x + 1];

        // Base case: There is 1 way to get a sum of 0 with
        // 0 dice
        dp[0][0] = 1;

        // Loop through each dice (i) from 1 to n
        for (int i = 1; i <= n; i++) {

            // Loop through each sum (j) from 1 to x
            for (int j = 1; j <= x; j++) {

                // Loop through all possible dice values (k)
                // from 1 to m and if the sum j - k is valid
                // (non-negative), add the number of ways
                // from dp[i-1][j-k]
                for (int k = 1; k <= m && j - k >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        // The result will be in dp[n][x], which contains
        // the number of ways to get sum 'x' using 'n' dice
        return dp[n][x];
    }

    public int solution_topdown() {

        int[][] memo = new int[n + 1][x + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        return helper_topdown(m, n, x, memo);
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution(){
        return solution_bottomup();
    }
}
