package org.dp.topDown.twoSequences;

import java.util.HashMap;
import java.util.Map;

public class MinimumEditDistance {
    Map<Integer,Integer> memo;

    public int solution(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        memo = new HashMap<>();

        return helper(s1, s2, len1, len2);
    }

    public int helper(String s1, String s2, int r, int c){
        int k = (r + c) * (r + c + 1) / 2 + r;
        if(memo.containsKey(k)) return memo.get(k);

        int result;
        if(r == 0) {
            result = c;
        }
        else if(c == 0) {
            result = r;
        }
        else if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
            result = helper(s1, s2, r - 1, c - 1);
        }
        else {
            result = 1 + Math.min(helper(s1, s2, r, c - 1),
                    Math.min(helper(s1, s2, r - 1, c),
                            helper(s1, s2, r - 1, c - 1)));
        }

        memo.put(k, result);
        return result;
    }
}
