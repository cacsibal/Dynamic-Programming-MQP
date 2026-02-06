package org.dp.oneSequence;

/**
 *  Max Subarray: For a given array, find the largest possible increasing subsequence length
 *
 *  dynprog solution:
 *
 *  LISnums <- c(10, 9, 2, 5, 3, 7, 101, 18)
 *
 *  LIS <- {
 *      S[1] <-1
 *      S[n] <- 1 + max(c(0, S[which(LISnums<LISnums[n])]))
 *  } %where% {
 *      n <- 1:length(LISnums)
 *
 * }
 *
 */
public class LongestIncreasingSubsequence {

    int[] nums;

    public LongestIncreasingSubsequence(int[] nums) {
        this.nums = nums;
    }

    public int helper_bottomup() {

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

    public int helper_topdown(int idx) {

        // Base case
        if (idx == 0)
            return 1;

        // Consider all elements on the left of i,
        // recursively compute LISs ending with
        // them and consider the largest
        int mx = 1;
        for (int prev = 0; prev < idx; prev++)
            if (nums[prev] < nums[idx])
                mx = Math.max(mx, helper_topdown(prev) + 1);
        return mx;
    }

    public int solution_topdown() {
        int n = nums.length;
        int res = 1;
        for (int idx = 1; idx < n; idx++)
            res = Math.max(res, helper_topdown(idx));
        return res;
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution() {
        return solution_topdown();
    }
}