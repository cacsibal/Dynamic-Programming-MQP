package org.dp.topDown;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void WordBreak() {
        WordBreak wordBreak = new WordBreak();
        assertTrue(wordBreak.wordBreak("leetcode", Arrays.asList("leet","code")));
        assertFalse(wordBreak.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}