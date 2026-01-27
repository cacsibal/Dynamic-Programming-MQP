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

    public MaxSubarray(int[] nums){
        this.nums = nums;
    }

    public int solution() {

        /**
         * Initialization
         */
        int c=nums[0];
        int m=c;

        /**
         * Iterative solution
         */
        for(int i=1;i<nums.length;i++){
            if(c<0){
                c=0;
            }
            c+=nums[i];
            m=Math.max(m,c);
        }

        /**
         * Return maximum subarray
         */
        return m;
    }
}