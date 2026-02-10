package org.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.geeksforgeeks.org/dsa/lcs-longest-common-subsequence-three-strings/
 */
public class ThreeStringLCSTest {
    @Test void test1() {
        ThreeStringLCS tslcs = new ThreeStringLCS("AGGT12", "12TXAYB", "12XBA");

        assertEquals(2, tslcs.solution());
    }

    @Test void test2() {
        ThreeStringLCS tslcs = new ThreeStringLCS("geeks", "geeksfor", "geeksforgeeks");

        assertEquals(5, tslcs.solution());
    }

    @Test void test3() {
        ThreeStringLCS tslcs = new ThreeStringLCS("abcd1e2", "bc12ea", "bd1ea");

        assertEquals(3, tslcs.solution());
    }
}
