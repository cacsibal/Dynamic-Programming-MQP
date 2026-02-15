package org.dp.oneSequence;

import org.dp.IBottomUp;

/**
 * Name Minimum Cost For Tickets
 *
 * Description:
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 */

public class MinCostTicket implements IBottomUp {

    int[] days;
    int[] costs;

    public MinCostTicket(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
    }

    public int helper_bottomup() {
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

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution(){
        return helper_bottomup();
    }
}
