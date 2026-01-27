package org.dp.topDown.twoSequences;

import java.util.HashMap;
import java.util.Map;

public class MinimumEditDistance {
    String s1;
    String s2;
    int len1;
    int len2;
    Map<Integer,Integer> memo;

    public MinimumEditDistance(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        len1 = s1.length();
        len2 = s2.length();

        memo = new HashMap<>();
    }

    public int solution() {
        return helper(len1, len2);
    }

    public int helper(int r, int c){
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
            result = helper(r - 1, c - 1);
        }
        else {
            result = 1 + Math.min(helper(r, c - 1),
                    Math.min(helper(r - 1, c),
                            helper(r - 1, c - 1)));
        }

        memo.put(k, result);
        return result;
    }

    public String retrieve() {
        char[] path = new char[len2];

        int r = len1, c = len2;
        int index = len2 - 1;

        while(r > 0 || c > 0) {
            if (r == 0) {
                path[index--] = s2.charAt(c - 1);
                c--;
            } else if (c == 0) {
                r--;
            } else if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                path[index--] = s1.charAt(r - 1);
                r--;
                c--;
            } else {
                int k = (r + c) * (r + c + 1) / 2 + r;
                int current = memo.get(k);

                int kReplace = ((r - 1) + (c - 1)) * ((r - 1) + (c - 1) + 1) / 2 + (r - 1);
                int kInsert = (r + (c - 1)) * (r + (c - 1) + 1) / 2 + r;

                int replace = memo.getOrDefault(kReplace, Integer.MAX_VALUE);
                int insert = memo.getOrDefault(kInsert, Integer.MAX_VALUE);

                if (current == replace + 1) {
                    path[index--] = s2.charAt(c - 1);
                    r--;
                    c--;
                } else if (current == insert + 1) {
                    path[index--] = s2.charAt(c - 1);
                    c--;
                } else {
                    r--;
                }
            }
        }
        return new String(path);
    }
}
