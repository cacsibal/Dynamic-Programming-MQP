package org.dp.oneSequence;

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