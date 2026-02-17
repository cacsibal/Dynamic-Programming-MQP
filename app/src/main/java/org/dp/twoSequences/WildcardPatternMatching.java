package org.dp.twoSequences;

import org.dp.IBottomUp;
import org.dp.ITopDown;

/**
 * Name: Wildcard Pattern Matching
 * Description:
 * Given two strings pat and txt which may be of different lengths.
 * Check if the wildcard pattern(pat) matches with txt or not.
 *
 * The wildcard pattern pat can include the characters '?' and '*'.
 *
 * '?' – can match to any single character.
 * '*' – can match to any sequence of characters (including the empty sequence).
 */

public class WildcardPatternMatching implements ITopDown, IBottomUp {

    String txt;
    String pat;

    public WildcardPatternMatching(String txt, String pat) {
        this.txt = txt;
        this.pat = pat;
    }

    private boolean helper_topdown(char[] txt, char[] pat, int n, int m) {
        if (m == 0)
            return (n == 0);

            // Empty text can match with a pattern consisting
            // of '*' only.
        if (n == 0) {
            for (int i = 0; i < m; i++)
                if (pat[i] != '*')
                    return false;
            return true;
            }

            // Either the characters match or pattern has '?'
            // move to the next in both text and pattern
            if (txt[n-1] == pat[m-1] || pat[m-1] == '?')
                return helper_topdown(txt, pat, n - 1, m - 1);

            // if the current character of pattern is '*'
            // first case: It matches with zero character
            // second case: It matches with one or more characters
            if (pat[m-1] == '*')
                return helper_topdown(txt, pat, n, m - 1) ||
                        helper_topdown(txt, pat, n - 1, m);

            return false;
        }

    public boolean helper_bottomup() {
        int n = txt.length();
        int m = pat.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // empty text and pattern
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // empty text matches with string of '*'s
                if (i == 0) {
                    dp[i][j] = (pat.charAt(j - 1) == '*') && dp[i][j - 1];
                }

                // if char at both index matches or '?'
                else if (pat.charAt(j - 1) == '?' ||
                        txt.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // if pattern char is '*'
                else if (pat.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[n][m];
    }

        public boolean solution_topdown() {
            int n = txt.length();
            int m = pat.length();
            return helper_topdown(txt.toCharArray(), pat.toCharArray(), n, m);
        }

        public boolean solution_bottomup() {
        return helper_bottomup();
        }

        public boolean solution(){
        return solution_bottomup();
        }

}
