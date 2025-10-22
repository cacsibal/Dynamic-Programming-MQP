package org.dp.twoSequences;

public class LongestCommonSubsequence {
    String s1;
    String s2;
    int len1;
    int len2;
    int[][] dp;

    public int solution(String s1, String s2) {
        /**
         * Initialization
         */
        this.s1 = s1;
        this.s2 = s2;

        len1 = s1.length();
        len2 = s2.length();

        dp = new int[len1 + 1][len2 + 1];

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

    public String retrieve() {
        int lcsLength = dp[len1][len2];
        char[] path = new char[lcsLength];

        int r = len1, c = len2;
        int index = lcsLength - 1;

        while(r > 0 && c > 0) {
            if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
                path[index] = s1.charAt(r - 1);
                index--;
                r--;
                c--;
            } else if(dp[r - 1][c] > dp[r][c - 1]) {
                r--;
            } else {
                c--;
            }
        }

        return new String(path);
    }
}

