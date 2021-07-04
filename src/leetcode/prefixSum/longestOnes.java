package leetcode.prefixSum;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 可以将题目转换为：找出一个连续区间，区间中0出现的次数不超过k次
 */
public class longestOnes {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int ans = 0;
        for(int i = 0; i < len; i++){
            int left = 0, right = i;
            while(left < right){
                int mid = left + right >> 1;
                if(check(sum, mid, i, k)){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            if(check(sum, right, i, k)){
                ans = Math.max(ans, i - right + 1);
            }
        }
        return ans;
    }

    private boolean check(int[] sum, int left, int right, int k) {
        int tol = sum[right + 1] - sum[left];
        int len = right - left + 1;
        return len - tol <= k;
    }

    public int longestOnes_II(int[] nums, int k){
        int len = nums.length;
        int ans = 0;
        for(int i = 0, j = 0, tot = 0; i < len; i++){
            tot += nums[i];
            while((i - j + 1) - tot > k) {
                tot -= nums[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
