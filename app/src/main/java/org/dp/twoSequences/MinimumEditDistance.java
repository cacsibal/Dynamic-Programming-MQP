package org.dp.twoSequences;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 * Name: Edit Distance
 * Description:
 * Given two string s1 and s2, you can insert any character to any index to s1, or
 * remove a character of s1, or replace a character at any index of s1 with some other
 * character, find the minimum number of operations to convert s1 into s2
 *
 * Example:
 * s1 = "geek", s2 = "gesek"
 * output: 1
 * We can insert s into two consecutive 'e' in s1
 */

public class MinimumEditDistance implements ITopDown, IBottomUp{

    String s1;
    String s2;

    public MinimumEditDistance(String s1, String s2){
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

    public int helper_topdown(int m, int n) {

        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Get the count for
        // remaining strings.
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return helper_topdown(m - 1, n - 1);

        // If last characters are not same, consider all three
        // operations on last character of first string,
        // recursively compute minimum cost for all three
        // operations and take minimum of three values.
        return 1 + Math.min(
                Math.min(helper_topdown(m, n - 1),
                        helper_topdown(m - 1, n)),
                helper_topdown(m - 1, n - 1));
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution_topdown(){
        return helper_topdown(s1.length(), s2.length());
    }

    public int solution(){
        return solution_topdown();
    }
}