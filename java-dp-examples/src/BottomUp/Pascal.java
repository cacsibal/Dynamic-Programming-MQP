package BottomUp;

public class Pascal {

    public int[][] pascal(int n) {
        // initialization
        int[][] dp = new int[n][n];
        dp[0][0] = 1;

        // maximization
        for (int r = 1; r < n; r++) {
            dp[r][0] = 1;
            for (int c = 1; c <= r; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r - 1][c - 1];
            }
        }

        // return
        return dp;
    }
}
