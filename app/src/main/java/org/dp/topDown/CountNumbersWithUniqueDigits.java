package org.dp.topDown;

public class CountNumbersWithUniqueDigits {
    public int solution(int n) {
        if(n==0){
            return 1;
        }
        int p = 9;
        for(int i=1;i<n;i++){
            p=p*(10-i);
        }
        return p+solution(n-1);
    }
}
