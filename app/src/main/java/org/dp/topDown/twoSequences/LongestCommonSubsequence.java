package org.dp.topDown.twoSequences;

import java.util.Arrays;

public class LongestCommonSubsequence {
    int[][] memo;

    public int solution(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        memo = new int[len1 + 1][len2 + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return helper(s1, s2, len1, len2);
    }

    public int helper(String s1, String s2, int r, int c) {
        if(memo[r][c] != -1) return memo[r][c];
        if(r == 0 || c == 0) return 0;

        if(s1.charAt(r - 1) == s2.charAt(c - 1)) return helper(s1, s2, r - 1, c - 1) + 1;
        else return Math.max(helper(s1, s2, r, c - 1), helper(s1, s2, r - 1, c));
    }
}
