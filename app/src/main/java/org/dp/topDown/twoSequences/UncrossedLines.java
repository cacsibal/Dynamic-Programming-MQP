package org.dp.topDown.twoSequences;

import java.util.*;

public class UncrossedLines {
    int[] nums1;
    int[] nums2;
    int len1;
    int len2;
    Map<Integer, Integer> memo;

    public UncrossedLines(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        len1 = nums1.length;
        len2 = nums2.length;
        memo = new HashMap<>();
    }

    public int solution() {
        return helper(len1, len2);
    }

    public int helper(int r, int c) {
        int k = (r + c) * (r + c + 1) / 2 + r;
        if(memo.containsKey(k)) return memo.get(k);
        if(r == 0 || c == 0) return 0;

        int result;
        if(nums1[r - 1] == nums2[c - 1]) {
            result = helper(r - 1, c - 1) + 1;
        }
        else {
            result =  Math.max(helper(r, c - 1), helper(r - 1, c));
        }

        memo.put(k, result);
        return result;
    }
}
