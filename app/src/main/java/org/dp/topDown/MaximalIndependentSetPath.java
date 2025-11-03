package org.dp.topDown;

import java.util.HashMap;

public class MaximalIndependentSetPath {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    public int solution(int[] path){
        return helper(0,path);
    }
    public int helper(int i, int[] path){
        if(i>=path.length){
            return 0;
        }
        if(!memo.containsKey(i)) {
            memo.put(i,Math.max(path[i] + helper(i + 2, path), helper(i + 1, path)));
        }
        return memo.get(i);
    }
}
