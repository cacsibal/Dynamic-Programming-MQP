package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterleavingStringTest {

    /** https://leetcode.com/problems/interleaving-string/description//*/
    @Test
    void test_1() {
        InterleavingString testILS = new InterleavingString();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        assertEquals(true,testILS.solution(s1,s2,s3));
    }

    /** https://leetcode.com/problems/interleaving-string/description//*/
    @Test
    void test_2() {
        InterleavingString testILS = new InterleavingString();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        assertEquals(false,testILS.solution(s1,s2,s3));
    }

    /** https://leetcode.com/problems/interleaving-string/description//*/
    @Test
    void test_3() {
        InterleavingString testILS = new InterleavingString();

        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        assertEquals(false,testILS.solution(s1,s2,s3));
    }
}