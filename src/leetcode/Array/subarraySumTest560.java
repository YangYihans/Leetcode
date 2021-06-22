package leetcode.Array;

import javax.sound.midi.SoundbankResource;

public class subarraySumTest560 {
    public static void main(String[] args) {
        subarraySumTest560 t1 = new subarraySumTest560();
        int[] nums = new int[]{1,1,1};
        System.out.println(t1.subarraySum(nums, 2));
    }
    public int subarraySum(int[] nums, int k)
    {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
