package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 *  Name: Max Subarray
 * 
 *  Description:
 * 
 *   For a given array, find the largest possible sum of any subarray (continuous sequence of the array)
 * 
 *   Given an integer row and column, compute the value at that position in Pascal's Triangle.
 * 
 * Problem Decomposition:
 * 
 *    P(i,j) = nums[i] for i = j
 *    P(i,j) = max(P(i,j-1) + nums[j], nums[j])     ** still needs work...
 * 
 * Input Type: Integer Array
 * Output Type: integer
 * Solution Type: String  of the form "A[lo..hi]", where lo and hi are the indices of the subarray with the maximum sum
 
 *  dynprog solution:
 *  nums <- c(-2,1,-3,4,-1,2,1,-5,4)
 *
 *  maxsubarray <- max({
 *      M[1] <- nums[1]
 *      M[n] <- max(M[n-1]+nums[n],nums[n])
 *  }%where% {
 *      n <- 1:length(nums)
 *  })
 *
 */
class MaxSubarray implements IBottomUp, ITopDown, IRetrieveSolution{

    int[] nums;
    int computed_solution;
    int[] actual_solution = new int[2];  // lo and hi of the max subarray

    public MaxSubarray(int[] nums) {
        this.nums = nums;
    }

    public int optimized_bottomup() {
        int current = nums[0];
        int max = current;

        /** One-pass solution */
        for (int i = 1; i < nums.length; i++) {
            if (current < 0) {
                current = 0;
            }
            current += nums[i];
            max = Math.max(max, current);
        }

        return max;
    }

   public int solution_bottomup() {
        // dp[i][j] is the sum of the subarray from i to j, inclusive
        int[][] dp = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;

        // All values are initialized to 0, so order below works.

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                dp[i][j] = dp[i][j-1] + nums[j];
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    actual_solution[0] = i;
                    actual_solution[1] = j;
                }
            }
        }
        
        return max;
    }

    // returns sum from A[lo] .. A[hi], and records max_solution in the process
    private int helper(int lo, int hi) {
        int sum = nums[hi];
        
        if (lo == hi)  {
            if (nums[lo] > computed_solution) {
                computed_solution = nums[lo];
                actual_solution[0] = lo;
                actual_solution[1] = hi;
            }
            return nums[lo];
        }
            
        // do in reverse order so the LAST one returned is the sum lo..hi
        for (int i = hi-1; i >= lo; i--) {
            sum = helper(i, hi-1) + nums[hi];
            if (sum > computed_solution) {         // extend previous
                computed_solution = sum;
                actual_solution[0] = i;
                actual_solution[1] = hi;
            }
            if (nums[hi] > computed_solution) {    // start new
                computed_solution = nums[hi];
                actual_solution[0] = hi;
                actual_solution[1] = hi;
            }
        }

        return sum;
    }

 private int optimized_topdown(int i, int currentSum, int globalMax) {

        if (i == nums.length) {
            return globalMax;
        }

        // Choice: either extend previous subarray or start new at nums[i]
        // This looks backwards (in a way) to find max sum of subarray that ends at index i, 
        // but it is more efficient to pass the current sum as an argument than to recurse down to the
        // base case every time
        int newCurrent = Math.max(nums[i], currentSum + nums[i]);

        // Update global best
        int newGlobal = Math.max(globalMax, newCurrent);

        // Recurse to next index
        return optimized_topdown(i + 1, newCurrent, newGlobal);
    }

    public int solution_topdown() {
       computed_solution = Integer.MIN_VALUE;
       helper(0, nums.length-1);
       return computed_solution;
       //return optimized_topdown(0, 0, Integer.MIN_VALUE);
    }

    public int solution() {
        return solution_topdown();
    }

    // RETRIEVE ACTUAL SOLUTION
    public String retrieve() {
        // depends on being computed by either top-down or bottom up.
        return "A[" + actual_solution[0] + ".." + actual_solution[1] + "]";
    }
}