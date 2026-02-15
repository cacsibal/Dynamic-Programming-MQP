package org.dp.oneSequence;

import org.dp.IBottomUp;
import org.dp.IRetrieveSolution;
import org.dp.ITopDown;

/**
 * Name: Longest Valid Parentheses Substring
 * Description:
 * Given a string s consisting of opening and closing parenthesis, find the length
 * of the longest valid parenthesis substring
 *
 * Example:
 * s = "())"
 * output = 2 since the longest valid parenthesis substring is"()"
 */
public class LongestValidParentheses implements ITopDown, IBottomUp{

    String s;

    public LongestValidParentheses(String s) {
        this.s = s;
    }

    public int helper_bottomup() {
        if(s.length() < 2){
            return 0;
        }
        int curMax = 0;
        int[] longest=  new int[s.length()];
        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == ')' && i-longest[i-1]-1 >= 0 && s.charAt(i-longest[i-1]-1) == '('){
                longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
                curMax = Math.max(longest[i],curMax);
            }
        }
        return curMax;
    }

    public int helper_topdown(int i) {
        if (i >= s.length()) return 0;

        int best = 0;

        // Option 1: skip this position
        best = helper_topdown(i + 1);

        // Option 2: try to start a valid block at i
        if (s.charAt(i) == '(') {
            int balance = 0;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') balance++;
                else balance--;

                // found a valid block [i..j]
                if (balance == 0) {
                    int length = (j - i + 1) + helper_topdown(j + 1);
                    best = Math.max(best, length);
                }
            }
        }

        return best;
    }

    public int solution_bottomup() {
        return helper_bottomup();
    }

    public int solution_topdown() {
        return helper_topdown(0);
    }

    public int solution() {
        return solution_topdown();
    }

}
