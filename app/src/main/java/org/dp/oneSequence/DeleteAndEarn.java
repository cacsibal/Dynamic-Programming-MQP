package org.dp.oneSequence;
import org.dp.ITopDown;

import java.util.Arrays;

/**
 * Name: Delete and Earn
 * Description:
 * Given an integer array nums, you can pick any nums[i] and delete it to earn nums[i] points,
 * then you must delete any element and equal to nums[i]-1 or nums[i]+1. Goal is to compute the
 * maximum value you can get by perform these operations
 *
 * Example:
 * nums = [3,4,2]
 * maximum value: 6
 * Operation: delete 4 to get 4 points, then 3 is also deleted. Finally delete 2 to get 2 points
 */
public class DeleteAndEarn implements ITopDown {

    int[] nums;

    public DeleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
    }

    public int solution() {
        return solution_topdown(0);
    }

    private int solution_topdown(int i) {
        if (i >= nums.length) return 0;

        int cur = nums[i], pick = 0;
        while (i < nums.length && nums[i] == cur) {
            pick += nums[i];
            i++;
        }

        int res = solution_topdown(i);
        while (i < nums.length && nums[i] == cur + 1) {
            i++;
        }

        res = Math.max(res, pick + solution_topdown(i));
        return res;
    }
}
