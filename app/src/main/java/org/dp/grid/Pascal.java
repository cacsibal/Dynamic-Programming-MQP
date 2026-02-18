package org.dp.grid;

import org.dp.ITopDown;

import java.util.HashMap;
/**
 *  Pascal: Returns the number in pascal's triangle at row r and column c
 *
 *  dynprog solution:
 *  pasc <- {
 *      P[n,1] <- 1
 *      P[1,m] <- 0
 *      P[n,m] <- P[n-1,m-1] + P[n-1,m]
 *  } %where% {
 *      n <- 1:20
 *      m <- 1:20
 *  }
 *
 */
public class Pascal implements ITopDown {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();

    int r;
    int c;

    public Pascal(int r, int c){
        this.r=r;
        this.c=c;
    }


    public int solution_topdown(){
        return helper_topdown(r,c);
    }

    public int helper_topdown(int r, int c) {

        /**
         * Base Case
         */
        if(c==0)
            return 1;
        if(r==0)
            return 0;

        /**
         * Memoize
         */
        int s=r+c;
        Integer key = (s*(s+1))/2+r;
        if(!memo.containsKey(key)){
            memo.put(key,helper_topdown(r-1,c-1)+helper_topdown(r-1,c));
        }

        return memo.get(key);
    }

    public int solution(){
        return solution_topdown();
    }
}
