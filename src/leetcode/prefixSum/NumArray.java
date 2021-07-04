package leetcode.prefixSum;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * 一维前缀和的经典例题：
 *      当需要我们求「某一段」区域的和的时候，我们要很自然的想到「前缀和」。
 * 前缀和数组 sum 的每一位记录的是当前位置距离起点位置，这连续一段的和区间和。
 */
public class NumArray {
    public int[] sum;
    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len + 1];
        /**
         * 涉及到减1的操作，所以下标从1开始记录
         */
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        /**
         * 源数组是从0开始的，所以要在模板的基础上进行+1操做
         *
         */
        left++;
        right++;
        return sum[right] - sum[left - 1];
    }


    /**
     * 模板
     * {
     *     sum = new int[len + 1];
     *     for(int i = 1; i <= len; i++){
     *         sum[i] = sum[i-1] + nums[i-1];
     *     }
     * }
     *
     * 计算结果
     * {
     *     i++;
     *     j++;
     *     res = nums[j] - nums[i-1];
     * }
     */

}
