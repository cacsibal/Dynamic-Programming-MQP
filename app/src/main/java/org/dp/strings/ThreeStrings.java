package org.dp.strings;

import org.dp.IBottomUp;
import org.dp.ITopDown;

/**
 * Name: LCS of three strings
 * Description:
 * Given three strings s1, s2, and s3, find the longest
 * common subsequence in all strings
 */
public class ThreeStrings implements ITopDown, IBottomUp {
    String s1;
    String s2;
    String s3;

    public ThreeStrings(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public int helper_topdown(int n1, int n2, int n3) {

        // Base case: If any of the strings is empty
        if (n1 == 0 || n2 == 0 || n3 == 0)
            return 0;

        // If last characters of s1, s2, and s3 are the same
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)
                && s2.charAt(n2 - 1) == s3.charAt(n3 - 1)) {
            return 1
                    + helper_topdown(n1 - 1, n2 - 1,
                    n3 - 1);
        }

        // If last characters are not the same, calculate
        // LCS by excluding one string at a time
        return Math.max(
                Math.max(
                        helper_topdown(n1 - 1, n2, n3),
                        helper_topdown(n1, n2 - 1, n3)),
                helper_topdown(n1, n2, n3 - 1));
    }

    public int helper_bottomup() {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        // Create a 3D array (dp) to store the LCS lengths
        // for each combination of substrings
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        // dp[i][j][k] contains length of LCS of s1[0..i-1],
        // s2[0..j-1], and s3[0..k-1]
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        // Base Case: any string is empty
                        dp[i][j][k] = 0;
                    }
                    else if (s1.charAt(i - 1) == s2.charAt(j - 1)
                            && s1.charAt(i - 1) == s3.charAt(k - 1)) {

                        dp[i][j][k]= dp[i - 1][j - 1][k - 1]+ 1;
                    }
                    else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k],
                                dp[i][j - 1][k]),dp[i][j][k - 1]);
                    }
                }
            }
        }

        // dp[n1][n2][n3] contains length of LCS for
        // s1[0..n1-1], s2[0..n2-1], and s3[0..n3-1]
        return dp[n1][n2][n3];
    }

    public int solution_topdown(){
        return helper_topdown(s1.length(), s2.length(), s3.length());
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution(){
        return solution_bottomup();
    }
}
