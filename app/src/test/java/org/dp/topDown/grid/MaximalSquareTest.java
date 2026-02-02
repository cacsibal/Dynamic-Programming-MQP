package org.dp.topDown.grid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaximalSquareTest {
    /** https://leetcode.com/problems/maximal-square/description/ */
    @Test void test1() {
        char[][] matrix = new char[][] {
                new char[] {'1', '0', '1', '0', '0'},
                new char[] {'1', '0', '1', '1', '1'},
                new char[] {'1', '1', '1', '1', '1'},
                new char[] {'1', '0', '0', '1', '0'}
        };
        MaximalSquare testSquare = new MaximalSquare(matrix);

        assertEquals(4, testSquare.solution());
    }

    /** https://leetcode.com/problems/maximal-square/description/ */
    @Test void test2() {
        char[][] matrix = new char[][] {
                new char[] {'0', '1'},
                new char[] {'1', '0'}
        };
        MaximalSquare testSquare = new MaximalSquare(matrix);

        assertEquals(1, testSquare.solution());
    }
}