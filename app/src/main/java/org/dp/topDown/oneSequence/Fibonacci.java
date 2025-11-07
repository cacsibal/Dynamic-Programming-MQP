package org.dp.topDown.oneSequence;

import java.util.HashMap;

public class Fibonacci {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (!memo.containsKey(n)) {
            memo.put(n, solution(n - 1) + solution(n - 2));
        }
        return memo.get(n);
    }
}
