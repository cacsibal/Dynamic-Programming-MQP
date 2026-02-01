package org.dp.bottomUp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UncrossedLinesTest {
    /**
     * https://leetcode.com/problems/uncrossed-lines/
     */
    @Test void test1() {
        UncrossedLines testUL = new UncrossedLines();

        int[] nums1 = new int[]{1, 4, 2};
        int[] nums2 = new int[]{1, 2, 4};

        assertEquals(2, testUL.solution(nums1, nums2));
    }

    /**
     * https://leetcode.com/problems/uncrossed-lines/
     */
    @Test void test2() {
        UncrossedLines testUL = new UncrossedLines();

        int[] nums1 = new int[]{2,5,1,2,5};
        int[] nums2 = new int[]{10,5,2,1,5,2};

        assertEquals(3, testUL.solution(nums1, nums2));
    }

    /**
     * https://leetcode.com/problems/uncrossed-lines/
     */
    @Test
    void test3() {
        UncrossedLines testUL = new UncrossedLines();

        int[] nums1 = new int[]{1,3,7,1,7,5};
        int[] nums2 = new int[]{1,9,2,5,1};

        assertEquals(2, testUL.solution(nums1, nums2));
    }
}
