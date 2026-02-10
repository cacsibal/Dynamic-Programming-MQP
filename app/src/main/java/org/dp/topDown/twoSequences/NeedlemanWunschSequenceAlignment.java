package org.dp.topDown.twoSequences;

import java.util.*;

public class NeedlemanWunschSequenceAlignment {
    Map<Integer,Integer> memo;
    public int solution(String s1, String s2, int match, int mismatch, int gap) {
        memo = new HashMap<>();

        int len1 = s1.length();
        int len2 = s2.length();

        return helper(s1, s2, len1, len2, match, mismatch, gap);
    }

    public int helper(String s1, String s2, int r, int c, int match, int mismatch, int gap) {
        int k = (r + c) * (r + c + 1) / 2 + r;
        if(memo.containsKey(k)) return memo.get(k);

        int result;
        if(r == 0) {
            result = c * gap;
        } else if(c == 0) {
            result = r * gap;
        } else {
            int score = (s1.charAt(r - 1) == s2.charAt(c - 1) ? match : mismatch);

            result = Math.max(
                    helper(s1, s2, r - 1, c - 1, match, mismatch, gap) + score,
                    Math.max(
                            helper(s1, s2, r - 1, c, match, mismatch, gap) + gap,
                            helper(s1, s2, r, c - 1, match, mismatch, gap) + gap
                    )
            );
        }

        return result;
    }
}
