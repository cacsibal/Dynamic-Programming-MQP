package org.dp.oneSequence;


import org.dp.IBottomUp;
import org.dp.ITopDown;

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
class JumpGame2 implements ITopDown, IBottomUp {

    int[] nums;
    public JumpGame2(int[] nums){
        this.nums=nums;
    }

    public int helper_bottomup() {
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

    public int helper_topdown(int index) {
        if(index >= nums.length-1){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = index+1; i<= index+nums[index]; i++){
            int val = helper_topdown(i);
            if(val != Integer.MAX_VALUE){
                ans = Math.min(ans, 1+val);
            }
        }
        return ans;
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution_topdown() {
        int ans = helper_topdown(0);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

    public int solution(){
        return solution_topdown();
    }
}