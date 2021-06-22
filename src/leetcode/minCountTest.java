package leetcode;

public class minCountTest {
    public static void main(String[] args) {
        minCountTest t1 = new minCountTest();
        int[] coins = new int[]{1,1,1};
        System.out.println(t1.minCount(coins));
    }
    public int minCount(int[] coins)
    {
        int len = coins.length;
        int time = 0;
        for(int i = 0; i < len; i++)
        {
            if(coins[i] % 2 == 0)
            {
                time += coins[i]/2;
            }
            else
            {
                time += (coins[i]+1)/2;
            }
        }
        return time;
    }

}
