package org.dp.topDown.grid;
import java.util.Arrays;

public class DiceThrow {
    static int helper(int m, int n, int x, int[][] memo) {

        // Base case: Valid combination
        /**
         * initialization
         */
        if (n == 0 && x == 0) return 1;

        // Base case: Invalid combination
        if (n == 0 || x <= 0) return 0;

        // If value is memoized
        if (memo[n][x] != -1) return memo[n][x];

        int ans = 0;

        /**
         * iterative
         */
        for (int i = 1; i <= m; i++) {
            ans += helper(m, n - 1, x - i, memo);
        }

        return memo[n][x] = ans;
    }

    public int solution(int m, int n, int x) {

        int[][] memo = new int[n + 1][x + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        return helper(m, n, x, memo);
    }
}
