package org.dp.topDown.knapsack;
import java.util.HashMap;

public class TwoKeysKeyboard {

    /**
     * Create Cache
     */
    HashMap<Integer,Integer> memo = new HashMap<>();

    int n;
    public TwoKeysKeyboard(int n){
        this.n=n;
    }

    public int solution() {
        if(n==1){
            return 0;
        }
        return 1+helper(1,1);

    }
    public int helper(int i, int j){
        if(i==n){
            return 0;
        }
        if(i>n){
            return Integer.MAX_VALUE/2;
        }
        int key = i*i+j;
        if(!memo.containsKey(key))
            memo.put(key, Math.min(2+helper(2*i,i),1+helper(i+j,j)));
        return memo.get(key);
    }
}
