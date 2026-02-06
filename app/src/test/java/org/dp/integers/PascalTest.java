package org.dp.integers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PascalTest {

    @Test
    void test4_2() {
        Pascal testPascal = new Pascal(4, 2);

        assertEquals(6,testPascal.solution_topdown());
    }

    @Test
    void test25_8() {
        Pascal testPascal = new Pascal(25, 8);

        assertEquals(1081575, testPascal.solution_bottomup());
    }

}