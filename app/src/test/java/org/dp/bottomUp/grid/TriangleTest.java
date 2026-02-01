package org.dp.bottomUp.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    /** https://leetcode.com/problems/triangle/description */
    @Test
    void test_1() {
        Triangle testTri = new Triangle();

        int[][] grid = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        assertEquals(11,testTri.solution(grid));
    }

    /** https://leetcode.com/problems/triangle/description */
    @Test
    void test_2() {
        Triangle testTri = new Triangle();

        int[][] grid = new int[][]{{-10}};
        assertEquals(-10,testTri.solution(grid));
    }
}