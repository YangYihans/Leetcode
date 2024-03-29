package leetcode.Dynamic_planning;

import java.util.Arrays;

/*
力扣322：零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class coinChangeTest322 {
    public static void main(String[] args) {
        coinChangeTest322 t1 = new coinChangeTest322();
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.print(t1.coinChange(coins,amount));
    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++)
        {
            for(int j = 0; j < coins.length; j++)
            {
                if(coins[j] <= i)
                {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount? -1 : dp[amount];
    }

}
