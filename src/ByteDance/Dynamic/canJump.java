package ByteDance.Dynamic;

import java.util.Properties;

/**
 * 是否能到达最后一个数组。
 */
public class canJump {
    public static void main(String[] args)
    {
        int[] nums = new int[]{2,3,1,1,4};
       // System.out.println(canJump(nums));
        System.out.println(jump(nums));
    }
    public static boolean canJump(int[] nums)
    {
        int n = 1;
        for(int i = nums.length-2; i >=0; i--)
        {
            if(nums[i] >= n)
            {
                n = 1;
            }
            else
                n++;
            if(i == 0 && n > nums[0])
                return false;
        }
        return true;
    }
    //反向查找每次最远的位置。
    public static int jump(int[] nums)
    {
        int start = 0;
        int end = nums.length-1;
        int times = 0;
        while(end >= 0 && start < end)
        {
            for(; start < end; start++)
            {
                if(start == 0 && start + nums[start] >= end)
                    return times+1;
                if(start + nums[start] >= end)
                {
                    end = start;
                    start = 0;
                    times++;
                    break;
                }
            }

        }
        return 0;
    }
}
