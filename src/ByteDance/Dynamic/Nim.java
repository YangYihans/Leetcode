package ByteDance.Dynamic;

import java.util.Hashtable;

public class Nim {
    public static boolean canWinNim(int n){
        if(n <= 3)
            return true;
        boolean[] dp = new boolean[n+1];
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for(int i = 4; i <= n; i++){
            boolean flag = !dp[i-1] || dp[i-2];
            dp[i] = !dp[i-1] || !dp[i-2] || !dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(5));
    }
}
