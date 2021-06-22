package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
力扣1403.非递增序列的最小子序列
给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。


 */
public class minSubsequenceTest {
    public static void main(String[] args) {
        minSubsequenceTest t1 = new minSubsequenceTest();
        int[] nums = new int[]{1,2,3,4,2,3,3,1,2,1};
        System.out.println(t1.minSubsequence(nums));
    }
    public List<Integer> minSubsequence(int[] nums)
    {
        int len = nums.length;
        int sum = 0;
        int temp = 0;
        List<Integer> res = new ArrayList<>();
        if(len == 0)
            return res;
        if(len == 1)
        {
                res.add(nums[0]);
                return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; i++)
        {
            sum += nums[i];
        }
        for(int i = nums.length-1; i >= 0; i--)
        {
            if(temp <= sum/2)
            {
                temp += nums[i];
                res.add(nums[i]);
                continue;
            }
        }
        return res;
    }

}
