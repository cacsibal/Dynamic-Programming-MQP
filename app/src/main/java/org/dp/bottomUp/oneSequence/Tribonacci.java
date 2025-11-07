package org.dp.bottomUp.oneSequence;

// test commit to test github/discord webhook

public class Tribonacci {
    public int solution(int n) {
        /**
         * Base cases
         */
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        /**
         * Initialization
         */
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        /**
         * Optimization through Iteration
         */
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        /**
         * Return the last element
         */
        return dp[n];
    }
}
