package leetcode;
/*
力扣1103：分糖果

 */
public class distributeCandiesTest1103 {
    public static void main(String[] args) {
        distributeCandiesTest1103 t1 = new distributeCandiesTest1103();
        int [] res = t1.distributeCandies(10,3);
        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i]);
        }
    }

    /**
     * 纯暴力解法
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people)
    {
        int[] res = new int[num_people];
        int cnt = 1;
        while(candies > 0)
        {
            for(int i = 0; i < num_people; i++)
            {
                if(candies <= cnt)
                {
                    res[i] = res[i] + candies;
                    candies = 0;
                    break;
                }
                res[i] = res[i] + cnt;
                candies = candies - cnt;
                cnt++;
            }
        }
        return res;
    }
}
