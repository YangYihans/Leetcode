package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口的思想
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,4};
    }
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0 || len < 3)
            return res;
        if(len == 3)
        {
            if(nums[0] + nums[1] + nums[2] == 0)
            {
                res.add(Arrays.asList(nums[0],nums[1],nums[2]));
                return res;
            }
            else
                return res;
        }
        Arrays.sort(nums);
        int l, r;
        for(int i = 0; i < nums.length; i++)
        {
            l = i+1;
            r = len - 1;
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            while(l < r)
            {
                if(nums[i] + nums[l] + nums[r] == 0)
                {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[l] == nums[l+1])
                    {
                        l++;
                    }
                    while(l < r && nums[r] == nums[r-1])
                    {
                        l--;
                    }
                    l++;
                    r--;
                }
                else if(nums[i] + nums[l] + nums[r] < 0)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        return res;
    }
}
