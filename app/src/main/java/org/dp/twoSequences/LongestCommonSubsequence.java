package org.dp.twoSequences;

public class LongestCommonSubsequence {
    public int solution(String s1, String s2) {
        /**
         * Initialization
         */
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         * Iterative solution
         */
        for(int r = 0; r < len1; r++) {
            for(int c = 0; c < len2; c++) {
                if(s1.charAt(r) == s2.charAt(c)) {
                    dp[r + 1][c + 1] = dp[r][c] + 1;
                } else {
                    dp[r + 1][c + 1] = Math.max(dp[r][c + 1], dp[r + 1][c]);
                }
            }
        }

        /**
         * Return bottom right element
         */
        return dp[len1][len2];
    }
}

