package org.dp.oneSequence;


/**
 *  Max Subarray: For a given array, find the largest possible increasing subsequence length
 *
 *  dynprog solution:
 *
 *  psnum <- 20
 *  perfectsquares <- tail({
 *      P[1] <- 1
 *      P[n] <- ifelse(
 *         sqrt(n)%%1==0,
 *         1,
 *         min(c(n,1+P[n-which(P[1:n]==1)]))
 *         )
 * }%where% {
 *     n <- 1:psnum
 *
 * },1)
 *
 */
class PerfectSquares {
    public int numSquares(int n) {

        /**
         * Initializion
         */
        int[] dp=new int[n+1];
        dp[0]=0;

        /**
         * Iterative solution
         */
        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        /**
         * Return minimum number of squares to sum to n
         */
        return dp[n];
    }
}