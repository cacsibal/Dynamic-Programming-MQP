package org.dp.topDown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoKeysKeyboardTest {

    /** https://leetcode.com/problems/2-keys-keyboard */
    @Test
    void test1() {
        TwoKeysKeyboard testTKK = new TwoKeysKeyboard();

        assertEquals(3, testTKK.solution(3));
    }

    /** https://leetcode.com/problems/2-keys-keyboard */
    @Test
    void test2() {
        TwoKeysKeyboard testTKK = new TwoKeysKeyboard();

        assertEquals(6, testTKK.solution(9));
    }
}