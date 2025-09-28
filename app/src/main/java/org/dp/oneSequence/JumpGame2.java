package org.dp.oneSequence;


/**
 * JumpGame2: placeholder description
 *
 * dynprog solution:
 *
 *
 */
class JumpGame2 {
    public int jump(int[] nums) {
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