package leetcode.prefixSum;

/**
 * 724. 寻找数组的中心下标
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 */
public class pivotIndex {
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        /**
         * 前缀和的经典模板
         * 从1开始避免处理下标问题
         * sum[1] = 0 + nums[0]
         */
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int i = 1; i <= len; i++){
            int left = sum[i-1];
            int right = sum[len] - sum[i];
            if(left == right){
                return i-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
