package org.dp.topDown;

import java.util.HashMap;

public class Pascal {

    /**
     * Create Cache
     */
    private HashMap<Integer[],Integer> memo = new HashMap<>();


    public int pascal(int r, int c) {

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
        Integer[] key = {r,c};
        if(!memo.containsKey(key)){
            memo.put(key,pascal(r-1,c-1)+pascal(r-1,c));
        }

        return memo.get(key);
    }
}
