package org.dp.topDown.knapsack;

import java.util.HashMap;

public class Knapsack {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    public int solution(int W, int[] weights, int[] values){
        return solutionR(weights.length-1, W, weights,values);
    }
    public int solutionR(int i, int W, int[] weights, int[] values){
        if(i==-1 || W==0){
            return 0;
        }
        Integer key = (W+i)*(W+i+1)/2+i;
        if(!memo.containsKey(key)){
            memo.put(key,
                    Math.max(
                        solutionR(i-1,W, weights, values),
                        weights[i]<=W?(values[i]+solutionR(i-1,W-weights[i],weights,values)):0
                    )
            );
        }

        return memo.get(key);
    }
}
