package org.dp.strings;

import java.util.HashMap;

public class InterleavingStrings {
    String s1, s2, s3;

    public InterleavingStrings(String s1, String s2, String s3) {
       this.s1 = s1; this.s2 = s2; this.s3 = s3;
    }

    public boolean solution() {
       return solution_bottomup();
    }

    public boolean solution_topdown() {
       return helper(s1.length(), s2.length());
    }

    public boolean helper(int i1, int i2) {
       // base cases
       if (i1 > s1.length())       { return false; }
       if (i2 > s2.length())       { return false; }
       if (i1 + i2 > s3.length())  { return false; } 

       if (i1 == 0 && i2 == 0)     { decision.put(key(i1,i2), true); return true; }     // empty strings
       if (i1 == 0)                { boolean b = s2.charAt(i2 - 1) == s3.charAt(i2 - 1); decision.put(key(i1,i2), b); return b; }
       if (i2 == 0)                { boolean b = s1.charAt(i1 - 1) == s3.charAt(i1 - 1); decision.put(key(i1,i2), b); return b; }
 
                   // Check if the current character in s3 matches s1 and the previous subproblem holds
       boolean b = (s1.charAt(i1 - 1) == s3.charAt(i1 + i2 - 1)) && helper(i1-1, i2)
                    ||
                   (s2.charAt(i2 - 1) == s3.charAt(i1 + i2 - 1)) && helper(i1,i2-1);
                   // Check if the current character in s3 matches s2 and the previous subproblem holds
        decision.put(key(i1,i2), b);
        return b;
    }

    /**
     * Checks if s3 is an interleaving of s1 and s2 using dynamic programming.
     * 
     * @param s1 The first string.
     * @param s2 The second string.
     * @param s3 The third string to check.
     * @return true if s3 is an interleaving, false otherwise.
     */
    public boolean solution_bottomup() {

        // dp[i][j] will be true if the first i chars of s1 and first j chars of s2
        // can interleave to form the first i + j chars of s3.
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // Computations proceed on increasing i and j indices
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) { dp[i][j] = true; } 
                else if (i == 0) { dp[0][j] = dp[0][j - 1] && j <= s2.length() && j <= s3.length() && (s2.charAt(j - 1) == s3.charAt(j - 1)); }
                else if (j == 0) { dp[i][0] = dp[i - 1][0] && i <= s1.length() && i <= s3.length() && (s1.charAt(i - 1) == s3.charAt(i - 1)); }
                else {
                  // P(i,j) requires P(i-1,j) and P(i,j-1) 
                  // Check if the current character in s3 matches s1 and the previous subproblem holds
                  boolean fromS1 = i <= s1.length() && i+j <= s3.length() && dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                  // Check if the current character in s3 matches s2 and the previous subproblem holds
                  boolean fromS2 = j <= s2.length() && i+j <= s3.length() && dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                
                  dp[i][j] = fromS1 || fromS2;
                }
            }
        }

        return dp[s1.length()][s2.length()]; // The final result is at the bottom-right corner.
    }

    // Retrieve solution -- not yet implemented
    //
    // return two strings showing from which string each character in s3 was taken
    // =======================================================
    HashMap<Integer,Boolean> decision = new HashMap<>();              // consistent storage for all decisions
  
    /** Cantor pairing function with two integer parameters */
    int key(int i, int j) {
      return (i+j)*(i+j+1)/2 + i;
    }

    public String[] retrieve() {
       return new String[]{"",""};
    }
}
