package org.dp.twoSequences;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 * Name: Shortest Common Supersequence
 * Description:
 * Given two strings s1 and s2, Find the length of
 * the shortest string that has both s1 and s2 as subsequences.
 */
public class ShortestCommonSupersequence implements IBottomUp, ITopDown, IRetrieveSolution {
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

    public int helper_topdown(int m, int n){
        if(m == 0){
            return n;
        }

        if(n == 0){
            return m;
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return 1+ helper_topdown(m-1, n-1);
        }

        return 1+Math.min(helper_topdown(m, n-1), helper_topdown(m-1, n));
    }

    public int helper_bottomup() {
        int m = len1;
        int n = len2;

        // If s2 is empty, take all of s1
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        // If s1 is empty, take all of s2
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        // Fill the dp table iteratively
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If last chars match, include once
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // If not match, take min of both options
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public String retrieve() {
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

    public int solution_topdown() {
        return helper_topdown(len1, len2);
    }

    public int solution(){
        return solution_bottomup();
    }
}