package org.dp.oneSequence;
public class coinChange {

    static long solution(long N, long[] Coins)
    {
        /**
         * initialization
         */
        long[] ways = new long[(int)N + 1];

        ways[0] = 1;

        /**
         * iterative solution
         */
        for (int i = 0; i < Coins.length; i++) {

            for (int j = 0; j < ways.length; j++) {
                if (Coins[i] <= j) {
                    ways[j] += ways[(int)(j - Coins[i])];
                }
            }
        }
        /**
         * return solution
         */
        return ways[(int)N];
    }
}