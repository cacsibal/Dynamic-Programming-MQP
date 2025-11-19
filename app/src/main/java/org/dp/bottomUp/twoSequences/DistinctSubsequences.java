package org.dp.bottomUp.twoSequences;

public class DistinctSubsequences {
    public int solution(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }

        for(int r = 1; r <= len1; r++) {
            for(int c = 1; c <= len2; c++) {
                if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + dp[r - 1][c];
                } else {
                    dp[r][c] = dp[r - 1][c];
                }
            }
        }

        return dp[len1][len2];
    }
}
