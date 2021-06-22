package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/5/12 16:27
 * @Description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class search_53 {
    public int search(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] <= target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        int right = i;
        i = 0;
        j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        int left = j;
        return right - left + 1;
    }
}
