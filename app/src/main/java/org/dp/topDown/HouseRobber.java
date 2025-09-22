package org.dp.topDown;

public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i] = max money from house i onwards, -1 means uncomputed
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, -1);

        return helper(nums, 0, dp);
    }

    private int helper(int[] nums, int i, int[] dp) {
        // Base case: no more houses
        if (i >= nums.length) {
            return 0;
        }

        // Already computed
        if (dp[i] != -1) {
            return dp[i];
        }

        // Option 1: Rob current house and skip next
        int robCurrent = nums[i] + helper(nums, i + 2, dp);

        // Option 2: Skip current house
        int skipCurrent = helper(nums, i + 1, dp);

        // Store best result
        dp[i] = Math.max(robCurrent, skipCurrent);
        return dp[i];
    }
}
