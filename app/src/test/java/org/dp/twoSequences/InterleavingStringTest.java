package org.dp.twoSequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterleavingStringTest {

    /** https://leetcode.com/problems/interleaving-string/description//*/
    @Test
    void test_1() {


        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString testILS = new InterleavingString(s1,s2,s3);
        assertEquals(true,testILS.solution());
    }

    /** https://leetcode.com/problems/interleaving-string/description//*/
    @Test
    void test_2() {

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        InterleavingString testILS = new InterleavingString(s1,s2,s3);
        assertEquals(false,testILS.solution());
    }

    /** https://leetcode.com/problems/interleaving-string/description//*/
    @Test
    void test_3() {

        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        InterleavingString testILS = new InterleavingString(s1,s2,s3);
        assertEquals(false,testILS.solution());
    }
}