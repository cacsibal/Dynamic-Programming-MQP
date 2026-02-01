package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/palindrome-partitioning-dp-17/
class PalindromeTest {
@Test
void test1() {
    String s = "aaaaa";
    Palindrome palindrome = new Palindrome();
    assertEquals(0, palindrome.solution(s));
}

@Test
void test2() {
    String s = "ababbbabbababa";
    Palindrome palindrome = new Palindrome();
    assertEquals(3, palindrome.solution(s));
    }
}