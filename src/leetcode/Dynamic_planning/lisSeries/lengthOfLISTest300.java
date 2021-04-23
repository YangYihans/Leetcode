package leetcode.Dynamic_planning.lisSeries;

import java.util.Arrays;

/**
 * @Author Yang
 * @Date 2021/4/5 16:19
 * @Description 300：最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 *
 * 模板题 dp[i]表示以nums[i]结尾的最长上升子序列的长度/
 */
public class lengthOfLISTest300 {
    public static void main(String[] args) {
        lengthOfLISTest300 t1 = new lengthOfLISTest300();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.print(t1.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        if(n < 2)
            return n;
        // dp表示以nums[i]结尾的最长上升子序列的长度
        int [] dp = new int[n];
        // base case
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }
        }
        Arrays.sort(dp);
        return dp[n-1];
    }

}
