package leetcode.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 将0转换为-1，问题就转换成[如何求最长一段区间和为0的子数组]
 * 思路：前缀和+哈希表
 */
public class findMaxLength {
    public static int findMaxLength(int[] nums){
        int len = nums.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] + (nums[i-1] == 1 ? 1 : -1);
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 2; i <= len; i++){
            if(!map.containsKey(sum[i-2])){
                map.put(sum[i-2], i-2);
            }
            /**
             * 如果当前sum在哈希表中存在，说明当前下标i到sum第一次出现的下标，01出现的次数相同。
             */
            if(map.containsKey(sum[i])){
                ans = Math.max(ans, i - map.get(sum[i]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
    }
}
