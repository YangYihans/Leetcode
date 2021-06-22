package leetcode.Array;
/**
 * @Author Yang
 * @Date 2021/4/17 9:22
 * @Description 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在两个下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t
 * ，同时又满足 abs(i - j) <= k 。
 */
public class containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if(len == 0 || k < 0 || t < 0){
            return false;
        }
        for(int i = 0; i < len; i++){
            for(int j = i+1; j <= i + k && j < nums.length; j++){
                if(Math.abs((long) nums[i] - nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }
}
