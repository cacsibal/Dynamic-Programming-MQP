package org.dp.topDown.oneSequence;

public class JumpTwo {

    static int retrieveMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max+1;
    }

    static int helper(int i, int[] arr) {
        int ans = 0;
            if (i < arr.length - 1){
                ans = retrieveMax(arr);
                for (int j = i + 1; j <= i + arr[i]; j++) {
                    int val = helper(j, arr);
                    if (val != retrieveMax(arr) && 1+val < ans) {
                        ans = val+1;
                    }
                }
            }
            return ans;
        }
/*
    public int minJumpsRecur(int i, int[] arr) {

        // Return 0 when last element is reached.
        if (i >= arr.length - 1)
            return 0;

        // Traverse through all the points
        // reachable from arr[i].
        // Recursively, get the minimum number
        // of jumps needed to reach array end from
        // these points.
        int ans = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + arr[i]; j++) {
            int val = minJumpsRecur(j, arr);
            if (val != Integer.MAX_VALUE)
                ans = Math.min(ans, 1 + val);
        }

        return ans;
    }
 */

    public int minJump_NoForLoop(int[] arr, int i) {

        if(i>= arr.length-1) return 0;

        return loopHelper(arr, i, i+1);

    }

    public int loopHelper(int[] arr, int i, int j) {

        // If j goes beyond reachable range, stop searching
        if (j > i + arr[i])
            return Integer.MAX_VALUE;

        // Compute jumps from position j
        int val = minJump_NoForLoop(arr, j);

        int best = Integer.MAX_VALUE;
        if (val != Integer.MAX_VALUE)
            best = 1 + val;

        // Try next jump position (j + 1)
        int next = loopHelper(arr, i, j + 1);

        return Math.min(best, next);
    }

        public int solution(int[] arr) {

            int ans = helper(0, arr);

            // If end cannot be reached.
            if (ans == retrieveMax(arr))
                return -1;

            return ans;
        }

    public int solutiontwo(int[] arr) {

        int result = minJump_NoForLoop(arr, 0);

        // If end cannot be reached.
        if (result == Integer.MAX_VALUE)
            return -1;

        return result;
    }
}
