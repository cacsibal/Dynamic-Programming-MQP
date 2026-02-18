package org.dp.oneSequence;

import org.dp.ITopDown;

import java.util.Arrays;

public class HouseRobber implements ITopDown {

    int[] array;

    int[] dp;

    public HouseRobber(int[] array){
        this.array = array;
    }

    public int solution(){
        return solution_topdown();
    }

    public int solution_topdown() {
        /**
         * Initialization
         */
        int n = array.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0);
    }

    /**
     * iterative solution
     */

    private int helper(int i) {
        // Base case: no more houses
        int return_value;
        if (i < array.length) {

            if (dp[i] != -1) {
                return_value = dp[i];
            } else {

                int robCurrent = array[i] + helper(i + 2);

                int skipCurrent = helper(i + 1);

                dp[i] = Math.max(robCurrent, skipCurrent);
                /**
                 * return maximum amount of money robbed
                 */
                return_value = dp[i];
            }
        } else {
            return_value =  0;
        }

        return return_value;
    }
}
