package org.dp.topDown;
import java.util.HashMap;

public class TwoKeysKeyboard {

    /**
     * Create Cache
     */
    HashMap<Integer,Integer> memo = new HashMap<>();

    public int solution(int n) {
        if(n==1){
            return 0;
        }
        return 1+helper(1,1,n);

    }
    public int helper(int i, int j, int n){
        if(i==n){
            return 0;
        }
        if(i>n){
            return Integer.MAX_VALUE/2;
        }
        int key = i*i+j;
        if(!memo.containsKey(key))
            memo.put(key, Math.min(2+helper(2*i,i,n),1+helper(i+j,j,n)));
        return memo.get(key);
    }
}
