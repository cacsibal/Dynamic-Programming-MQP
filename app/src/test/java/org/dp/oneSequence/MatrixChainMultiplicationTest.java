package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixChainMultiplicationTest {

    @Test
    public void test() {

        // https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
        int[] input = {2, 1, 3, 4};
        MatrixChainMultiplication mcm = new MatrixChainMultiplication(input);
        assertEquals(20, mcm.solution());
        assertEquals("()(()())", mcm.retrieve());    // (A1(A2A3))
    }

    @Test
    public void test_2() {
        // https://en.wikipedia.org/wiki/Matrix_chain_multiplication
        int[] input = {10, 30, 5, 60};
        MatrixChainMultiplication mcm = new MatrixChainMultiplication(input);
        
        assertEquals(4500, mcm.solution());
        assertEquals("(()())()", mcm.retrieve());    // (A1(A2A3))
    }

    @Test
    public void test_3() {
        int[] input = {40, 20, 30, 10, 30};
        MatrixChainMultiplication mcm = new MatrixChainMultiplication(input);
        
        assertEquals(26000, mcm.solution());
        assertEquals("(()(()()))()", mcm.retrieve());    // ((A1(A2A3))A4)
    }
}