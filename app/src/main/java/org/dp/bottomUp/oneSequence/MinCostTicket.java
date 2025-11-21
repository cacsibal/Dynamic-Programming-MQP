package org.dp.bottomUp.oneSequence;

public class MinCostTicket {
    public int solution(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n - 1];

        // dp[d] = min cost to cover from day d to the end
        int[] dp = new int[lastDay + 1];

        // Mark travel days
        boolean[] travel = new boolean[lastDay + 1];
        for (int d : days) {
            travel[d] = true;
        }

        for (int d = lastDay; d >= 1; d--) {
            if (!travel[d]) {
                // No travel – cost same as next day
                dp[d] = dp[d + 1];
            } else {
                int cost1 = costs[0] + dp[Math.min(lastDay, d + 1)];
                int cost7 = costs[1] + dp[Math.min(lastDay, d + 7)];
                int cost30 = costs[2] + dp[Math.min(lastDay, d + 30)];

                dp[d] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }

        return dp[days[0]];
    }
}
