package org.dp.topDown;
import java.util.HashMap;

public class OnesAndZeroes {

    /**
     * Create Cache
     */
    public HashMap<Integer, Integer> memo = new HashMap<>();

    public int solution(String[] strs, int m, int n) {
        return solutionR(0,strs,m,n);
    }

    /**
     * Recursive Solution
     */
    public int solutionR(int i, String[] strs, int m, int n) {
        if(m<0||n<0){
            return Integer.MIN_VALUE;
        }
        if(i>=strs.length || m==0&&n==0){
            return 0;
        }
        int p1 = (m+n)*(m+n+1)/2+n;
        int key = (p1+i)*(p1+i+1)/2+i;
        if(!memo.containsKey(key)){
            Integer[] help = helper(strs[i]);
            memo.put(key,Math.max(solutionR(i+1,strs,m,n),1+ solutionR(i+1,strs,m-help[0],n-help[1])));
        }
        return memo.get(key);
    }

    public HashMap<String, Integer[]> memoc = new HashMap<>();
    public Integer[] helper(String s){
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

}
