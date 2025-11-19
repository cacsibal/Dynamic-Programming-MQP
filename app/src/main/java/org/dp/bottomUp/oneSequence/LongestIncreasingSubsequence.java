package org.dp.bottomUp.oneSequence;

public class LongestIncreasingSubsequence {
    public int solution(int[] nums) {

        /**
         * Initialization
         */
        int[] dp = new int[nums.length];
        int max=0;
        for(int i=0;i<dp.length;i++) {
            dp[i]=1;
        }

        /**
         * Iterative solution
         */
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        /**
         * Return maximum longest increasing subsequence.
         */
        return max;
    }
}