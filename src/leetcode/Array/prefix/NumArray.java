package leetcode.Array.prefix;
/**
 * @Author Yang
 * @Date 2021/5/12 9:50
 * @Description 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 数组不变求区间和————前缀和、树状数组
 */
public class NumArray {
    public int[] res;
    public NumArray(int[] nums) {
        int len = nums.length;
        res = new int[len+1];
        res[0] = 0;
        for(int i = 0; i < len; i++){
            res[i+1] = res[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return res[j+1] - res[i];
    }
}
