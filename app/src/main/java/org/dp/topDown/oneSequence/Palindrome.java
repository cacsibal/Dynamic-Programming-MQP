package org.dp.topDown.oneSequence;

public class Palindrome {

    // helper function
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int palPartitionRec(String s, int i, int j) {

        /**
         * initialization
         */
        if (i >= j || isPalindrome(s, i, j))
            return 0;

        int res = Integer.MAX_VALUE, cuts;

        /**
         * iterative solution
         */
        for (int k = i; k < j; k++) {
            cuts = 1 + palPartitionRec(s, i, k) +
                    palPartitionRec(s, k + 1, j);
            res = Math.min(res, cuts);
        }

        /**
         * return final result
         */
        return res;
    }

    public int solution(String s) {
        return palPartitionRec(s, 0, s.length() - 1);
    }
}
