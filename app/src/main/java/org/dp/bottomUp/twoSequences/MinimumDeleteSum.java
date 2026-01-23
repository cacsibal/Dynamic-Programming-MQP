package org.dp.bottomUp.twoSequences;

/**
 * Minimum Delete Sum: For two strings, find the minimum number of characters to be deleted to make the two strings equal.
 * <a href="https://leetcode.com/problems/minimum-delete-sum-for-two-strings/">...</a>
 */

public class MinimumDeleteSum {
    String s1;
    String s2;
    int len1;
    int len2;
    int[][] dp;

    public MinimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        len1 = s1.length();
        len2 = s2.length();
        dp = new int[len1 + 1][len2 + 1];
    }

    public int solution() {
        /**
         * base cases: if a string is empty, delete all characters from the other string
         */
        for (int r = 1; r <= len1; r++) {
            dp[r][0] = dp[r - 1][0] + s1.charAt(r - 1);
        }

        for (int c = 1; c <= len2; c++) {
            dp[0][c] = dp[0][c - 1] + s2.charAt(c - 1);
        }

        /**
         * optimization through iteration
         */
        for (int r = 1; r <= len1; r++) {
            for (int c = 1; c <= len2; c++) {
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c] + s1.charAt(r - 1), dp[r][c - 1] + s2.charAt(c - 1));
                }
            }
        }

        /**
         * return the last element
         */
        return dp[len1][len2];
    }

    public String retrieve() {
        int commonLength = 0;
        int r = len1, c = len2;

        while (r > 0 && c > 0) {
            if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                commonLength++;
                r--;
                c--;
            } else if (dp[r - 1][c] + s1.charAt(r - 1) < dp[r][c - 1] + s2.charAt(c - 1)) {
                r--;
            } else {
                c--;
            }
        }

        char[] path = new char[commonLength];
        r = len1;
        c = len2;
        int index = commonLength - 1;

        while (r > 0 && c > 0) {
            if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                path[index--] = s1.charAt(r - 1);
                r--;
                c--;
            } else if (dp[r - 1][c] + s1.charAt(r - 1) < dp[r][c - 1] + s2.charAt(c - 1)) {
                r--;
            } else {
                c--;
            }
        }

        return new String(path);
    }
}
