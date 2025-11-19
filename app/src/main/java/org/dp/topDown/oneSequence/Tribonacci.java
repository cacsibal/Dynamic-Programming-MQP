package org.dp.topDown.oneSequence;

import java.util.HashMap;

public class Tribonacci {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (!memo.containsKey(n)) {
            memo.put(n, solution(n - 1) + solution(n - 2) + solution(n - 3));
        }

        return memo.get(n);
    }
}
