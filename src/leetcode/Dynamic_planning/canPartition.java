package leetcode.Dynamic_planning;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * @Author Yang
 * @Date 2021/4/6 11:58
 * @Description 416.分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 当成0-1背包问题来看，就是是否能分成两个背包，满足重量是总重量的一半， 如果能装完就是true， 否则为false。
 */
public class canPartition {
    public boolean canPartition(int[] nums){
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[len+1][sum+1];
        // target = 0 时说明放到第i个时刚好放满就是true
        for(int i = 0; i < len+1; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= sum; j++){
                // 当前背包放不下了
                if(j - nums[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[len][sum];
    }
}
