package leetcode;

import java.util.Arrays;

public class majorityElementTest169 {
    public static void main(String[] args) {
        majorityElementTest169 t1 = new majorityElementTest169();
        int[] a = new int[]{2,2,1,1,1,2,2};
        //System.out.print(t1.majorityElement(a));
        System.out.print(t1.majorityElement1(a));
    }

    /**
     * 暴力解法：先对数组进行排序，相同的就增加，不相同计数count清1，重新开始计数。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums)
    {
        Arrays.sort(nums);
        double count = 1;
        double len = Math.ceil(nums.length/2.0);
        for(int i = 0; i < nums.length-1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                count++;
                if(count >= len)
                {
                    return nums[i];
                }
            }
            else
            {
                count = 1;
            }
        }
        return -1;
    }

    /**
     * 摩尔投票法：抵消删除不同的数，如果众数是大于一半的数，那么它和其他的数相互抵消最后还是能剩下它。
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums)
    {
        int res = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(cnt == 0)
            {
                res = nums[i];
                cnt++;
            }
            else
            {
                if(res == nums[i])
                    cnt ++;
                else
                    cnt --;
            }
        }
        return res;
    }
}
