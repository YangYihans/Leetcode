package leetcode.Dynamic_planning;
/**
 * @Author Yang
 * @Date 2021/4/5 10:34
 * @Description 53.最大子序和
 * dp定义以num[i]结尾的最大子数组和为dp[i]
 */
public class maxSubArray {
    public int maxSubArray(int[] nums){
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            // dp要么是前一个dp的值+当前的nums， 要么就是nums成为一个新的头部。
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
