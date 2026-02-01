package org.dp.bottomUp.twoSequences;

public class MinimumEditDistance {
    public int solution(String s1, String s2) {
        /**
         * initialization
         */
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         * Base Cases:
         */
        for (int c = 1; c <= len2; c++) {
            dp[0][c] = c;
        }

        for (int r = 1; r <= len1; r++) {
            dp[r][0] = r;
        }

        /**
         * iterative solution
         */
        for (int r = 1; r <= len1; r++) {
            for (int c = 1; c <= len2; c++) {
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1]));
                }
            }
        }

        /**
         * return the last element
         */
        return dp[len1][len2];
    }
}