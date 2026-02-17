package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.ITopDown;

/**
 * Name: Count Numbers With Unique Digits
 * Description:
 * Given an integer n, return how many x that is between 0 to 10^n and all digits are unique
 */
public class CountNumbersWithUniqueDigits implements ITopDown, IBottomUp {


    int n;
    public CountNumbersWithUniqueDigits(int n){
        this.n=n;
    }

    public int solution_topdown(){
        return helper_topdown(n);
    }


    /**
     * Recursive solution
     */
    public int helper_topdown(int n) {
        if(n==0){
            return 1;
        }
        int p = 9;
        for(int i=1;i<n;i++){
            p=p*(10-i);
        }
        return p+helper_topdown(n-1);
    }

    public int helper_bottomup() {

        if (n == 0) return 1;

        // n cannot exceed 10 (only 10 digits exist)
        if (n > 10) n = 10;

        int[] dp = new int[n + 1];

        dp[0] = 1;   // only "0"
        dp[1] = 10;  // 0–9

        int uniqueDigits = 9;
        int available = 9;

        for (int i = 2; i <= n; i++) {
            uniqueDigits *= available;
            dp[i] = dp[i - 1] + uniqueDigits;
            available--;
        }

        return dp[n];
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution(){
        return solution_bottomup();
    }
}
