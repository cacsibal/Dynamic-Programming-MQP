package org.dp.bottomUp.twoSequences;

public class UncrossedLines {
    int[] nums1;
    int[] nums2;
    int len1;
    int len2;
    int[][] dp;

    public UncrossedLines(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        len1 = nums1.length;
        len2 = nums2.length;
        dp = new int[len1 + 1][len2 + 1];
    }

    public int solution() {
        /**
         * Base Cases: dp[0][...] and dp[...][0] are already 0 by default
         */
        for(int r = 0; r <= len1; r++) {
            dp[r][0] = 0;
        }

        for(int c = 0; c <= len2; c++) {
            dp[0][c] = 0;
        }

        /**
         * Iterative solution
         */
        for (int r = 1; r <= len1; r++) {
            for (int c = 1; c <= len2; c++) {
                if (nums1[r - 1] == nums2[c - 1]) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }

        /**
         * return bottom right element
         */
        return dp[len1][len2];
    }

    public int[] retrieve() {
        int numLines = dp[len1][len2];
        int[] path = new int[numLines];

        int r = len1, c = len2;
        int index = numLines - 1;

        while (r > 0 && c > 0) {
            if (nums1[r - 1] == nums2[c - 1]) {
                path[index] = nums1[r - 1];
                index--;
                r--;
                c--;
            } else if (dp[r - 1][c] > dp[r][c - 1]) {
                r--;
            } else {
                c--;
            }
        }

        return path;
    }
}