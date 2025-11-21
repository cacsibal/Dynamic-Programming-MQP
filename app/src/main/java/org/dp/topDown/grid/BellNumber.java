package org.dp.topDown.grid;
import java.util.Arrays;

public class BellNumber {

        static int helper(int n, int k, int[][] memo) {

            // Base cases

            if (n == 0 && k == 0) return 1;
            if (k == 0 || n == 0) return 0;
            if (n == k) return 1;
            if (k == 1) return 1;

            // Check if result is already computed
            if (memo[n][k] != -1) return memo[n][k];

            // Recursive formula
            memo[n][k] = k * helper(n - 1, k, memo) + helper(n - 1, k - 1, memo);
            return memo[n][k];
        }

        // Function to calculate the total number of
        // ways to partition a set of n elements
        public int solution(int n) {

            // Initialize memoization table with -1
            int[][] memo = new int[n + 1][n + 1];
            for (int[] row : memo) Arrays.fill(row, -1);
            int result = 0;

            // Sum up Stirling numbers S(n, k) for all k from 1 to n
            for (int k = 1; k <= n; ++k) {
                result += helper(n, k, memo);
            }
            return result;
        }
}
