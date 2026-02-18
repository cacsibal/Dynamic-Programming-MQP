package org.dp.twoSequences;

import org.dp.IBottomUp;
import org.dp.ITopDown;

import java.util.*;

/**
 * Name: Word Break
 * Description:
 * Given a string s and y a dictionary of n words dictionary, check if
 * s can be segmented into a sequence of valid words from the dictionary, separated by spaces.
 */

public class WordBreak implements ITopDown, IBottomUp {

    String s;
    List<String> wordDict;

    public WordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
    }

    public boolean solution_topdown() {
        /**
         * initialization
         */
        Boolean[] memo = new Boolean[s.length()];
        return helper_topdown(0, memo);
    }

    public boolean helper_topdown(int start,Boolean[] memo) {
        if (start == s.length()) return true;

        if (memo[start] != null) return memo[start];
/**
 * iterative solution
 */
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word) && helper_topdown(end, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }

    public boolean helper_bottomup()
    {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Traverse through the given string
        for (int i = 1; i <= n; i++) {
            // Traverse through the dictionary words
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start]
                        && s.substring(start,
                                start + w.length())
                        .equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean solution_bottomup() {
        return helper_bottomup();
    }

    public boolean solution(){
        return solution_bottomup();
    }
}

