package leetcode.Binary_Search;
/**
 * @Author Yang
 * @Date 2021/4/8 21:58
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class searchRange {
    public static int[] searchRange(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left == nums.length || nums[left] != target){
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = left;
        right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{2,2}, 2));
    }
}
