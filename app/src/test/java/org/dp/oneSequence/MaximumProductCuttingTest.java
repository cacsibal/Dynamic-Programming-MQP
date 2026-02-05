package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/maximum-product-cutting-dp-36/
class MaximumProductCuttingTest {

    @Test
    void solution() {
        MaximumProductCutting testcase = new MaximumProductCutting(10);
        assertEquals(36, testcase.solution());
    }
    @Test
    void solution2() {
        MaximumProductCutting testcase = new MaximumProductCutting(4);
        assertEquals(4, testcase.solution());
    }
}