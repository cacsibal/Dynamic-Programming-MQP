package org.dp.topDown.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeedlemanWunschSequenceAlignmentTest {
    /**
     * https://en.wikipedia.org/wiki/Needleman–Wunsch_algorithm
     */
    @Test void test1() {
        NeedlemanWunschSequenceAlignment testNWSA = new NeedlemanWunschSequenceAlignment();

        assertEquals(0, testNWSA.solution("GCATG-CG", "G-ATTACA", 1, -1, -1));
    }

    /**
     * https://bioboot.github.io/bimm143_W20/class-material/nw/
     */
    @Test void test2() {
        NeedlemanWunschSequenceAlignment testNWSA = new NeedlemanWunschSequenceAlignment();

        assertEquals(-3, testNWSA.solution("GATTACA", "GTCGACGCA", 1, -1, -2));
    }

    /**
     *
     */
    @Test void test3() {
        NeedlemanWunschSequenceAlignment testNWSA = new NeedlemanWunschSequenceAlignment();

        assertEquals(2, testNWSA.solution("AATCG", "AACG", 1, -1, -2));
    }
}