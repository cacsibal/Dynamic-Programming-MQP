package org.dp.bottomUp.oneSequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LongestValidParenthesesTest {

    /** https://leetcode.com/problems/longest-valid-parentheses */
    @Test
    void test1() {
        String s = ")()())";
        LongestValidParentheses testLVP = new LongestValidParentheses(s);

        assertEquals(4,testLVP.solution());
    }

    /** https://leetcode.com/problems/longest-valid-parentheses/solutions/14133/my-dp-on-solution-without-using-stack-by-nsyp/ */
    @Test
    void test2() {
        String s = "()(())";
        LongestValidParentheses testLVP = new LongestValidParentheses(s);

        assertEquals(6,testLVP.solution());
    }
}