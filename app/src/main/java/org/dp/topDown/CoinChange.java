package org.dp.topDown;
import java.util.HashMap;

class CoinChange {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    public int solution(int[] coins, int amount) {
        int result= helper(0,coins,amount);
        if(result>amount){
            return -1;
        }
        return result;
    }
    public int helper(int i, int[] coins, int amount){

        int key = (amount+i)*(amount+i+1)/2+i;

        if(!memo.containsKey(key)){
            if(amount==0){
                memo.put(key,0);
            }
            else if(i==coins.length){
                memo.put(key, Integer.MAX_VALUE/2);
            }
            else if(coins[i]>amount){
                memo.put(key, helper(i+1, coins, amount));
            }
            else{
                memo.put(key,Math.min(helper(i,coins,amount-coins[i])+1, helper(i+1,coins,amount)));
            }
        }
        return memo.get(key);

    }
}