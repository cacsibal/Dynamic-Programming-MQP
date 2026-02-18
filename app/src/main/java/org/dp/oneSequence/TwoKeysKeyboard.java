package org.dp.oneSequence;
import org.dp.ITopDown;

import java.util.HashMap;

/**
 * Name: 2 keys keyboard
 * Description:
 * There is only one character 'A' on the screen of a notepad.
 * You can perform one of two operations on this notepad for each step:
 *
 * Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 *
 * Given an integer n, return the minimum number of operations to get the character 'A' exactly
 * n times on the screen.
 */
public class TwoKeysKeyboard implements ITopDown {

    /**
     * Create Cache
     */
    HashMap<Integer,Integer> memo = new HashMap<>();

    int n;
    public TwoKeysKeyboard(int n){
        this.n=n;
    }

    public int solution_topdown() {
        if(n==1){
            return 0;
        }
        return 1+helper_topdown(1,1);

    }
    public int helper_topdown(int i, int j){
        if(i==n){
            return 0;
        }
        if(i>n){
            return Integer.MAX_VALUE/2;
        }
        int key = i*i+j;
        if(!memo.containsKey(key))
            memo.put(key, Math.min(2+helper_topdown(2*i,i),1+helper_topdown(i+j,j)));
        return memo.get(key);
    }

    public int solution(){
        return solution_topdown();
    }
}
