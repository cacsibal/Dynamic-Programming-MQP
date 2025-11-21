package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/wildcard-pattern-matching/
class WildcardPatternMatchingTest {
    @Test
    void solution() {
        String pat = "a*b*c";
        String txt = "afhuirbfhwnkc";
        WildcardPatternMatching testcase = new WildcardPatternMatching();
        assertTrue(testcase.solution(txt, pat));
    }
    @Test
    void solution2() {
        String pat = "a?b?c";
        String txt = "a";
        WildcardPatternMatching testcase = new WildcardPatternMatching();
        assertFalse(testcase.solution(txt, pat));
    }

}