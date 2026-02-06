package org.dp.oneSequence;

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

    public MaxSubarray(int[] nums) {
        this.nums = nums;
    }

    public int helper_bottomup() {
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

    private int helper_topdown(int i, int currentSum, int globalMax) {

        if (i == nums.length) {
            return globalMax;
        }

        // Choice: either extend previous subarray or start new at nums[i]
        int newCurrent = Math.max(nums[i], currentSum + nums[i]);

        // Update global best
        int newGlobal = Math.max(globalMax, newCurrent);

        // Recurse to next index
        return helper_topdown(i + 1, newCurrent, newGlobal);
    }

    public int solution_bottomup() {
        return  helper_bottomup();
    }

    public int solution_topdown(){
        return helper_topdown(0,0,Integer.MIN_VALUE);
    }

    public int solution(){
        return solution_topdown();
    }
}