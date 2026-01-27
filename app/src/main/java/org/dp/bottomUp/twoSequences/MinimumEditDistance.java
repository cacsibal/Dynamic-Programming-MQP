package org.dp.bottomUp.twoSequences;

public class MinimumEditDistance {
    String s1;
    String s2;
    int len1;
    int len2;
    int[][] dp;

    public MinimumEditDistance(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        len1 = s1.length();
        len2 = s2.length();
        dp = new int[len1 + 1][len2 + 1];
    }

    public int solution() {
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

    public String retrieve() {
        char[] path = new char[len2];

        int r = len1, c = len2;
        int index = len2 - 1;

        while(r > 0 || c > 0) {
            if(r > 0 && c > 0 && s1.charAt(r - 1) == s2.charAt(c - 1)) {
                path[index--] = s1.charAt(r - 1);
                r--;
                c--;
            } else if(r > 0 && c > 0 && dp[r][c] == dp[r - 1][c - 1] + 1) {
                path[index--] = s2.charAt(c - 1);
                r--;
                c--;
            } else if(c > 0 && (r == 0 || dp[r][c] == dp[r][c - 1] + 1)) {
                path[index--] = s2.charAt(c - 1);
                c--;
            } else if(r > 0) {
                r--;
            }
        }

        return new String(path);
    }
}