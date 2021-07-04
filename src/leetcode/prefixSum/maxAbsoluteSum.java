package leetcode.prefixSum;

import org.omg.CORBA.INTERNAL;

/**
 * 1749. 任意子数组和的绝对值的最大值
 */
public class maxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums){
        int len = nums.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int ans = 0;
        int max = 0;
        int min = 0;
        for(int i = 1; i <= len; i++){
            ans = Math.max(ans, Math.abs(sum[i] - min));
            ans = Math.max(ans, Math.abs(sum[i] - max));
            max = Math.max(max, sum[i]);
            min = Math.min(min, sum[i]);
        }
        return ans;
    }
}
