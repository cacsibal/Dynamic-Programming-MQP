package org.dp.oneSequence;
import org.dp.IBottomUp;
import org.dp.ITopDown;

import java.util.HashMap;
import java.util.Arrays;

/**
 * Name: Coin Change
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
class CoinChange implements ITopDown, IBottomUp {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();
    int[] coins;
    int amount;
    public CoinChange(int[] coins, int amount){
        this.coins=coins;
        this.amount=amount;
    }



    public int solution_topdown() {
        int result= helper_topdown(0,amount);
        if(result>amount){
            return -1;
        }
        return result;
    }
    public int helper_topdown(int i, int amount){

        int key = (amount+i)*(amount+i+1)/2+i;

        if(!memo.containsKey(key)){
            if(amount==0){
                memo.put(key,0);
            }
            else if(i==coins.length){
                memo.put(key, Integer.MAX_VALUE/2);
            }
            else if(coins[i]>amount){
                memo.put(key, helper_topdown(i+1, amount));
            }
            else{
                memo.put(key,Math.min(helper_topdown(i,amount-coins[i])+1, helper_topdown(i+1,amount)));
            }
        }
        return memo.get(key);

    }

    public int helper_bottomup() {
        int[] dp = new int[amount + 1];

        // Initialize with a large value
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution(){
        return solution_bottomup();
    }
}