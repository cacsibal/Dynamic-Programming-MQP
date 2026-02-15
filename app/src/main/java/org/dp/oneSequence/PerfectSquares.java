package org.dp.oneSequence;


import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 *  Name: Minimum perfect Square That sums to N
 *
 *  Description:
 *  Given a positive integer n, find the minimum number of perfect
 *  squares that sum up to n. We can use each square any number of times.
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
class PerfectSquares implements IBottomUp, ITopDown {
    int n;
    int[] dp;

    public PerfectSquares(int n){
        this.n=n;
        dp=new int[n+1];
    }

    public int helper_topdown(int num){
        if(num==0)return 0;

        int cnt = num;

        for(int i = 1; i*i<=num; i++){
            cnt = Math.min(cnt, 1+helper_topdown(num-i*i));
        }
        return cnt;
    }

    public int helper_bottomup() {
        /**
         * Initializion
         */

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

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution_topdown(){
        return helper_topdown(n);
    }

    public int solution(){
        return solution_topdown();
    }
}