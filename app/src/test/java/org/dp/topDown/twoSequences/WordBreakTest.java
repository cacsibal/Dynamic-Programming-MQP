package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void WordBreak() {
        WordBreak wordBreak = new WordBreak();
        assertTrue(wordBreak.solution("leetcode", Arrays.asList("leet","code")));
        assertFalse(wordBreak.solution("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}