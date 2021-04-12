package leetcode.Dynamic_planning.thiefSeries;
/**
 * @Author Yang
 * @Date 2021/4/12 11:43
 * @Description 198. 打家劫舍
 * 相邻两个房子不能被偷
 */
public class rob_I {
    public static int rob(int[] nums) {
        if(nums == null){
            return 0;
        }
        int len = nums.length;
        if(len < 2){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        rob(new int[]{2,7,9,3,1});
    }
}
