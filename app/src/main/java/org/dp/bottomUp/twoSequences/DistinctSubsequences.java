package org.dp.bottomUp.twoSequences;

public class DistinctSubsequences {
    String s1;
    String s2;
    int len1;
    int len2;
    int[][] dp;

    public DistinctSubsequences(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        len1 = s1.length();
        len2 = s2.length();
        dp = new int[len1 + 1][len2 + 1];
    }
    public int solution() {
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

    public String retrieve() {
        char[] path = new char[len2];
        int r = len1, c = len2;
        int index = len2 - 1;

        while(r > 0 && c > 0) {
            if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                path[index] = s1.charAt(r - 1);
                index--;
                r--;
                c--;
            } else {
                r--;
            }
        }

        return new String(path);
    }
}
