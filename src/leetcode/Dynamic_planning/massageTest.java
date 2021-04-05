package leetcode.Dynamic_planning;
/*
面试题17.16 按摩师
一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数
 */
public class massageTest {
    public static void main(String[] args) {
        massageTest t1 = new massageTest();
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(t1.massage(nums));
    }
    public int massage(int[] nums)
    {
        int n = nums.length;
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return nums[0]>nums[1]? nums[0]:nums[1];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[0]>nums[1]? nums[0]:nums[1];
        for(int i = 2; i < n; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
