package leetcode.Back_Trace.combination;
/**
 * @Author Yang
 * @Date 2021/4/24 9:31
 * @Description 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 回溯法会超时，选择动态规划的方法
 */
public class combinationSum4 {
    public static int combinationSum4(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(num <= i){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
