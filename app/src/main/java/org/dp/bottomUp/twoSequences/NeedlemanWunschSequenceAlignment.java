package org.dp.bottomUp.twoSequences;

/**
 * <a href=https://en.wikipedia.org/wiki/Sequence_alignment>Needleman-Wunsch Sequence Alignment:</a> a DP algorithm
 *  used in bioinformatics to align protein and nucleotide sequences.
 *  <a href=https://en.wikipedia.org/wiki/Sequence_alignment>Sequence Alignment</a> is a way of arranging such sequences to
 *  identify areas of similarity to find potential relationships between the sequences. In Needleman-Wunsch,
 *  aligned nucleotide sequence residues are represented as rows of a matrix, and gaps are inserted between them so that similar
 *  characters are aligned column-wise.
 */
public class NeedlemanWunschSequenceAlignment {
    public int solution(String s1, String s2, int match, int mismatch, int gap) {
        /**
         * Initialization
         */
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int r = 0; r <= len1; r++) {
            dp[r][0] = r * gap;
        }

        for(int c = 0; c <= len2; c++) {
            dp[0][c] = c * gap;
        }

        /**
         * Optimization through iteration
         */
        for(int r = 1; r <= len1; r++) {
            for(int c = 1; c <= len2; c++) {
                int score = (s1.charAt(r - 1) == s2.charAt(c - 1) ? match : mismatch);

                dp[r][c] = Math.max(
                        dp[r - 1][c - 1] + score,
                        Math.max(dp[r - 1][c], dp[r][c - 1])
                );
            }
        }

        /**
         * return the last element
         */
        return dp[len1][len2];
    }
}
