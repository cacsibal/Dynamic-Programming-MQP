package org.dp.bottomUp.oneSequence;

public class LongestValidParentheses {

    String s;
    int[][] dp;
    public LongestValidParentheses(String s){
        this.s = s;
        dp=new int[s.length()][2];
    }

    public int solution() {
        if(s.length() < 2){
            return 0;
        }

        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == ')' &&
                i-dp[i-1][0]-1 >= 0 &&
                s.charAt(i-dp[i-1][0]-1) == '(')
            {
                dp[i][0] = dp[i-1][0] + 2 + ((i-dp[i-1][0]-2 >= 0)?dp[i-dp[i-1][0]-2][0]:0);

            }
            dp[i][1] = Math.max(dp[i][0],dp[i-1][1]);
        }
        return dp[s.length()-1][1];
    }

    public String retrieve(){
        return findPath(s.length()-1, 1);
    }
    public String findPath(int x, int y){
        if(x==0){
            return "Take 0";
        }
        else{
            if(y==0){
               return x-dp[x][0]+1+"-"+x;
            }
            else{
                if(dp[x][0]>dp[x-1][1]){
                    return findPath(x,0);
                }
                else{
                    return findPath(x-1,1);
                }
            }
        }
    }

}
