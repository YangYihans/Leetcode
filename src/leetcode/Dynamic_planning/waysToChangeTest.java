package leetcode.Dynamic_planning;

import javax.sound.midi.SoundbankResource;

/**
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 */
public class waysToChangeTest {
    public static void main(String[] args) {
        waysToChangeTest t1 = new waysToChangeTest();
        System.out.println(t1.waysToChange(10));
    }
    public int waysToChange(int n)
    {
        int[] coins = new int[]{25,10,5,1};
        final int mod = 1000000007;
        int[] res = new int[n+1];
        res[0] = 1;
        for(int coin : coins)
        {
            for(int i = coin; i <= n; i++)
            {
                res[i] = (res[i] + res[i - coin]) % mod;
            }
        }
        return res[n];
    }

}
