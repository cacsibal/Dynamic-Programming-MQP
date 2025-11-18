package org.dp.topDown.twoSequences;

import java.util.*;

public class MinimumDeleteSum {
    Map<Integer, Integer> memo;

    public int solution(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        memo = new HashMap<>();

        return helper(s1, s2, len1, len2);
    }

    public int helper(String s1, String s2, int r, int c) {
        int k = (r + c) * (r + c + 1) / 2 + r;
        if(memo.containsKey(k)) return memo.get(k);

        int result;
        if (r == 0 && c == 0) {
            result = 0;
        } else if (r == 0) {
            result = helper(s1, s2, r, c - 1) + s2.charAt(c - 1);
        } else if (c == 0) {
            result = helper(s1, s2, r - 1, c) + s1.charAt(r - 1);
        } else {
            if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                result = helper(s1, s2, r - 1, c - 1);
            } else {
                int deleteS1 = helper(s1, s2, r - 1, c) + s1.charAt(r - 1);
                int deleteS2 = helper(s1, s2, r, c - 1) + s2.charAt(c - 1);
                result = Math.min(deleteS1, deleteS2);
            }
        }

        memo.put(k, result);
        return result;
    }
}
