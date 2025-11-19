package org.dp.bottomUp.twoSequences;

public class DistinctSubsequences {
    public int solution(String s1, String s2) {
        /**
         * initialization
         */
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         * base cases: each substring s1.substring(0, r) is its own subsequence
         */
        for(int r = 0; r <= len1; r++) {
            dp[r][0] = 1;
        }

        /**
         * optimization through iteration
         */
        for(int r = 1; r <= len1; r++) {
            for(int c = 1; c <= len2; c++) {
                if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + dp[r - 1][c];
                } else {
                    dp[r][c] = dp[r - 1][c];
                }
            }
        }

        /**
         * return the bottom right element
         */
        return dp[len1][len2];
    }
}
