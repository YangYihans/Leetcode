package leetcode.Array;

/**
 * 给定一个未排序的整数数组。找到最长且连续的递增数列，并返回该列的长度
 */
public class findLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
    public static int findLengthOfLCIS(int[] nums)
    {
        int res = 1;
        int maxRes = 0;
        int len = nums.length;
        if(len == 0)
            return maxRes;
        if(len == 1)
            return res;
        for(int i = 1; i < len; i++)
        {
            if(nums[i] > nums[i-1])
            {
                res++;
                if(res > maxRes)
                    maxRes = res;
            }
            else if(nums[i] <= nums[i-1])
            {
                res = 1;
            }

        }
        //相等情况下的判断
        return maxRes > res? maxRes : res;
    }
}
