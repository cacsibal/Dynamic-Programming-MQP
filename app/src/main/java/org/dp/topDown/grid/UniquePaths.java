package org.dp.topDown.grid;

import java.util.*;

public class UniquePaths {
    Map<Integer, Integer> memo;

    public int solution(int m, int n) {
        memo = new HashMap<>();
        if (m == 1 || n == 1) return 1;

        int k = (m + n) * (m + n + 1) / 2 + m;
        if (memo.containsKey(k)) return memo.get(k);

        int result = solution(m - 1, n) + solution(m, n - 1);
        memo.put(k, result);
        return result;
    }
}
