package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.ITopDown;

/**
 * Name: Maximum Product Cutting
 * Description:
 * Given a rope of length n, cut the rope in different parts of integer lengths that maximizes
 * product of lengths of all parts. At least one cuts
 *
 * Example:
 * n = 10
 * maximum product is 3*3*4 = 36
 */
public class MaximumProductCutting implements IBottomUp , ITopDown {

    int n;

    public MaximumProductCutting(int n) {
        this.n = n;
    }

    public int topdown_helper(int n) {
            // Base cases
        if (n == 0 || n == 1) return 0;

            // Make a cut at different places
            // and take the maximum of all
        int max_val = 0;
        for (int i = 1; i < n; i++)
            max_val = Math.max(max_val,
                    Math.max(i * (n - i),
                            topdown_helper(n - i) * i));

            // Return the maximum of all values
        return max_val;
    }

    public int bottomup_helper() {
        if (n <= 1) return 0;

        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(
                        dp[i],
                        Math.max(j, dp[j]) * Math.max(i - j, dp[i - j])
                );
            }
        }

        return dp[n];
    }

    public int solution_topdown(){
        return topdown_helper(n);
    }

    public int solution_bottomup(){
        return bottomup_helper();
    }

    public int solution() {
        return solution_topdown();
    }
}
