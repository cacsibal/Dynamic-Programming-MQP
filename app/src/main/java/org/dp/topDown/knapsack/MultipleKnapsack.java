package org.dp.topDown.knapsack;

import java.util.HashMap;

public class MultipleKnapsack {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    int[] W;
    int[] weights;
    int[] values;

    MultipleKnapsack(int[] W, int[] weights, int[] values){
        this.W=W;
        this.weights=weights;
        this.values=values;
    }


    public int solution(){
        return helper(weights.length-1, W);
    }

    public int helper(int i, int[] W){
        //Base Case
        if(i==-1 ){
            return 0;
        }
        for(int j=0;j<W.length;j++){
            if(W[j]!=0){
                break;
            }
            if(j==W.length-1){
                return 0;
            }
        }

        //Get Key
        Integer key = pair(new int[]{pair(W), i});

        //Recurse
        if(!memo.containsKey(key)){
            int result = helper(i-1,W);
            for(int j=0;j<W.length;j++){
                if(weights[i]>W[j]){
                    continue;
                }
                W[j]-=weights[i];
                result=Math.max(result, (values[i]+helper(i-1,W)));
                W[j]+=weights[i];
            }
            memo.put(key,
                    result
            );
        }

        return memo.get(key);
    }

    public int pair(int[] arr){
        int result=arr[0];
        for(int i=1;i<arr.length;i++){
            result=(result+arr[i])*(result+arr[i]+1)/2+result;
        }
        return result;
    }
}
