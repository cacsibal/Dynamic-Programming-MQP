package org.dp.topDown.oneSequence;
public class editDistance {

    // Recursive function to find number of operations
    // needed to convert s1 into s2.
    static int editDistRec(String s1, String s2, int m, int n) {
        /**
         * initialization
         */
        if (m == 0) return n;

        if (n == 0) return m;

        /**
         * iterative solution
         */
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistRec(s1, s2, m - 1, n - 1);

        return 1 + Math.min(
                Math.min(editDistRec(s1, s2, m, n - 1),
                        editDistRec(s1, s2, m - 1, n)),
                editDistRec(s1, s2, m - 1, n - 1));
    }

    // Wrapper function to initiate the recursive calculation
    public int solution(String s1, String s2) {
        return editDistRec(s1, s2, s1.length(), s2.length());
    }
}
