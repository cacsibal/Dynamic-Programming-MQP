package org.dp.topDown;

public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, -1);

        return helper(s, 0, dp);
    }

    private int helper(String s, int i, int[] dp) {
        // Base case: reached end successfully
        if (i == s.length()) {
            return 1;
        }

        // Leading zero is invalid
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Already computed
        if (dp[i] != -1) {
            return dp[i];
        }

        // Option 1: take one digit
        int ways = helper(s, i + 1, dp);

        // Option 2: take two digits (if valid 10–26)
        if (i + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(i, i + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += helper(s, i + 2, dp);
            }
        }

        dp[i] = ways;
        return dp[i];
    }
}

