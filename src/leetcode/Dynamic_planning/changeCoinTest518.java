package leetcode.Dynamic_planning;

import java.util.PriorityQueue;
import java.util.Queue;

public class changeCoinTest518 {
    public static int change(int amount, int[] coins) {
        if(amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins)
        {
            for(int i = 1; i <= amount; i++)
            {
                if(i >= coin)
                    dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,5};
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        System.out.println(change(5,nums));
    }
}
