package org.dp.topDown.twoSequences;

import java.util.*;

public class DistinctSubsequences {
    String s1;
    String s2;
    int len1;
    int len2;
    Map<Integer, Integer> memo;

    public DistinctSubsequences(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        len1 = s1.length();
        len2 = s2.length();

        memo = new HashMap<>();
    }

    public int solution() {
        return helper(len1, len2);
    }

    public int helper(int r, int c) {
        int k = (r + c) * (r + c + 1) / 2 + r;
        if (memo.containsKey(k)) return memo.get(k);

        int result;
        if (c == 0) {
            result = 1;
        } else if (r == 0) {
            result = 0;
        } else if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
            result = helper(r - 1, c - 1) + helper(r - 1, c);
        } else {
            result = helper(r - 1, c);
        }

        return result;
    }
}
