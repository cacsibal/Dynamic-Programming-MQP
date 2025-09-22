package org.dp.topDown;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, 0, dict, memo);
    }

    private boolean helper(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true;

        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (dict.contains(word) && helper(s, end, dict, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }

    public static void main(String[] args) {
        WordBreak solver = new WordBreak();
        System.out.println(solver.wordBreak("leetcode", Arrays.asList("leet","code"))); // true
        System.out.println(solver.wordBreak("applepenapple", Arrays.asList("apple","pen"))); // true
        System.out.println(solver.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // false
    }
}

