package org.dp.bottomUp.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    /** https://leetcode.com/problems/triangle/description */
    @Test
    void test_1() {


        int[][] grid = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        Triangle testTri = new Triangle(grid);
        assertEquals(11,testTri.solution());
    }

    /** https://leetcode.com/problems/triangle/description */
    @Test
    void test_2() {


        int[][] grid = new int[][]{{-10}};
        Triangle testTri = new Triangle(grid);
        assertEquals(-10,testTri.solution());
    }
}