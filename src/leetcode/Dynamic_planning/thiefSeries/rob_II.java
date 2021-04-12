package leetcode.Dynamic_planning.thiefSeries;

import java.util.Arrays;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author Yang
 * @Date 2021/4/12 11:52
 * @Description 213. 打家劫舍 II
 * 房子是环状的
 */
public class rob_II {
    public static int rob(int[] nums) {
        if(nums == null){
            return 0;
        }
        int len = nums.length;
        if(len < 2){
            return nums[0];
        }
        int[]dp = new int[len];
        dp[0] = nums[0];  // 第一个房间偷了， 最后一个房间就不能偷
        dp[1] = dp[0];
        for(int i = 2; i < len - 1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int left = dp[len - 2];
        Arrays.fill(dp, 0);
        dp[0] = 0;  // 第一个房间不偷，最后一个房间就可以偷
        dp[1] = nums[1];
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return Math.max(left, dp[len - 1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
