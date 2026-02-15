package org.dp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TribonacciTest {
    /**
     * <a href="https://oeis.org/wiki/Tribonacci_numbers#">Testing base cases: trib(0) == 0, trib(1) == 1, trib(2) == 1</a>
     */
    @Test
    void test1() {
        Tribonacci testTribonacci1 = new Tribonacci(0);
        Tribonacci testTribonacci2 = new Tribonacci(1);
        Tribonacci testTribonacci3 = new Tribonacci(2);

        assertAll(
                () -> assertEquals(0, testTribonacci1.solution()),
                () -> assertEquals(1, testTribonacci2.solution()),
                () -> assertEquals(1, testTribonacci3.solution())
        );
    }

    /**
     * <a href="https://oeis.org/wiki/Tribonacci_numbers#">trib(3) should equal 2</a>
     */
    @Test void test2() {
        Tribonacci testTribonacci = new Tribonacci(3);

        assertEquals(2, testTribonacci.solution());
    }

    /**
     * <a href="https://oeis.org/wiki/Tribonacci_numbers#">trib(10) should equal 149</a>
     */
    @Test void test3() {
        Tribonacci testTribonacci = new Tribonacci(10);

        assertEquals(149, testTribonacci.solution());
    }
}
