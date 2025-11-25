package org.dp.topDown.oneSequence;

public class EggDrop {
    // Function to find minimum number of attempts
    // needed in order to find the critical floor
    public int solution(int n, int k) {

        /**
         * Initialization
         */
        if (k == 1 || k == 0)
            return k;

        if (n == 1)
            return k;

        int res = Integer.MAX_VALUE;

        /**
         * Iterative solution
         */
        for (int i = 1; i <= k; i++) {
            int cur = 1 + Math.max(solution(n - 1, i - 1), solution(n, k - i));
            if (cur < res)
                res = cur;
        }
        /**
         * return the minimum number of attempts
         */
        return res;
    }
}
