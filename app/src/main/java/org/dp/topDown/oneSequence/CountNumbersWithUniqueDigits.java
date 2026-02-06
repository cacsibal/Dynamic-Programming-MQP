package org.dp.topDown.oneSequence;

public class CountNumbersWithUniqueDigits {


    int n;
    public CountNumbersWithUniqueDigits(int n){
        this.n=n;
    }

    public int solution(){
        return helper(n);
    }


    /**
     * Recursive solution
     */
    public int helper(int n) {
        if(n==0){
            return 1;
        }
        int p = 9;
        for(int i=1;i<n;i++){
            p=p*(10-i);
        }
        return p+helper(n-1);
    }
}
