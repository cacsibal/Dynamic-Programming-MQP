package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.ITopDown;

/**
 * Name: Jump Game
 * Description:
 * Given an integer array nums, Initially locate at array's first indes, each element in array
 * represents the maximum jump length at that position. Determine if you can reach the last
 * index or not
 */
class JumpGame implements ITopDown, IBottomUp {

    int nums[];
    Boolean[] memo;

    public JumpGame(int[] nums) {
        this.nums = nums;
        this.memo = new Boolean[nums.length];
    }

    public boolean helper_bottomup(){
        int n = nums.length;
        boolean[] dp = new boolean[n];

        dp[n - 1] = true; // base case

        for (int i = n - 2; i >= 0; i--) {
            int maxJump = nums[i];

            for (int step = 1; step <= maxJump && i + step < n; step++) {
                if (dp[i + step]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    private boolean helper_topdown(int index) {

        // Base case
        if (index >= nums.length - 1) {
            return true;
        }

        // If already computed
        if (memo[index] != null) {
            return memo[index];
        }

        int maxJump = nums[index];

        // Try all possible jumps
        for (int step = 1; step <= maxJump; step++) {
            if (helper_topdown(index + step)) {
                memo[index] = true;
                return true;
            }
        }

        memo[index] = false;
        return false;
    }

    public boolean solution_bottomup(){
        return helper_bottomup();
    }

    public boolean solution_topdown(){
        return helper_topdown(0);
    }

    public boolean solution(){
        return solution_topdown();
    }
}