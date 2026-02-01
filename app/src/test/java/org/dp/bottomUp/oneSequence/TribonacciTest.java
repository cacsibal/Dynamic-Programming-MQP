package org.dp.bottomUp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TribonacciTest {
    /**
     * <a href="https://oeis.org/wiki/Tribonacci_numbers#">Testing base cases: trib(0) == 0, trib(1) == 1, trib(2) == 1</a>
     */
    @Test
    void test1() {
        Tribonacci testTribonacci = new Tribonacci();

        assertAll(
                () -> assertEquals(0, testTribonacci.solution(0)),
                () -> assertEquals(1, testTribonacci.solution(1)),
                () -> assertEquals(1, testTribonacci.solution(2))
        );
    }

    /**
     * <a href="https://oeis.org/wiki/Tribonacci_numbers#">trib(3) should equal 2</a>
     */
    @Test void test2() {
        Tribonacci testTribonacci = new Tribonacci();

        assertEquals(2, testTribonacci.solution(3));
    }

    /**
     * <a href="https://oeis.org/wiki/Tribonacci_numbers#">trib(10) should equal 149</a>
     */
    @Test void test3() {
        Tribonacci testTribonacci = new Tribonacci();

        assertEquals(149, testTribonacci.solution(10));
    }
}
