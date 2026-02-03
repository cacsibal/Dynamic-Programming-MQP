package org.dp.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://www.geeksforgeeks.org/dsa/palindrome-partitioning-dp-17/
class PalindromeTest {
@Test
void test1() {
    String s = "aaaaa";
    Palindrome palindrome = new Palindrome(s);
    assertEquals(0, palindrome.solution());
}

@Test
void test2() {
    String s = "ababbbabbababa";
    Palindrome palindrome = new Palindrome(s);
    assertEquals(3, palindrome.solution());
}

@Test
void test3() {
    String s = "aab";
    Palindrome palindrome = new Palindrome(s);
    String[] result = {"aa", "b"};
    assertArrayEquals(result, palindrome.retrieve());
    }

@Test
void test4() {
    String s = "aabaa";
    Palindrome palindrome = new Palindrome(s);
    String[] result = {"aabaa"};
    assertArrayEquals(result, palindrome.retrieve());
}
}