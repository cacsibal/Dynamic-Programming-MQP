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

        /**
         * Base Cases: dp[0][...] and dp[...][0] are 0
         */
        if(r == 0 || c == 0) return 0;

        /**
         * if solution has already been computed, return it
         */
        if(memo.containsKey(k)) return memo.get(k);

        int result;
        if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
            result = helper(r - 1, c - 1) + 1;
        } else {
            result = Math.max(helper(r, c - 1), helper(r - 1, c));
        }

        memo.put(k, result);
        return result;
    }

    public String retrieve() {
        int k = (len1 + len2) * (len1 + len2 + 1) / 2 + len1;

        int lcsLength = memo.get(k);
        char[] path = new char[lcsLength];

        int r = len1, c = len2;
        int index = lcsLength - 1;

        while(r > 0 && c > 0) {
            if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
                path[index--] = s1.charAt(r - 1);
                r--;
                c--;
            } else {
                int leftKey = (r + (c - 1)) * (r + (c - 1) + 1) / 2 + r;
                int upKey = ((r - 1) + c) * ((r - 1) + c + 1) / 2 + (r - 1);

                int leftValue = memo.getOrDefault(leftKey, 0);
                int upValue = memo.getOrDefault(upKey, 0);

                if(upValue > leftValue) {
                    r--;
                } else {
                    c--;
                }
            }
        }

        return new String(path);
    }
}
