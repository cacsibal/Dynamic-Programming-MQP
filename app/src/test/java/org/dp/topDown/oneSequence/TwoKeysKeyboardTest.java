package org.dp.topDown.oneSequence;

import org.dp.topDown.knapsack.TwoKeysKeyboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoKeysKeyboardTest {

    /** https://leetcode.com/problems/2-keys-keyboard */
    @Test
    void test1() {
        TwoKeysKeyboard testTKK = new TwoKeysKeyboard(3);

        assertEquals(3, testTKK.solution());
    }

    /** https://leetcode.com/problems/2-keys-keyboard */
    @Test
    void test2() {
        TwoKeysKeyboard testTKK = new TwoKeysKeyboard(9);

        assertEquals(6, testTKK.solution());
    }
}