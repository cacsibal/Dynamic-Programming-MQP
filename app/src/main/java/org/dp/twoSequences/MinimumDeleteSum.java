package org.dp.twoSequences;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 * Minimum Delete Sum: For two strings, find the minimum number of characters to be deleted to make the two strings equal.
 * <a href="https://leetcode.com/problems/minimum-delete-sum-for-two-strings/">...</a>
 */

public class MinimumDeleteSum implements ITopDown, IBottomUp{

    String s1;
    String s2;

    public MinimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public int helper_bottomup() {
        /**
         * initialization
         */
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

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

    public int helper_topdown(int i, int j) {

        // If s1 is exhausted, delete all remaining chars in s2
        if (i == s1.length()) {
            int cost = 0;
            for (int k = j; k < s2.length(); k++) {
                cost += s2.charAt(k);
            }
            return cost;
        }

        // If s2 is exhausted, delete all remaining chars in s1
        if (j == s2.length()) {
            int cost = 0;
            for (int k = i; k < s1.length(); k++) {
                cost += s1.charAt(k);
            }
            return cost;
        }

        // If characters match, keep them and move both pointers
        if (s1.charAt(i) == s2.charAt(j)) {
            return helper_topdown(i + 1, j + 1);
        }

        // Otherwise, try both deletion choices and take the minimum
        int deleteFromS1 =
                s1.charAt(i) + helper_topdown(i + 1, j);

        int deleteFromS2 =
                s2.charAt(j) + helper_topdown(i, j + 1);

        return Math.min(deleteFromS1, deleteFromS2);
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution_topdown() {
        return helper_topdown(0, 0);
    }

    public int solution(){
        return solution_topdown();
    }
}
