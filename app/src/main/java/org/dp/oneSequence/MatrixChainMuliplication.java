package org.dp.oneSequence;

import java.util.*;

/**
 * Name: Matrix Chain Multiplication
 * Description:
 * 
 *   Given an array of integers A[] which represents the dimensions of matrices, compute the most
 *   efficient way to multiply these matrices together.
 * 
 *   The input is an array of N+1 integers that represents N matrices such that the ith matrix has
 *   dimensions A[i-1] x A[i]. The output is the minimum number of scalar multiplications needed
 * 
 * Problem Decomposition:
 * 
 *    P(i,j) = Min (k, P(i,k) + P(k+1,j) + cost of multiplying resulting two matrices) for (int k = i; k < j; k++) {
 *    P(i,i) = 0
 * 
 * Input Type: Array<Integer> of N+1 values representing N matrices
 * Output Type: integer
 * Solution Type: String (parenthesization)
 * 
 */
class MatrixChainMultiplication {

    int[] A;
   
    public MatrixChainMultiplication(int A[]) {
       this.A = A;
    }

    /** Cantor pairing function with two integer parameters */
    int key(int i, int j) {
      return (i+j)*(i+j+1)/2 + i;
    }

    public int solution() {
        return solution_topdown();  
    }

    public int solution_bottomup() {
        int n = A.length - 1; // Number of matrices
        
        // dp[i][j] stores the minimum cost of multiplying matrices from i to j.
        // Cost is 0 when multiplying one matrix. Diagonal elements are 0 by default.
        int[][] dp = new int[n + 1][n + 1];

        // P(i,j) = Min (k, P(i,k) + P(k+1,j) + cost of multiplying resulting two matrices) for (int k = i; k < j; k++) 
        // P(i,i) = 0

        // not sure how the above translates into the code below!

        for (int c = 2; c <= n; c++) {                // these are the chain lengths BUT ALSO could be column
          for (int r = 1; r <= n - c + 1; r++) {      // these are the row starts
            int i = r;
            int j = r + c - 1;                        // MAPPING into (i,j) problem
            
            dp[i][j] = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
              int cost = dp[i][k] + dp[k + 1][j] + A[i - 1] * A[k] * A[j];
              if (cost < dp[i][j]) {
                dp[i][j] = cost;
                decision.put(key(i,j), k);
              }
            }
          }
        }
        
      //   // L is chain length.
      //   for (int L = 2; L <= n; L++) {
      //       for (int i = 1; i <= n - L + 1; i++) {
      //           int j = i + L - 1;                         // Ending index
      //           System.out.println(i + "," + j);
      //           dp[i][j] = Integer.MAX_VALUE;              // Initialize with infinity
      //           for (int k = i; k < j; k++) {
      //               // Cost = dp[i][k] + dp[k+1][j] + dims[i-1] * dims[k] * dims[j]
      //               int cost = dp[i][k] + dp[k + 1][j] + A[i - 1] * A[k] * A[j];
      //               if (cost < dp[i][j]) {
      //                   dp[i][j] = cost;
      //                   decision.put(key(i,j), k);
      //               }
      //           }
      //       }
      //   }

        return dp[1][n];
    }

    public int solution_topdown() {
       // start at index 1 since A[0..1] is first matrix
       return helper(1, A.length-1);  
    }
    
    int helper (int i, int j) {
      if (i == j) { return 0; }

      int min = Integer.MAX_VALUE;  // could store in array and find min but then req extra storage
      for (int k = i; k < j; k++) {
          // compute cost of each possible starting point for a '(' between i and j-1 with a ')' at j
          int count = helper(i, k) + helper(k+1, j) + A[i-1] * A[k] * A[j];

          if (count < min) { min = count; decision.put(key(i,j), k); }
        }

        // Return minimum count
        return min;
    }

    // Retrieve Solution
    // =======================================================
    HashMap<Integer,Integer> decision = new HashMap<>();              // consistent storage for all decisions

    // Retrieve solution based on recursive traversal of decision points
    public String retrieve() {
       return expand(1, A.length-1);   // start at index 1 since A[0..1] is first matrix
    }

    /** Recursive function to retrieve solution. */
    String expand(int i, int j) {
       if (i == j) { return ""; }        // BASE CASE SOLUTION
       int key_idx = key(i, j);
       int k = decision.get(key_idx);
       String left = expand(i,k);
       String right = expand(k+1,j);
       
       return "(" + left + ")" + "(" + right + ")";   // Gives "(()(()()))()" as solution

       // each solution representation by definition is domain-specific. The following
       // code *could* be generated but hard to see how
       //
       // THIS is the ideal but hard to generate. Gives "(A_1(A_2A_3))A_4" as solution
       //// String result = "";
       //// if (left.length()>0) { 
       ////   result = "(" + left + ")";
       //// } else { result = "A_" + i; }

       //// if (right.length()>0) {
       ////   result += "(" + right + ")";
       //// } else {
       ////   result += "A_" + j;
       //// }
       //// return result;
    }

}