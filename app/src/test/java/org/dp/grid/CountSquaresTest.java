package org.dp.grid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountSquaresTest {
    @Test void test1() {
        CountSquares countSquares = new CountSquares();

        int[][] matrix = new int[][] {
                new int[] {0, 1, 1, 1},
                new int[] {1, 1, 1, 1},
                new int[] {0, 1, 1, 1}
        };

        assertEquals(15, countSquares.countSquares(matrix));
    }

    @Test void test2() {
        CountSquares countSquares = new CountSquares();

        int[][] matrix = new int[][] {
                new int[] {1, 0, 1},
                new int[] {1, 1, 0},
                new int[] {1, 1, 0}
        };

        assertEquals(7, countSquares.countSquares(matrix));
    }
}