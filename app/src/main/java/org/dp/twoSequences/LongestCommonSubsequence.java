package org.dp.twoSequences;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    String s1;
    String s2;
    int[][] dp = null;     // used by bottom-up
    int computed_solution = -1;   // used by top-down

    public LongestCommonSubsequence(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

      /** Cantor pairing function with two integer parameters */
    int key(int i, int j) {
      return (i+j)*(i+j+1)/2 + i;
    }

    public int solution_bottomup() {
        int len1 = s1.length();
        int len2 = s2.length();

        dp = new int[len1 + 1][len2 + 1];

        /** Base Cases: dp[0][...] and dp[...][0] are already 0 by default */
        for(int r = 0; r <= len1; r++) { dp[r][0] = 0; }
        for(int c = 0; c <= len2; c++) { dp[0][c] = 0; }

        /** Iterative solution */
        for (int r = 1; r <= len1; r++) {
            for (int c = 1; c <= len2; c++) {
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                    decision.put(key(r, c), 2);
                } else {
                    if (dp[r][c - 1] >= dp[r - 1][c]) {
                        decision.put(key(r, c), -1);     // from left
                        dp[r][c] = dp[r][c - 1];
                    } else {
                        decision.put(key(r, c), 1); // from top
                        dp[r][c] = dp[r - 1][c];
                    }
                }
            }
        }

        /** Return solution to final problem. */
        return dp[len1][len2];
    }

    Map<Integer,Integer> memo;

    public int solution_topdown() {
        int len1 = s1.length();
        int len2 = s2.length();

        memo = new HashMap<>();

        computed_solution = helper(len1, len2);
        return computed_solution;
    }

    public int helper(int r, int c) {
        int k = (r + c) * (r + c + 1) / 2 + r;
        if(memo.containsKey(k)) return memo.get(k);
        if(r == 0 || c == 0) return 0;

        int result;
        if(s1.charAt(r - 1) == s2.charAt(c - 1)) {
            decision.put(key(r, c), 2);
            result = helper(r - 1, c - 1) + 1;
        }
        else {
            int left = helper(r, c - 1);
            int top = helper(r - 1, c);
            if (top >= left) {
                decision.put(key(r, c), 1); // from top
                result = top;
            } else {
                decision.put(key(r, c), -1);     // from left
                result = left;
            }
        }

        memo.put(k, result);
        return result;
    }

    // Retrieve Solution
    // =======================================================
    HashMap<Integer,Integer> decision = new HashMap<>();              // consistent storage for all decisions

    // Retrieve solution based on recursive traversal of decision points
    public String retrieve() {
       return expand(s1.length(), s2.length());   // start at index 1 since A[0..1] is first matrix
    }
 
    public String expand(int m, int n) {
        int len;
        if (dp != null) {
            len = dp[m][n];
        } else {
            len = computed_solution;
        }
        char[] path = new char[len];

        int r = m, c = n;
        int index = len - 1;

        while (r > 0 && c > 0) {
            int choice = decision.get(key(r, c));
            if (choice == 2) {          // from diagonal
                path[index] = s1.charAt(r - 1);
                index--;
                r--;
                c--;
            } else if (choice == 1) {   // from top
                r--;
            } else {
                c--;
            }
        }

        return new String(path);
    }
}