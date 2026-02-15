package org.dp.twoSequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UncrossedLinesTest {
    /**
     * https://leetcode.com/problems/uncrossed-lines/
     */
    @Test
    void test1() {
        int[] nums1 = new int[]{1, 4, 2};
        int[] nums2 = new int[]{1, 2, 4};
        UncrossedLines testUL = new UncrossedLines(nums1, nums2);
        int solution = testUL.solution();
        int[] retrieve = testUL.retrieve();

        assertAll(
                () -> assertEquals(2, solution),
                () -> assertArrayEquals(new int[]{1, 2}, retrieve)
        );
    }

    /**
     * https://leetcode.com/problems/uncrossed-lines/
     */
    @Test
    void test2() {
        int[] nums1 = new int[]{2, 5, 1, 2, 5};
        int[] nums2 = new int[]{10, 5, 2, 1, 5, 2};
        UncrossedLines testUL = new UncrossedLines(nums1, nums2);
        int solution = testUL.solution();
        int[] retrieve = testUL.retrieve();

        assertAll(
                () -> assertEquals(3, solution),
                () -> assertArrayEquals(new int[]{5, 2, 5}, retrieve)
        );
    }

    /**
     * https://leetcode.com/problems/uncrossed-lines/
     */
    @Test
    void test3() {
        int[] nums1 = new int[]{1, 3, 7, 1, 7, 5};
        int[] nums2 = new int[]{1, 9, 2, 5, 1};
        UncrossedLines testUL = new UncrossedLines(nums1, nums2);
        int solution = testUL.solution();
        int[] retrieve = testUL.retrieve();

        assertAll(
                () -> assertEquals(2, solution),
                () -> assertArrayEquals(new int[]{1, 5}, retrieve)
        );

        assertEquals(2, testUL.solution());
    }
}
