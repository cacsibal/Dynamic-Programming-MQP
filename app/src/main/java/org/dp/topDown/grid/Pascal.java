package org.dp.topDown.grid;

import java.util.HashMap;

public class Pascal {

    /**
     * Create Cache
     */
    private HashMap<Integer[], Integer> memo = new HashMap<>();


    public int solution(int r, int c) {

        /**
         * Base Case
         */
        if (c == 0)
            return 1;
        if (r == 0)
            return 0;

        /**
         * Memoize
         */
        Integer[] key = {r, c};
        if (!memo.containsKey(key)) {
            memo.put(key, solution(r - 1, c - 1) + solution(r - 1, c));
        }

        return memo.get(key);
    }
}
