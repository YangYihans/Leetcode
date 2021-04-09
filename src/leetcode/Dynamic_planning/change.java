package leetcode.Dynamic_planning;

import java.util.Arrays;

/**
 * @Author Yang
 * @Date 2021/4/9 15:27
 * @Description 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class change {
    /**
     * @Author Yang
     * @Date 2021/4/9 15:27
     * @Description 完全背包问题
     * 每个物品的数量是无限的，这就是完全背包问题。
     * 若只使用coins中的前i个硬币的面值，若想凑出金额j，有dp[i][j]种解法。
     * 由于i是从1开始的，所以coins的索引是i-1，表示第i个硬币的面值。
     *
     * 模板
     * for 状态1 in 状态1的所有取值：
     *     for 状态2 in 状态2的所有取值：
     *         for ...
     *             dp[状态1][状态2][...] = 计算(选择1，选择2...)
     */
    public int change(int amount, int[] coins){
        int len = coins.length;
        if(len == 0){
            return 0;
        }
        int[][] dp = new int[len+1][amount+1];
        for(int i = 0; i <= len; i++){
            dp[i][0] = 1;
        }
        dp[0][0] = 0;
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][amount];
    }
}
