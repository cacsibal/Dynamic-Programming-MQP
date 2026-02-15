package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 * Name: Minimum cost to reach to the top
 * Description:
 * Given an array of integers cost[] of length n, where elements inside array is the cost
 * of the ith step on the staircase. Once cost is paid, we can climb either one or two steps.
 * Find the minimum cost to reach the top
 *
 * Example:
 * cost[] = [1,100,1,1,1,100,1,1,100,1]
 * Minimum cost is 6. Start from step 0, skip all the 100
 */
public class MinCostClimbingStair implements ITopDown, IBottomUp{

    int[] cost;

    public MinCostClimbingStair(int[] cost) {
        this.cost = cost;
    }

        public int helper_bottomup() {
            int n = cost.length;

            if (n == 1) return cost[0];

            int[] dp = new int[n];
            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < n; i++) {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }

            return Math.min(dp[n - 1], dp[n - 2]);
        }

    public int helper_topdown(int i) {

        // Base case
        if (i == 0 || i == 1) {
            return cost[i];
        }

        return cost[i] + Math.min(helper_topdown(i - 1),
                helper_topdown(i - 2));
    }

    public int solution_topdown() {
        int n = cost.length;

        if (n == 1) return cost[0];

        // Return minimum of cost to
        // reach (n-1)th stair and
        // cost to reach (n-2)th stair
        return Math.min(helper_topdown(n - 1),
                helper_topdown(n - 2));
    }

        public int solution_bottomup() {
            return helper_bottomup();
        }

        public int solution(){
        return solution_bottomup();
        }
}
