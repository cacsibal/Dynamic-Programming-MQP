package org.dp.topDown.oneSequence;

public class MaximumProductCutting {
    public int solution(int n) {
            // Base cases
        if (n == 0 || n == 1) return 0;

            // Make a cut at different places
            // and take the maximum of all
        int max_val = 0;
        for (int i = 1; i < n; i++)
            max_val = Math.max(max_val,
                    Math.max(i * (n - i),
                            solution(n - i) * i));

            // Return the maximum of all values
        return max_val;
    }
}
