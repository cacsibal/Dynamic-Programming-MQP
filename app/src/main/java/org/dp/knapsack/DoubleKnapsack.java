package org.dp.knapsack;

import org.dp.ITopDown;

import java.util.HashMap;

/**
 * Name: Double Knapsack
 * Description:
 * Given an array arr[] containing the weight of 'n' distinct items,
 * and two knapsacks that can withstand capactiy1 and capacity2 weights,
 * the task is to find the sum of the largest subset of the array 'arr',
 * that can be fit in the two knapsacks. It's not allowed to break any items
 * in two, i.e. an item should be put in one of the bags as a whole.
 */

public class DoubleKnapsack implements ITopDown {

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

    public int solution_topdown(){
        return helper_topdown(weights.length-1, W1, W2);
    }

    public int helper_topdown(int i, int W1,int W2){
        if(i==-1 || (W1==0&&W2==0)){
            return 0;
        }
        Integer key1 = (W1+i)*(W1+i+1)/2+i;
        Integer key = (W2+key1)*(W2+key1+1)/2+key1;
        if(!memo.containsKey(key)){
            memo.put(key,
                    Math.max(
                            helper_topdown(i-1,W1,W2),
                        Math.max(
                            weights[i]<=W1?(values[i]+helper_topdown(i-1,W1-weights[i],W2)):0,
                            weights[i]<=W2?(values[i]+helper_topdown(i-1,W1,W2-weights[i])):0
                        )
                    )
            );
        }

        return memo.get(key);
    }

    public int solution(){
        return solution_topdown();
    }
}
