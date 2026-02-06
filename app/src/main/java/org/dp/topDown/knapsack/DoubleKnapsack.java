package org.dp.topDown.knapsack;

import java.util.HashMap;

public class DoubleKnapsack {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    int W1;
    int W2;
    int[] weights;
    int[] values;

    DoubleKnapsack(int W1,int W2, int[] weights, int[] values){
        this.W1=W1;
        this.W2=W2;
        this.weights=weights;
        this.values=values;
    }

    public int solution(){
        return helper(weights.length-1, W1, W2);
    }

    public int helper(int i, int W1,int W2){
        if(i==-1 || (W1==0&&W2==0)){
            return 0;
        }
        Integer key1 = (W1+i)*(W1+i+1)/2+i;
        Integer key = (W2+key1)*(W2+key1+1)/2+key1;
        if(!memo.containsKey(key)){
            memo.put(key,
                    Math.max(
                            helper(i-1,W1,W2),
                        Math.max(
                            weights[i]<=W1?(values[i]+helper(i-1,W1-weights[i],W2)):0,
                            weights[i]<=W2?(values[i]+helper(i-1,W1,W2-weights[i])):0
                        )
                    )
            );
        }

        return memo.get(key);
    }
}
