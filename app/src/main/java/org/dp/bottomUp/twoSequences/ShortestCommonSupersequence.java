package org.dp.bottomUp.twoSequences;

public class ShortestCommonSupersequence {
    String s1;
    String s2;
    int len1;
    int len2;
    int[][] dp;

    public ShortestCommonSupersequence(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        len1 = s1.length();
        len2 = s2.length();
        dp = new int[len1 + 1][len2 + 1];
    }

    public String solution() {
        /**
         * base cases
         */
        for (int row = 0; row <= len1; row++) {
            // When str2 is empty, the supersequence is str1 itself (length = row index)
            dp[row][0] = row;
        }
        for (int col = 0; col <= len2; col++) {
            // When str1 is empty, the supersequence is str2 itself (length = col index)
            dp[0][col] = col;
        }

        /**
         * optimization through iteration
         */
        for (int row = 1; row <= len1; row++) {
            for (int col = 1; col <= len2; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    // If characters match, inherit the length from the diagonal +1
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    // If characters do not match, take the minimum length option +1
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + 1;
                }
            }
        }

        /**
         * return the string: recovering the solution path
         */
        StringBuilder supersequence = new StringBuilder();
        int row = len1, col = len2;

        while (row > 0 && col > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                // If characters match, take it from diagonal
                supersequence.append(s1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] < dp[row][col - 1]) {
                // If str1’s character is part of the supersequence, move up
                supersequence.append(s1.charAt(row - 1));
                row--;
            } else {
                // If str2’s character is part of the supersequence, move left
                supersequence.append(s2.charAt(col - 1));
                col--;
            }
        }

        while (row > 0) {
            supersequence.append(s1.charAt(row - 1));
            row--;
        }
        while (col > 0) {
            supersequence.append(s2.charAt(col - 1));
            col--;
        }

        return supersequence.reverse().toString();
    }
}