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
 *    P(i,j) = Min (k, P(i,k) + P(k+1,j) + cost of multiplying resulting two matrices)
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
    static int key(int i, int j) {
      return (i+j)*(i+j+1)/2 + i;
    }

    public int solution() {
        return solution_topdown();  
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