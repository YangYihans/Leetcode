package Baidu;

import java.util.Arrays;

public class Q1 {
    public static int solution(int[] nums) {
        int[] dp_min = new int[10];
        Arrays.fill(dp_min, Integer.MAX_VALUE);
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp_min[nums[0]] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp_min[nums[i]]) + 1;
            dp_min[nums[i]] = Math.min(dp_min[nums[i]], dp[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,2,1,2}));
    }
}
