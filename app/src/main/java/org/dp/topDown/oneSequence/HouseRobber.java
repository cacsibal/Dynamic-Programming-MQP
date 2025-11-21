package org.dp.topDown.oneSequence;

import java.util.Arrays;

public class HouseRobber {

    public int solution(int[] nums) {
        /**
         * Initialization
         */
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(nums, 0, dp);
    }

    /**
     * iterative solution
     */
    private int helper_original(int[] nums, int i, int[] dp) {
        // Base case: no more houses
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int robCurrent = nums[i] + helper(nums, i + 2, dp);

        int skipCurrent = helper(nums, i + 1, dp);

        dp[i] = Math.max(robCurrent, skipCurrent);
        /**
         * return maximum amount of money robbed
         */
        return dp[i];
    }

    private int helper(int[] nums, int i, int[] dp) {
        // Base case: no more houses
        int return_value;
        if (i < nums.length) {

            if (dp[i] != -1) {
                return_value = dp[i];
            } else {

                int robCurrent = nums[i] + helper(nums, i + 2, dp);

                int skipCurrent = helper(nums, i + 1, dp);

                dp[i] = Math.max(robCurrent, skipCurrent);
                /**
                 * return maximum amount of money robbed
                 */
                return_value = dp[i];
            }
        } else {
            return_value =  0;
        }

        return return_value;
    }
}
