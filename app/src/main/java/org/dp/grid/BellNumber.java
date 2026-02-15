package org.dp.grid;
import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

import java.util.Arrays;

/**
 * Name: Bell Number
 * Description:
 * Given a set of n elements, find the number of ways of partitioning it
 *
 * Example:
 * n=2
 * number of ways = 2, since set {1,2} can be partition as {{1}, {2}} and {1,2}
 */
public class BellNumber implements ITopDown, IBottomUp{

    int n;

    public BellNumber(int n) {
        this.n = n;
    }

        public int helper_topdown(int n, int k, int[][] memo) {

            // Base cases

            if (n == 0 && k == 0) return 1;
            if (k == 0 || n == 0) return 0;
            if (n == k) return 1;
            if (k == 1) return 1;

            // Check if result is already computed
            if (memo[n][k] != -1) return memo[n][k];

            // Recursive formula
            memo[n][k] = k * helper_topdown(n - 1, k, memo) + helper_topdown(n - 1, k - 1, memo);
            return memo[n][k];
        }

    public int helper_bottomup() {

        // Create a 2D vector for Stirling numbers of the
        // second kind
        int[][] dp = new int[n + 1][n + 1];

        // Fill the table using dynamic programming
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {

                // These are some base cases
                if (j > i)
                    dp[i][j] = 0;
                else if (i == j)
                    dp[i][j] = 1;
                else if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {

                    // Recurrence relation: Stirling number
                    // calculation
                    dp[i][j]
                            = j * dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        // Sum up Stirling numbers for all j
        // from 0 to n to get the Bell number
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += dp[n][i];
        }

        // Return the Bell number
        return ans;
    }

        // Function to calculate the total number of
        // ways to partition a set of n elements
        public int solution_topdown() {

            // Initialize memoization table with -1
            int[][] memo = new int[n + 1][n + 1];
            for (int[] row : memo) Arrays.fill(row, -1);
            int result = 0;

            // Sum up Stirling numbers S(n, k) for all k from 1 to n
            for (int k = 1; k <= n; ++k) {
                result += helper_topdown(n, k, memo);
            }
            return result;
        }

        public int solution_bottomup(){
        return helper_bottomup();
        }

        public int solution(){
        return solution_bottomup();
        }
}
