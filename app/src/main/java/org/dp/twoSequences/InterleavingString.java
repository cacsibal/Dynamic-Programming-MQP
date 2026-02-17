package org.dp.twoSequences;
import org.dp.IBottomUp;
import org.dp.ITopDown;

import java.util.HashMap;

/**
 * Name: Interleaving string
 * Description:
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided i
 * nto n and m substrings respectively
 */
public class InterleavingString implements ITopDown, IBottomUp {

    /**
     * Create Cache
     */
    String s1;
    String s2;
    String s3;

    public InterleavingString(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    private HashMap<String,Boolean> memo = new HashMap<>();

    public boolean helper_topdown(String s1, String s2, String s3) {
        String key = s1+"_"+s2+"_"+s3;
        if(!memo.containsKey(key))
            memo.put(key,   (s1.isEmpty() && s2.isEmpty() & s3.isEmpty())||
                            (!s3.isEmpty() &&
                            ((!s1.isEmpty() &&s1.charAt(0)==s3.charAt(0)&&helper_topdown(s1.substring(1),s2,s3.substring(1)))||
                            (!s2.isEmpty() &&s2.charAt(0)==s3.charAt(0)&&helper_topdown(s1,s2.substring(1),s3.substring(1))))));
        return memo.get(key);

    }

    public boolean helper_bottomup() {
        int m = s1.length(), n = s2.length();

        // s3 can only be formed if total lengths match
        if (m + n != s3.length())
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Fill first row (s1 is empty)
        for (int j = 1; j <= n; j++)
            dp[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1)) && dp[0][j - 1];

        // Fill first column (s2 is empty)
        for (int i = 1; i <= m; i++)
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0];

        // Fill the rest of dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(k) && dp[i - 1][j]) ||
                        (s2.charAt(j - 1) == s3.charAt(k) && dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    public boolean solution_topdown(){
        return helper_topdown(s1,s2,s3);
    }

    public boolean solution_bottomup(){
        return helper_bottomup();
    }

    public boolean solution(){
        return solution_bottomup();
    }
}
