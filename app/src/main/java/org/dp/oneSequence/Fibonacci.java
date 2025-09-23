package org.dp.oneSequence;

/**
 * Fibonacci: placeholder description
 *
 * dynprog solution:
 * fibs <- {
 *     F[1] <- 1
 *     F[2] <- 1
 *     F[n] <- F[n - 1] + F[n - 2]
 * }
 */
public class Fibonacci {
    public int solution(int n) {
        /**
         * Initialization
         */
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        /**
         * Iterative solution
         */
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        /**
         * Return the last element
         */
        return dp[n - 1];
    }
}

