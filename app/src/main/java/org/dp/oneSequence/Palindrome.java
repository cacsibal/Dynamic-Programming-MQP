package org.dp.oneSequence;
import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

import java.util.*;

/**
 * Name: Palindrome Partitioning
 * Description:
 * Given a string s, find the minimum number of cuts needed for palindrome partitioning
 * of the given string, which need every substring of the partition is palindrome
 *
 * Example:
 * s = "geek
 * minimum cut = 2
 * g|ee|k
 */
public class Palindrome implements ITopDown, IBottomUp, IRetrieveSolution {

    String s;

    public Palindrome(String s) {
        this.s = s;
    }

    // helper function
    private boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int topdown_helper(int i, int j) {

        /**
         * initialization
         */
        if (i >= j || isPalindrome(i, j))
            return 0;

        int res = Integer.MAX_VALUE, cuts;

        /**
         * iterative solution
         */
        for (int k = i; k < j; k++) {
            cuts = 1 + topdown_helper(i, k) +
                    topdown_helper(k + 1, j);
            res = Math.min(res, cuts);
        }

        /**
         * return final result
         */
        return res;
    }

    public int bottomup_helper() {
        int n = s.length();

        // dp[i][j] = Minimum number of cuts needed for
        // palindrome partitioning of substring s[i..j]
        int[][] dp = new int[n][n];

        // isPalin[i][j] = true if substring s[i..j]
        // is palindrome, else false
        boolean[][] isPalin = new boolean[n][n];

        // Every substring of length 1 is a palindrome
        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
            dp[i][i] = 0;
        }

        for (int len = 2; len <= n; len++) {

            // Build solution for all  substrings s[i ... j]
            // of length len
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {

                // If len is 2, then we just need to
                // compare two characters.
                if (len == 2)
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j));

                    // Else need to check two corner characters
                    // and value of isPalin[i+1][j-1]
                else
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j))
                            && isPalin[i + 1][j - 1];

                // IF s[i..j] is palindrome, then dp[i][j] is 0
                if (isPalin[i][j])
                    dp[i][j] = 0;
                else {

                    // Make a cut at every possible location starting
                    // from i to j, and get the minimum cost cut.
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k <= j - 1; k++)
                        dp[i][j] = Math.min(dp[i][j], 1 +
                                dp[i][k] + dp[k + 1][j]);
                }
            }
        }

        // Return the min cut value for
        // complete string. i.e., s[0..n-1]
        return dp[0][n - 1];
    }

    public String[] retrieveHelper() {
        int n = s.length();

        // Precompute palindrome table
        boolean[][] isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        // dp[i] = minimum cuts needed for s[i..n-1]
        int[] dp = new int[n + 1];
        int[] nextCut = new int[n]; // to reconstruct solution

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        // Fill DP from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (isPal[i][j]) {
                    if (1 + dp[j + 1] < dp[i]) {
                        dp[i] = 1 + dp[j + 1];
                        nextCut[i] = j + 1; // record where to cut
                    }
                }
            }
        }

        // Reconstruct ONE optimal partition
        List<String> parts = new ArrayList<>();
        int i = 0;
        while (i < n) {
            parts.add(s.substring(i, nextCut[i]));
            i = nextCut[i];
        }

        return parts.toArray(new String[0]);
    }

    public int solution_topdown() {

        return topdown_helper(0, s.length() - 1);
    }

    public int solution_bottomup() {
        return bottomup_helper();
    }

    public String[] retrieve(){
        return retrieveHelper();
    }

    public int solution(){
        return solution_bottomup();
    }
}
