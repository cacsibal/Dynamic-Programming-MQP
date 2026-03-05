package org.dp.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//https://www.geeksforgeeks.org/dsa/lcs-longest-common-subsequence-three-strings/
class ThreeStringsTest {
@Test
void test1() {
    ThreeStrings testcse = new ThreeStrings("geeks", "geeksfor", "geeksforgeeks");
    assertEquals(5, testcse.solution());
}
}