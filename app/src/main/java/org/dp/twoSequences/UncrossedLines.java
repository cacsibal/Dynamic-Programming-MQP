package org.dp.twoSequences;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // initialization
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        // maximization
        for(int r = 0; r < len1; r++) {
            for(int c = 0; c < len2; c++) {
                if(nums1[r] == nums2[c]) {
                    dp[r + 1][c + 1] = dp[r][c] + 1;
                } else {
                    dp[r + 1][c + 1] = Math.max(dp[r][c + 1], dp[r + 1][c]);
                }
            }
        }

        // return
        return dp[len1][len2];
    }
}
