package org.dp.bottomUp.oneSequence;

public class Fibonacci {
    int n;
    int[] dp;

    public Fibonacci(int n) {
        this.n = n;

        dp = new int[n + 1];
    }

    public int solution() {
        /**
         * Base Cases
         */
        if (n == 0) return 0;
        if (n == 1) return 1;

        dp[0] = 0;
        dp[1] = 1;

        /**
         * Optimization through Iteration
         */
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        /**
         * Return the last element
         */
        return dp[n];
    }
}
