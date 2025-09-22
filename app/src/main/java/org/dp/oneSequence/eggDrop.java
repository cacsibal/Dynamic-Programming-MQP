package org.dp.oneSequence;

public class eggDrop {
    // Function to find minimum number of attempts
    // needed in order to find the critical floor
    public int eggDropSol(int n, int k) {

        // if there is less than or equal to one floor
        if (k == 1 || k == 0)
            return k;

        // if there is only one egg
        if (n == 1)
            return k;

        // to store the minimum number of attempts
        int res = Integer.MAX_VALUE;

        // Consider all droppings from
        // 1st floor to kth floor
        for (int i = 1; i <= k; i++) {
            int cur = 1 + Math.max(eggDropSol(n - 1, i - 1), eggDropSol(n, k - i));
            if (cur < res)
                res = cur;
        }

        return res;
    }
}
