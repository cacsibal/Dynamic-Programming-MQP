package org.dp.topDown.twoSequences;

public class WildcardPatternMatching {

    private boolean helper(char[] txt, char[] pat, int n, int m) {
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
                return helper(txt, pat, n - 1, m - 1);

            // if the current character of pattern is '*'
            // first case: It matches with zero character
            // second case: It matches with one or more characters
            if (pat[m-1] == '*')
                return helper(txt, pat, n, m - 1) ||
                        helper(txt, pat, n - 1, m);

            return false;
        }

        public boolean solution(String txt, String pat) {
            int n = txt.length();
            int m = pat.length();
            return helper(txt.toCharArray(), pat.toCharArray(), n, m);
        }

}
