package org.dp.bottomUp.twoSequences;

public class UncrossedLines {
    int[] nums1;
    int[] nums2;
    int len1;
    int len2;
    int[][] dp;

    public int solution(int[] nums1, int[] nums2) {
        /**
         * Initialization
         */
        this.nums1 = nums1;
        this.nums2 = nums2;

        len1 = nums1.length;
        len2 = nums2.length;

        dp = new int[len1 + 1][len2 + 1];

        /**
         * Iterative solution
         */
        for(int r = 0; r < len1; r++) {
            for(int c = 0; c < len2; c++) {
                if(nums1[r] == nums2[c]) {
                    dp[r + 1][c + 1] = dp[r][c] + 1;
                } else {
                    dp[r + 1][c + 1] = Math.max(dp[r][c + 1], dp[r + 1][c]);
                }
            }
        }

        /**
         * return bottom right element
         */
        return dp[len1][len2];
    }

    public int retrieve() {
        return -1;
    }
}
