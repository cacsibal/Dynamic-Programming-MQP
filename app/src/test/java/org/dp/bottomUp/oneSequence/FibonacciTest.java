package org.dp.bottomUp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/">Testing base cases: fib(0) == 0 and fib(1) == 1</a>
     */
    @Test void testBaseCases() {
        Fibonacci testFibonacci = new Fibonacci();

        assertAll(
                () -> assertEquals(0, testFibonacci.solution(0)),
                () -> assertEquals(1, testFibonacci.solution(1))
        );
    }

    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/">fib(2) should equal 2</a>
     */
    @Test void test2() {
        Fibonacci testFibonacci = new Fibonacci();

        assertEquals(1, testFibonacci.solution(2));
    }

    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/">fib(10) should equal 55</a>
     */
    @Test void test3() {
        Fibonacci testFibonacci = new Fibonacci();

        assertEquals(55, testFibonacci.solution(10));
    }
}
