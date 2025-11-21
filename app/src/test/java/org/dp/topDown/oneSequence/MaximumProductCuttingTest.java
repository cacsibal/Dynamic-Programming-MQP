package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/maximum-product-cutting-dp-36/
class MaximumProductCuttingTest {

    @Test
    void solution() {
        MaximumProductCutting testcase = new MaximumProductCutting();
        assertEquals(36, testcase.solution(10));
    }
    @Test
    void solution2() {
        MaximumProductCutting testcase = new MaximumProductCutting();
        assertEquals(4, testcase.solution(4));
    }
}