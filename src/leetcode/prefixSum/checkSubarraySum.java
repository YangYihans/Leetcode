package leetcode.prefixSum;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
 *
 * 要使得两者除k相减为整数，需要满足两者对k的取余相同。
 * 所以只需要枚举右端点，然后再枚举右端点j的时候检查之前是否出现过左端点i，使得sum[j]和sum[i-1]对k的取余相同。
 *
 * key:同余定理，
 */
public class checkSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k){
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i <= n; i++){
            set.add(sum[i-2] % k);
            if(set.contains(sum[i] % k)){
                return true;
            }
        }
        return false;
    }
}
