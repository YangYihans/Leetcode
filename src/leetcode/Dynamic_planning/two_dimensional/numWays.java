package leetcode.Dynamic_planning.two_dimensional;
/**
 * @Author Yang
 * @Date 2021/5/13 9:45
 * @Description 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 */
public class numWays {
    static final int val=10_0000_0007;
    public static int numWays(int steps, int arrLen) {
        int len=Math.min(steps,arrLen-1);
        int[][] dp=new int[steps+1][len+1];
        dp[0][0]=1;
        for(int i=1;i<=steps;i++){
            for(int j=0;j<=len;j++){
                dp[i][j]=dp[i-1][j];//上一层走i步到达j下标，不动的方案数
                if(j>=1){
                    dp[i][j]=(dp[i][j]+dp[i-1][j-1])%val;//不动方案数+上一层走i步到达j-1下标方案数
                }
                if(j<len){
                    dp[i][j]=(dp[i][j]+dp[i-1][j+1])%val;//不动方案数+上一层走i步到达j-1下标方案数+上一层走
                }
                //dp[i][j]=dp[i-1][j-1]+dp[i][j]+dp[i-1][j+1];
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        System.out.println(numWays(4, 2));
    }
}
