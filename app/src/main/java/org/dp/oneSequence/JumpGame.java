package org.dp.oneSequence;

import java.util.Arrays;

/**
 *  Jump Game 2: For a given array representing how far forward you can jump from an index,
 *  how many jumps does it take to reach the last index
 *
 *  dynprog solution:
 *
 *  jumpnums <- c(2,3,0,1,4)
 *
 *  jumpgame2 <- tail({
 *      G[1] <- 0
 *      G[n] <- min(G[which((jumpnums[1:(n-1)]+(1:(n-1)))>=n)])+1
 *  }%where% {
 *      n <- 1:length(jumpnums)
 *  },1)
 *
 *  https://www.geeksforgeeks.org/dsa/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 */
class JumpGame {

    int nums[];

    public JumpGame(int[] nums) {
        this.nums = nums;
    }

    public int solution_topdown() {
        int result = helper(0);
        if (result > nums.length) {
            return -1;
        }
        return result;
    }

    public int helper(int i) {
        if (i >= nums.length - 1) { return 0; }    // base case

        // determine number of substeps based on values in nums. Tricky
        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int jumps = helper(i + j);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }

        return minJumps;
    }

    public int solution_bottomup() {
        int n = nums.length;

        // array to memoize values
        int[] dp = new int[n];
        Arrays.fill(dp, n+1);        // CAN never be more than n jumps
        dp[n - 1] = 0;               // unusual base case declaration

        // P(i) = Min (j, P(j) + 1) for (int j = i+1; j <= i + nums[i] && j < n; j++) {
        // P(n-1) = 0

        // start from the end.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                if (dp[j] < n) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        // If end cannot be reached.
        if (dp[0] > n)
            return -1;

        // unusual to have dp[0] be the result
        return dp[0];
    }

    // doesn't follow canonical ordering
    public int optimized() {
        /**
         * Edge case
         */
        if(nums.length<=1)
            return 0;

        /**
         * Initialization
         */
        int lastDist=0;
        int dist = 0;

        /**
         * Iterative solution
         */
        for(int i = 1;true;i++){
            int newdist=dist;
            for(int j = lastDist;j<=dist;j++){
                if(j+nums[j]>=nums.length-1)
                    return i;
                newdist = Math.max(newdist, j+nums[j]);
            }
            lastDist=dist;
            dist=newdist;
        }
    }
}