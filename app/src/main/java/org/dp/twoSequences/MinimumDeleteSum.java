package org.dp.twoSequences;

/**
 * Minimum Delete Sum: For two strings, find the minimum number of characters to be deleted to make the two strings equal.
 * <a href="https://leetcode.com/problems/minimum-delete-sum-for-two-strings/">...</a>
 */
public class MinimumDeleteSum {
    public int solution(String s1, String s2) {
        /**
         * initialization
         */
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        /**
         * base cases: if a string is empty, delete all characters from the other string
         */
        for(int r = 1; r <= m; r++) {
            dp[r][0] = dp[r - 1][0] + s1.charAt(r - 1);
        }

        for(int c = 1; c <= n; c++) {
            dp[0][c] = dp[0][c - 1] + s2.charAt(c - 1);
        }

        /**
         * optimization through iteration
         */
        for(int r = 1; r <= m; r++) {
            for(int c = 1; c <= n; c++) {
                if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c] + s1.charAt(r - 1), dp[r][c - 1] + s2.charAt(c - 1));
                }
            }
        }

        /**
         * return the last element
         */
        return dp[m][n];
    }
}
