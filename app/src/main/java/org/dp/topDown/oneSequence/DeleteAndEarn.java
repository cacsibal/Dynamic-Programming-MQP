package org.dp.topDown.oneSequence;

public class DeleteAndEarn {
    public int solution(int[] nums) {
        bubbleSort(nums);
        return dfs(nums, 0);
    }

    public void bubbleSort(int[] array) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) return 0;

        int cur = nums[i], pick = 0;
        while (i < nums.length && nums[i] == cur) {
            pick += nums[i];
            i++;
        }

        int res = dfs(nums, i);
        while (i < nums.length && nums[i] == cur + 1) {
            i++;
        }

        res = Math.max(res, pick + dfs(nums, i));
        return res;
    }
}
