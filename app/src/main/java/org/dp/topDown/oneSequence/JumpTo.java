package org.dp.topDown.oneSequence;
import java.util.Arrays;

public class JumpTo {

    static int retrieveMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max+1;
    }

    static int minJumpsRecur(int i, int[] arr) {
        int ans = 0;
            if (i < arr.length - 1){
                ans = retrieveMax(arr);
                for (int j = i + 1; j <= i + arr[i]; j++) {
                    int val = minJumpsRecur(j, arr);
                    if (val != retrieveMax(arr) && 1+val < ans) {
                        ans = val+1;
                    }
                }
            }
            return ans;
        }

        public int minJumps(int[] arr) {

            int ans = minJumpsRecur(0, arr);

            // If end cannot be reached.
            if (ans == retrieveMax(arr))
                return -1;

            return ans;
        }
}
