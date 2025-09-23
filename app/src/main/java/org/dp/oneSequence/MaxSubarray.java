package org.dp.oneSequence;

class MaxSubarray {
    public int maxSubArray(int[] nums) {

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