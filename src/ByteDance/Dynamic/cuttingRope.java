package ByteDance.Dynamic;

public class cuttingRope {
    public static void main(String[] args)
    {
        System.out.println(10);
    }
    public static int cuttingRope(int n)
    {
        if(n < 2)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++)
        {
            for(int j = 1; j < 3; j++)
            {
                /**
                 * dp[i] 当长度为i的时候最大的乘积， dp[i-j] * j截取j段的乘积， (i-j) * j 只分成两段的乘积，
                 *
                 */
                dp[i] = Math.max(Math.max(dp[i-j]*j , (i-j) *j), dp[i]);
            }
        }
        return dp[n];
    }
}
