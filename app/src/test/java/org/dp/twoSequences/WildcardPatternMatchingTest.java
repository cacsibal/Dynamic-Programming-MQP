package org.dp.twoSequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/wildcard-pattern-matching/
class WildcardPatternMatchingTest {
    @Test
    void solution() {
        String pat = "a*b*c";
        String txt = "afhuirbfhwnkc";
        WildcardPatternMatching testcase = new WildcardPatternMatching(txt,pat);
        assertTrue(testcase.solution());
    }
    @Test
    void solution2() {
        String pat = "a?b?c";
        String txt = "a";
        WildcardPatternMatching testcase = new WildcardPatternMatching(txt,pat);
        assertFalse(testcase.solution());
    }

}