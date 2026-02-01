package org.dp.topDown.grid;

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
public class Pascal {

    /**
     * Create Cache
     */
    private HashMap<Integer,Integer> memo = new HashMap<>();


    public int solution(int r, int c) {

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
            memo.put(key,solution(r-1,c-1)+solution(r-1,c));
        }

        return memo.get(key);
    }
}
