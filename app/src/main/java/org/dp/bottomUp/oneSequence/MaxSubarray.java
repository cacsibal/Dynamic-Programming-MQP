package org.dp.bottomUp.oneSequence;

/**
 *  Max Subarray: For a given array, find the largest possible sum of any subarray(continuous subset of the array)
 *
 *  dynprog solution:
 *  nums <- c(-2,1,-3,4,-1,2,1,-5,4)
 *
 *  maxsubarray <- max({
 *      M[1] <- nums[1]
 *      M[n] <- max(M[n-1]+nums[n],nums[n])
 *  }%where% {
 *      n <- 1:length(nums)
 *  })
 *
 */
class MaxSubarray {
    int[] nums;
    int[][] dp;

    public MaxSubarray(int[] nums){
        this.nums = nums;
        dp = new int[nums.length][2];
    }

    public int solution() {

        /**
         * Iterative solution
         */
        for(int i=0;i<nums.length;i++){
            if(i<1){
                dp[i][0]=nums[0];
                dp[i][1]=nums[0];
            }
            else{
                dp[i][0]=Math.max(nums[i], dp[i-1][0]+nums[i]);
                dp[i][1]=Math.max(dp[i][0], dp[i-1][1]);
            }
        }

        /**
         * Return maximum subarray
         */
        return dp[nums.length-1][1];
    }

    public String retrieve(){
        return findPath(nums.length-1, 1);
    }
    public String findPath(int x, int y){
        if(y==0){
            if(x==0){
                return "Take element 0";
            }
            else{
                if(nums[x] > dp[x-1][0]+nums[x-1]){
                    return "Take element " + x;
                }
                else{
                    return findPath(x-1,0)+"\nTake element " +x;
                }
            }
        }
        else{
            if(x==0){
                return findPath(0,1);
            }
            else{
                if(dp[x][0]>dp[x-1][1]){
                    return findPath(x,0);
                }
                else{
                    return findPath(x-1,1);
                }
            }
        }
    }
}