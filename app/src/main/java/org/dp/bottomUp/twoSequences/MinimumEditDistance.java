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
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        /**
         * iterative solution
         */
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        /**
         * return the last element
         */
        return dp[len1][len2];
    }
}