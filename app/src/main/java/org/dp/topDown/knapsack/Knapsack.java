package org.dp.topDown.knapsack;

import java.util.HashMap;

public class Knapsack {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    int[] weights;
    int[] values;
    int W;
    public Knapsack(int W, int[] weights, int[] values){
        this.W=W;
        this.weights=weights;
        this.values=values;
    }

    public int solution(){
        return helper(weights.length-1, W);
    }
    public int helper(int i, int W){
        if(i==-1 || W==0){
            return 0;
        }
        Integer key = (W+i)*(W+i+1)/2+i;
        if(!memo.containsKey(key)){
            memo.put(key,
                    Math.max(
                            helper(i-1,W),
                        weights[i]<=W?(values[i]+helper(i-1,W-weights[i])):0
                    )
            );
        }

        return memo.get(key);
    }
}
