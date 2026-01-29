package org.dp.topDown.oneSequence;

import java.util.HashMap;

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
    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();


    int[] nums;

    public MaxSubarray(int[] nums){
        this.nums = nums;
    }

    public int solution() {
        return helper(nums.length-1,1);
    }


    public int helper(int i, int m){
        Integer key = (i*(i+1))/2+m;

        if(!memo.containsKey(key)) {
            if (i == 0) {
                memo.put(key, nums[0]);
            } else if (m == 0) {
                memo.put(key, Math.max(helper(i - 1, 0) + nums[i], nums[i]));
            } else {
                memo.put(key, Math.max(helper(i, 0), helper(i - 1, 1)));
            }
        }

        return memo.get(key);
    }
}