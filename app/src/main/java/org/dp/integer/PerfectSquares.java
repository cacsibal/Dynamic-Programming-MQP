package org.dp.integer;

/**
 * Name: Perfect Squares
 * Description:
 * 
 *    Given a positive integer n, find the least number of perfect square numbers
 *   (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Problem Decomposition:
 * 
 *    P(n) = Min (i, P(n - j*j) for ("j=1", "j*j <= n"; "j++")
 *    P(0) = 0
 * 
 * Input Type: integer
 * Output Type: integer
 * Solution Type: Array<Integer>
 * 
 */
class PerfectSquares {

    int n;

    public PerfectSquares(int n) {
        this.n = n;
    }

    /** Choose which to use: bottom-up or top-down */
    public int solution() {
        return solution_topdown();
    }

    public int solution_bottomup() {
        int[] dp = new int[n+1];    // to simplify stored results
        for (int i = 0; i <= n; i++) {
            dp[i] = i;    // can always just add 1 a total of i times
        }

        // ComputationStep("i", 1, "i <= n", "i + 1")
        Integer i;
        for (i = 1; i <= n; i++) {
            // ComputationStep("j", 1, "j*j <= i", "j + 1")
            Integer j;

            // Since these are all smaller than P(i) this means have to solve in order i from 1..n
            // P(i) = Min (i, P(i - j*j) for ("j=1", "j*j <= i"; "j++") 
            for (j = 1; j*j <= i; j++) {

                // SubProblem("dp[i]", MinExpression("dp[i]", "1 + dp[i - j*j]"))
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        return dp[n];  // Answer("dp[n]")
    }

    public int solution_topdown () {
       solution = new int[n+1];
       int res = helper (n);
       return res;
    }

    // How to come up with abstraction that works for Bottomup (above) and top-down (below)?
    public int helper (int n) {
       // aren't technically needed
       //if (n == 0) { return 0; }
       //if (n == 1) { return 1; }

       // P(i) = Min (i, P(i - j*j) for ("j=1", "j*j <= i"; "j++") 
       int best = n;
       for (int i = 1; i*i <= n; i++) {
         if (n - i*i >= 0) {
            solution[n] = n-i*i;
            best = Math.min(best, 1 + helper(n - i*i));
         }
       }
       
       return best;
    }

    // Needed to retrieve solution
    // ================================================================================
    //  solution[n] = fewest number of perfect squares summing to n
    int[] solution;
    
    // Retrieve solution based on recursive traversal of decision points
    Integer[] retrieve() { 
       java.util.ArrayList<Integer> result = new java.util.ArrayList<>();
       int k = n;
       while (k > 0) {
         if (solution[k] == 0) { result.add(k); }
         else { result.add(k-solution[k]); }
         k = solution[k];
       }

       java.util.Collections.sort(result);
       // convert ,-separated string into array of INteger
       return result.toArray(new Integer[]{});
    }

}
