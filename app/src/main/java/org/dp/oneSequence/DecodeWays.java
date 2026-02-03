package org.dp.oneSequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Name: DecodeWays
 * Description:
 * Let 1 maps to A, 2 maps to B, so on until 26 maps to Z. Given a digit sequence, count the
 * number of possible decode ways of the given sequence
 * Given digit "123"
 * (1,2,3) => ABC
 * (1,23) => AW
 * (12,3) => LC
 * So for digit "123", there are total of 3 ways of decode
 */
public class DecodeWays {

    String digits;

    public DecodeWays(String digits) {
        this.digits = digits;
    }

    public int solution() {
        return solution_bottomup();
    }

    public int solution_topdown() {
        int n = digits.length();
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, -1);

        return helper(0, dp);
    }

    private int helper(int i, int[] dp) {
        //initialization
        if (i == digits.length()) {
            return 1;
        }

        if (digits.charAt(i) == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        //iterative solution
        int ways = helper(i + 1, dp);

        // Option 2: take two digits (if valid 10–26)
        if (i + 1 < digits.length()) {
            int twoDigit = Integer.parseInt(digits.substring(i, i + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += helper(i + 2, dp);
            }
        }

        dp[i] = ways;
        return dp[i];
    }

    public int solution_bottomup() {
        int n = digits.length();

        // Edge case: empty string
        if (n == 0) return 0;

        int[] dp = new int[n + 1];

        // Base case: one way to decode an empty suffix
        dp[n] = 1;

        // Fill dp from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (digits.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Option 1: take one digit
            dp[i] = dp[i + 1];

            // Option 2: take two digits (if valid 10–26)
            if (i + 1 < n) {
                int twoDigit = Integer.parseInt(digits.substring(i, i + 2));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }

    private List<String> retrieveHelper(int i, Map<Integer, List<String>> memo) {

        // If we've reached the end, one valid decoding: empty string
        if (i == digits.length()) {
            return new ArrayList<>(List.of(""));
        }

        // If digit starts with 0, no valid decoding
        if (digits.charAt(i) == '0') {
            return new ArrayList<>();
        }

        // Return cached result if exists
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        List<String> ways = new ArrayList<>();

        // Option 1: take one digit
        int oneDigit = digits.charAt(i) - '0';
        if (oneDigit >= 1 && oneDigit <= 9) {
            for (String suffix : retrieveHelper(i + 1, memo)) {
                ways.add((char) ('A' + oneDigit - 1) + suffix);
            }
        }

        // Option 2: take two digits
        if (i + 1 < digits.length()) {
            int twoDigit = Integer.parseInt(digits.substring(i, i + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                for (String suffix : retrieveHelper(i + 2, memo)) {
                    ways.add((char) ('A' + twoDigit - 1) + suffix);
                }
            }
        }

        memo.put(i, ways);
        return ways;
    }

    public String[] retrieve() {
        Map<Integer, List<String>> memo = new HashMap<>();
        List<String> result = retrieveHelper(0, memo);
        return result.toArray(new String[0]);
    }
}

