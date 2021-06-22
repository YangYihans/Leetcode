package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    力扣15题 三数之和
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    难点：重复数字的消除，通过循环控制消除重复的数字。
    思路：先通过排序变成有序数组，然后将大于零的元素滤除，通过双指针和选定的数三者相加，小于就移动左指针，大于就移动右指针，相同指针同向移动。
 */
public class threeSumTest {
    public static void main(String [] args)
    {
        threeSumTest t1 = new threeSumTest();
        int [] nums = new int[]{0,0,0,0};
        System.out.println(t1.threeSum(nums));
    }
    List<List<Integer>> threeSum(int [] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len <3)
            return ans;
        Arrays.sort(nums);
        int l, r; //定义左右指针
        for(int i = 0; i < len; i++)
        {
            l = i + 1;
            r = len - 1;
            if(nums[i]>0)
                break;
            if(i > 0 && nums[i]==nums[i-1])
            {
                continue;
            }
            while(l<r)
            {
                if(nums[i]+nums[l]+nums[r]==0)
                {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l+1] == nums[l]) //循环排除相加重复的数字
                    l++;
                    while(l<r && nums[r-1] == nums[r]) //循环排除相加重复的数字
                    r--;
                    l++;
                    r--;
                }
                if(nums[i]+nums[l]+nums[r]<0)
                {
                    l++;
                }
                if(nums[i]+nums[l]+nums[r]>0)
                {
                    r--;
                }
            }
        }
        return ans;
    }
}
