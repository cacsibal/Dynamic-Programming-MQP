package org.dp.graph;

import org.dp.IBottomUp;
import org.dp.ITopDown;

import java.util.HashMap;

/**
 * Name Maximal independent set from a give Graph
 * Description:
 *Given an undirected graph with V vertices and E edges,
 * the task is to print all the independent sets and also find the maximal independent set
 */

public class MaximalIndependentSetPath implements IBottomUp, ITopDown {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();


    int[] path;
    public MaximalIndependentSetPath(int[] path){
        this.path=path;
    }


    public int solution_topdown(){
        return helper_topdown(0);
    }

    public int helper_topdown(int i){
        if(i>=path.length){
            return 0;
        }
        if(!memo.containsKey(i)) {
            memo.put(i,Math.max(path[i] + helper_topdown(i + 2), helper_topdown(i + 1)));
        }
        return memo.get(i);
    }

    public int helper_bottomup() {
        if(path.length == 0) return 0;
        if(path.length == 1) return path[0];

        int[] dp = new int[path.length];
        dp[0] = path[0];
        dp[1] = Math.max(path[0], path[1]);

        for(int i = 2; i < path.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + path[i]);
        }

        return dp[path.length - 1];
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution(){
        return solution_bottomup();
    }
}
