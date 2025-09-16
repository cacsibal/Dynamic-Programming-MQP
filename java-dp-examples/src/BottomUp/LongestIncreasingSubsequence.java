package BottomUp;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        //initialization
        int[] dp = new int[nums.length];
        int max=0;
        for(int i=0;i<dp.length;i++) {
            dp[i]=1;
        }

        //maximization
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        //return
        return max;
    }
}