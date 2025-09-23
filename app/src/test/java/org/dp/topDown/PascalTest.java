package org.dp.topDown;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PascalTest {

    @Test
    void test4_2() {
        Pascal testPascal = new Pascal();

        assertEquals(6,testPascal.pascal(4,2));
    }

    @Test
    void test25_8() {
        Pascal testPascal = new Pascal();

        assertEquals(1081575, testPascal.pascal(25,8));
    }

}