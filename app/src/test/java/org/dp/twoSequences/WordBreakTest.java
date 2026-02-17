package org.dp.twoSequences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/word-break-problem-dp-32/
class WordBreakTest {

    @Test
    void WordBreak() {
        WordBreak wordBreak = new WordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"));
        assertFalse(wordBreak.solution());
    }

    @Test
    void WordBreak2() {
        WordBreak wordBreak = new WordBreak("leetcode", Arrays.asList("leet","code"));
        assertTrue(wordBreak.solution());
    }
}