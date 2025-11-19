package org.dp.bottomUp.oneSequence;


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
 */
class JumpGame2 {
    public int solution(int[] nums) {
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