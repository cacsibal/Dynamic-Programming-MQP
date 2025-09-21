package org.dp.twoSequences;

import org.utils.MathUtils;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String s1, String s2) {
        // initialization
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // maximization
        for(int r = 0; r < len1; r++) {
            for(int c = 0; c < len2; c++) {
                if(s1.charAt(r) == s2.charAt(c)) {
                    dp[r + 1][c + 1] = dp[r][c] + 1;
                } else {
                    dp[r + 1][c + 1] = MathUtils.max(dp[r][c + 1], dp[r + 1][c]);
                }
            }
        }

        // return
        return dp[len1][len2];
    }
}

