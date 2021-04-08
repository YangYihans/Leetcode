package leetcode.Binary_Search;

/**
 * @Author Yang
 * @Date 2021/4/8 20:51
 * @Description 153.寻找旋转排序数组中的最小值
 */
public class findMin {
    public static int findMin(int[] nums){
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.min(nums[0], nums[1]);
        }
        int left = 0, right = len - 1;
        while(left < right){  // 左闭右开的区间
            int mid = left + (right - left) / 2;
            if(nums[left] < nums[right]){ // 数组从左到右依次递增
                return nums[left];
            }
            if(nums[left] > nums[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
