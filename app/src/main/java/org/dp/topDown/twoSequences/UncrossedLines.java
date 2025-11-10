package org.dp.topDown.twoSequences;

// todo: figure out why this doesn't work
public class UncrossedLines {
    int[][] memo;

    public int solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        memo = new int[len1 + 1][len2 + 1];

        return helper(nums1, nums2, len1, len2);
    }

    public int helper(int[] nums1, int[] nums2, int r, int c) {
        if(memo[r][c] != -1) return memo[r][c];
        if(r == 0 || c == 0) return 0;

        if(nums1[r - 1] == nums2[c - 1]) return helper(nums1, nums2, r - 1, c - 1) + 1;
        else return Math.max(helper(nums1, nums2, r, c - 1), helper(nums1, nums2, r - 1, c));
    }
}
