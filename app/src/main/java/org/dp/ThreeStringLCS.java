package org.dp;

public class ThreeStringLCS {
    String s1;
    String s2;
    String s3;

    int len1;
    int len2;
    int len3;

    int[][][] dp;

    public ThreeStringLCS(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.len1 = s1.length();
        this.len2 = s2.length();
        this.len3 = s3.length();

        dp = new int[len1 + 1][len2 + 1][len3 + 1];
    }

    public int solution() {
        for(int i = 0; i <= len1; i++){
            dp[i][0][0] = 0;
        }

        for(int j = 0; j <= len2; j++){
            dp[0][j][0] = 0;
        }

        for(int k = 0; k <= len3; k++){
            dp[0][0][k] = 0;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                for(int k = 1; k <= len3; k++){
                    if(s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)){
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(
                                dp[i - 1][j][k],
                                Math.max(
                                        dp[i][j - 1][k],
                                        dp[i][j][k - 1]
                                )
                        );
                    }
                }
            }
        }

        return dp[len1][len2][len3];
    }
}
