package org.dp.knapsack;

import java.util.HashMap;

public class DoubleKnapsack {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    public int solution(int W1,int W2, int[] weights, int[] values){
        return solutionR(weights.length-1, W1, W2, weights,values);
    }

    public int solutionR(int i, int W1,int W2, int[] weights, int[] values){
        if(i==-1 || (W1==0&&W2==0)){
            return 0;
        }
        Integer key1 = (W1+i)*(W1+i+1)/2+i;
        Integer key = (W2+key1)*(W2+key1+1)/2+key1;
        if(!memo.containsKey(key)){
            memo.put(key,
                    Math.max(
                        solutionR(i-1,W1,W2, weights, values),
                        Math.max(
                            weights[i]<=W1?(values[i]+solutionR(i-1,W1-weights[i],W2,weights,values)):0,
                            weights[i]<=W2?(values[i]+solutionR(i-1,W1,W2-weights[i],weights,values)):0
                        )
                    )
            );
        }

        return memo.get(key);
    }
}
