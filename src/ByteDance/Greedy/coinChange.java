package ByteDance.Greedy;

import java.util.Scanner;

/**
 * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
 * 现在小Y使用1024元的纸币购买了一件价值为N (0 < N \le 1024)N(0<N≤1024)的商品，
 * 请问最少他会收到多少硬币？
 */
public class coinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(coinChange(N));
    }
    public static int coinChange(int N)
    {
        int[] coins = new int[]{64,16,4,1};
        int diff = 1024 - N;
        int count = 0;
        int add = 0;
        for(int i = 0; i < coins.length; i++)
        {
            if(diff > 0)
            {
                add = diff/coins[i];
                count += add;
                diff = diff - coins[i] * add;
            }

        }

        return count;
    }
}
