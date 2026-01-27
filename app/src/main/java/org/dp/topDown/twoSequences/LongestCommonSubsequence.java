package org.dp.topDown.twoSequences;

import java.util.*;

public class LongestCommonSubsequence {
    String s1;
    String s2;
    int len1;
    int len2;
    Map<Integer,Integer> memo;

    public LongestCommonSubsequence(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.len1 = s1.length();
        this.len2 = s2.length();
        memo = new HashMap<>();
    }

    public int solution() {
        return helper(len1, len2);
    }

    public int helper(int r, int c) {
        int k = (r + c) * (r + c + 1) / 2 + r;
        if(memo.containsKey(k)) return memo.get(k);
        if(r == 0 || c == 0) return 0;

        int result;
        if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
            result = helper(r - 1, c - 1) + 1;
        }
        else {
            result = Math.max(helper(r, c - 1), helper(r - 1, c));
        }

        memo.put(k, result);
        return result;
    }
}
