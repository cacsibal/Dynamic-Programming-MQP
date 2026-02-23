package org.dp.knapsack;

import org.dp.IBottomUp;
import org.dp.ITopDown;

import java.util.HashMap;

/**
 * Name: Knapsack
 * Description:
 * Given two arrays, profit[] and weight[], where each element represents
 * the profit and weight of an item respectively, also given an integer W
 * representing the maximum capacity of the knapsack (the total weight it can hold).
 *
 * Put the items into the knapsack such that the sum of profits associated with
 * them is the maximum possible, without exceeding the capacity W.
 */

public class Knapsack implements ITopDown, IBottomUp {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    int[] weights;
    int[] values;
    int W;
    public Knapsack(int W, int[] weights, int[] values){
        this.W=W;
        this.weights=weights;
        this.values=values;
    }

    public int solution_topdown(){
        return helper_topdown(weights.length-1, W);
    }
    public int helper_topdown(int i, int W){
        if(i==-1 || W==0){
            return 0;
        }
        Integer key = (W+i)*(W+i+1)/2+i;
        if(!memo.containsKey(key)){
            memo.put(key,
                    Math.max(
                            helper_topdown(i-1,W),
                        weights[i]<=W?(values[i]+helper_topdown(i-1,W-weights[i])):0
                    )
            );
        }

        return memo.get(key);
    }

    public int helper_bottomup() {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                // If there is no item or the knapsack's capacity is 0
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    int pick = 0;

                    // Pick ith item if it does not exceed the capacity of knapsack
                    if (weights[i - 1] <= j)
                        pick = values[i - 1] + dp[i - 1][j - weights[i - 1]];

                    // Don't pick the ith item
                    int notPick = dp[i - 1][j];

                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][W];
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution(){
        return solution_bottomup();
    }
}
