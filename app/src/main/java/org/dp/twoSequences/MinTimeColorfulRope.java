package org.dp.twoSequences;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 * Name: Minimum Time to Make Rope Colorful
 * Description:
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string
 * colors where colors[i] is the color of the ith balloon.
 *
 * Alice wants the rope to be colorful. She does not want two consecutive
 * balloons to be of the same color, so she asks Bob for help. Bob can remove
 * some balloons from the rope to make it colorful. You are given a 0-indexed
 * integer array neededTime where neededTime[i] is the time (in seconds) that Bob
 * needs to remove the ith balloon from the rope.
 *
 * Return the minimum time Bob needs to make the rope colorful.
 */

public class MinTimeColorfulRope implements ITopDown, IBottomUp{

    String colors;
    int[] neededTime;

    public MinTimeColorfulRope(String colors, int[] neededTime) {
        this.colors = colors;
        this.neededTime = neededTime;
    }

    public int helper_bottomup() {
        int totalTime = 0;

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalTime;
    }

    public int helper_topdown(int i, int groupMax, int costSoFar) {

        // Base case: finished scanning
        if (i == colors.length()) {
            return costSoFar;
        }

        // If start of string or new color group, reset groupMax
        if (i == 0 || colors.charAt(i) != colors.charAt(i - 1)) {
            groupMax = 0;
        }

        // Always tentatively add this balloon's cost
        costSoFar += neededTime[i];

        // Update max time in this group
        groupMax = Math.max(groupMax, neededTime[i]);

        // If end of this color group, subtract the one we keep
        if (i == colors.length() - 1 ||
                colors.charAt(i) != colors.charAt(i + 1)) {
            costSoFar -= groupMax;
        }

        // Recurse to next position
        return helper_topdown(i + 1, groupMax, costSoFar);
    }

    public int solution_bottomup(){
        return helper_bottomup();
    }

    public int solution_topdown(){
        return helper_topdown(0,0,0);
    }

    public int solution(){
        return solution_topdown();
    }
}
