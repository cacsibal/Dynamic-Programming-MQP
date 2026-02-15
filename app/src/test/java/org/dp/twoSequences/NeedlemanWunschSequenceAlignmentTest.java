package org.dp.twoSequences;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeedlemanWunschSequenceAlignmentTest {
    /**
     * https://en.wikipedia.org/wiki/Needleman–Wunsch_algorithm
     */
    @Test void test1() {
        NeedlemanWunschSequenceAlignment testNWSA = new NeedlemanWunschSequenceAlignment("GCATG-CG", "G-ATTACA", 1, -1, -1);

        assertEquals(0, testNWSA.solution());
    }

    /**
     * https://bioboot.github.io/bimm143_W20/class-material/nw/
     */
    @Test void test2() {
        NeedlemanWunschSequenceAlignment testNWSA = new NeedlemanWunschSequenceAlignment("GATTACA", "GTCGACGCA", 1, -1, -2);

        assertEquals(-3, testNWSA.solution());
    }

    /**
     *
     */
    @Test void test3() {
        NeedlemanWunschSequenceAlignment testNWSA = new NeedlemanWunschSequenceAlignment("AATCG", "AACG", 1, -1, -2);

        assertEquals(2, testNWSA.solution());
    }
}