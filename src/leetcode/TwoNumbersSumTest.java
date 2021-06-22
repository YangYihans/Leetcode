package leetcode;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
力扣第一题
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
  给定 nums = [2, 7, 11, 15], target = 9
  因为 nums[0] + nums[1] = 2 + 7 = 9
  所以返回 [0, 1]

  解题思路：hashMap中分别存放值和下标,对新遍历的点与目标值做差判断是否在hashMap中存在，如果存在则输出两点，否则录入hashMap中
 */
public class TwoNumbersSumTest {
    public static void main(String [] args)
    {
        int[] aa = new int[]{2,7,11,15};
        TwoNumbersSumTest x = new TwoNumbersSumTest();
        aa = x.twoSum(aa, 9);
        System.out.println(aa[0]);
        System.out.println(aa[1]);
    }
    public int[] twoSum(int[] nums, int target)
    {
        Map <Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++)
        {
            int temp = target - nums[i];
            if(map.containsKey(temp))
            {
                return new int[]{map.get(temp), i};
            }
            else
                map.put(nums[i], i);

        }
        return new int[]{-1,-1};
    }
}
