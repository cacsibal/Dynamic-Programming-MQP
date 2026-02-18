package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.ITopDown;

public class Fibonacci implements ITopDown, IBottomUp {
    int n;
    int[] dp;

    public Fibonacci(int n) {
        this.n = n;

        dp = new int[n + 1];
    }

    public int helper_topdown(int i){
        if(i == 0){
            return 0;
        }
        if (i == 1){
            return 1;
        }

        return helper_topdown(i - 1) + helper_topdown(i - 2);
    }

    public int helper_bottomup() {
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

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution_topdown(){
        return helper_topdown(n);
    }

    public int solution(){
        return solution_topdown();
    }
}
