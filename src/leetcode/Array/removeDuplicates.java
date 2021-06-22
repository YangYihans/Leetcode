package leetcode.Array;
/**
 * @Author Yang
 * @Date 2021/4/6 9:16
 * @Description 80. 删除有序数组中的重复项 II
 * 重复项最多出现两次
 */
public class removeDuplicates {
    public static boolean flag = false;
    public static int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len <= 2){
            return len;
        }
        int left = 0, right = 1;
        while(right < len){
            if(nums[left] != nums[right]){
                left++;
                right++;
                if(right == len){
                    left++;
                }
                continue;
            }
            while(right < len && nums[left] == nums[right]){
                right++;
            }
            if(right - left == 2){
                left = right;
                right = right + 1;
                if(right == len){
                    left++;
                }
                continue;
            }
            left += 2;
            int index_left = left;
            int index_right = right;
            while(index_right < len){
                swap(nums, index_left++, index_right++);
            }
            right = left + 1;
            len = index_left;
            if(right == len){
                left++;
            }
        }
        return left;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        flag = true;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2}));
    }

}
