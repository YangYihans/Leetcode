package leetcode.Dynamic_planning.two_dimensional;

import org.omg.CORBA.INTERNAL;

public class strangePrinter {
    public int strangePrinter(String s){
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = len - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    int minn = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++){
                        minn = Math.min(minn, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = minn;
                }
            }
        }
        return dp[0][len-1];
    }
}
