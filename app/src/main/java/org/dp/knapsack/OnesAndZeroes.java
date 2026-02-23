package org.dp.knapsack;
import org.dp.ITopDown;

import java.util.HashMap;

/**
 * Name: One and Zeros
 * Description:
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 */
public class OnesAndZeroes implements ITopDown {

    /**
     * Create Cache
     */
    public HashMap<Integer, Integer> memo = new HashMap<>();

    String[] strs;
    int m;
    int n;
    public OnesAndZeroes(String[] strs, int m, int n){
        this.strs=strs;
        this.m=m;
        this.n=n;
    }

    public int solution_topdown() {
        return helper_topdown(0,m,n);
    }

    /**
     * Recursive Solution
     */
    public int helper_topdown(int i, int m, int n) {
        if(m<0||n<0){
            return Integer.MIN_VALUE;
        }
        if(i>=strs.length || m==0&&n==0){
            return 0;
        }
        int p1 = (m+n)*(m+n+1)/2+n;
        int key = (p1+i)*(p1+i+1)/2+i;
        if(!memo.containsKey(key)){
            Integer[] help = helper2(strs[i]);
            memo.put(key,Math.max(helper_topdown(i+1,m,n),1+ helper_topdown(i+1,m-help[0],n-help[1])));
        }
        return memo.get(key);
    }

    public HashMap<String, Integer[]> memoc = new HashMap<>();
    public Integer[] helper2(String s){
        if(!memoc.containsKey(s)){
            int zero=0, one=0;
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    zero++;
                }
                else{
                    one++;
                }
            }
            memoc.put(s,new Integer[]{zero,one});
        }
        return memoc.get(s);
    }

    public int solution(){
        return solution_topdown();
    }

}
