package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://leetcode.com/problems/2-keys-keyboard/description/
class TwoKeysKeyboardTest {
    @Test
    void test1() {
        TwoKeysKeyboard keyboard = new TwoKeysKeyboard(3);
        assertEquals(3, keyboard.solution());
    }

    @Test
    void test2() {
        TwoKeysKeyboard keyboard = new TwoKeysKeyboard(1);
        assertEquals(0, keyboard.solution());
    }
}