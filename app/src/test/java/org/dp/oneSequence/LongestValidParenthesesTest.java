package org.dp.oneSequence;

import org.dp.topDown.OnesAndZeroes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

    /** https://leetcode.com/problems/longest-valid-parentheses */
    @Test
    void test1() {
        LongestValidParentheses testLVP = new LongestValidParentheses();

        String s = ")()())";
        assertEquals(4,testLVP.solution(s));
    }

    /** https://leetcode.com/problems/longest-valid-parentheses/solutions/14133/my-dp-on-solution-without-using-stack-by-nsyp/ */
    @Test
    void test2() {
        LongestValidParentheses testLVP = new LongestValidParentheses();

        String s = "()(())";
        assertEquals(6,testLVP.solution(s));
    }
}