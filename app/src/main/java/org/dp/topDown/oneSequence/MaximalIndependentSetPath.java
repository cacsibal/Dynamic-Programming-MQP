package org.dp.topDown.oneSequence;

import java.util.HashMap;

public class MaximalIndependentSetPath {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();


    int[] path;
    public MaximalIndependentSetPath(int[] path){
        this.path=path;
    }


    public int solution(){
        return helper(0);
    }
    public int helper(int i){
        if(i>=path.length){
            return 0;
        }
        if(!memo.containsKey(i)) {
            memo.put(i,Math.max(path[i] + helper(i + 2), helper(i + 1)));
        }
        return memo.get(i);
    }
}
