package leetcode.prefixSum;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class subarraySum {
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int res = 0;
        for(int left = 0; left < len; left++){
            for(int right = left + 1; right <= len; right++){
                if(sum[right] - sum[left] == k){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
