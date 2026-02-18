package org.dp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FibonacciTest {
    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/">Testing base cases: fib(0) == 0 and fib(1) == 1</a>
     */
    @Test void testBaseCases() {
        Fibonacci testFibonacciZero = new Fibonacci(0);
        Fibonacci testFibonacciOne = new Fibonacci(1);

        assertAll(
                () -> assertEquals(0, testFibonacciZero.solution()),
                () -> assertEquals(1, testFibonacciOne.solution())
        );
    }

    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/">fib(2) should equal 2</a>
     */
    @Test void test2() {
        Fibonacci testFibonacci = new Fibonacci(2);

        assertEquals(1, testFibonacci.solution());
    }

    /**
     * <a href="https://leetcode.com/problems/fibonacci-number/">fib(10) should equal 55</a>
     */
    @Test void test3() {
        Fibonacci testFibonacci = new Fibonacci(10);

        assertEquals(55, testFibonacci.solution());
    }
}
