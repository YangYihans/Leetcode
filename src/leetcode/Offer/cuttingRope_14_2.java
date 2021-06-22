package leetcode.Offer;

import java.math.BigInteger;
import java.util.Arrays;

public class cuttingRope_14_2 {
    public static int cuttingRope(int n){
        BigInteger[] dp = new BigInteger[n+1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for(int i = 3; i < n+1; i++){
            for(int j = 2; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i-j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
