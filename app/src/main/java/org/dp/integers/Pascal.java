package org.dp.integers;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

import java.util.HashMap;

/**
 * Name: Pascal's Triangle Computation
 * 
 * Description:
 * 
 *   Given an integer row and column, compute the value at that position in Pascal's Triangle.
 * 
 * Problem Decomposition:
 * 
 *    P(r,c) = 1 for c = 0 and 0 <= r <= ri
 *    P(r,c) = 0 for r = 0 and 0 < c <= ci
 *    P(r,c) = P(r-1,c-1) + P(r-1,c) otherwise
 * 
 * Input Type: Pair of integers (row, column)
 * Output Type: integer
 * Solution Type: integer
 *   -- just the value at that position
 *
 *  dynprog solution:
 *  pasc <- {
 *      P[n,1] <- 1
 *      P[1,m] <- 0
 *      P[n,m] <- P[n-1,m-1] + P[n-1,m]
 *  } %where% {
 *      n <- 1:20
 *      m <- 1:20
 *  }
 *
 */
public class Pascal implements ITopDown, IBottomUp, IRetrieveSolution {

    int r;
    int c;

    HashMap<Integer,Integer> memo = new HashMap<>();

    public Pascal(int r, int c) {
        this.r = r;
        this.c = c;
    }

    /** Cantor pairing function with two integer parameters */
    int key(int i, int j) {
      return (i+j)*(i+j+1)/2 + i;
    }

    public int solution() {
        return solution_topdown();  // choose one
    }

    public int solution_topdown() { 
        decision = helper_topdown(r, c);     // Store decision for consistency with other DP problems
        return decision;
    }

    int helper_topdown(int ri, int ci)  {
        /** Base Cases. */
        if (ci == 0) { return 1; }
        if (ri == 0) { return 0; }

        /** Applied memoization */
        int key = key(ri, ci);
        
        // P(r,c) = 1 for c = 0 and 0 <= r <= ri
        // P(r,c) = 0 for r = 0 and 0 < c <= ci
        // P(r,c) = P(r-1,c-1) + P(r-1,c) otherwise

        if(!memo.containsKey(key)) {
            int result = helper_topdown(ri-1,ci-1) + helper_topdown(ri-1,ci);
            memo.put(key, result);
        }

        return memo.get(key);
    }

    public int solution_bottomup() {
        // dp[i][j] = element at position j in row i of pascal's triangle for (i >= 0 & 0 <= j <= j)
        int[][] dp = new int[r+1][c+1];

        /** Base Cases. Need to have this to simplify.  */
        for (int i=0; i <= r; i++) {
            dp[i][0] = 1;  // P(r,0) = 1
        }

        for (int i=1; i <= c; i++) {
            dp[0][i] = 0;  // P(0,c) = 0          // not strictly needed since defaults
        }

        /** Fill DP Table. NOTE: Fills dp table ONLY up to c. */
        for (int i=1; i <= r; i++) {
            for (int j=1; j <= c; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        decision = dp[r][c];  // Store decision for consistency with other DP problems
        return dp[r][c];
    }

    // Retrieve Solution
    // There is no "solution" in traditional sense, since computation is same each time, like Fibonacci.
    int decision;
    public int retrieve() {
        // Place holder for consistency with other DP problems
        return decision;
    }
}
