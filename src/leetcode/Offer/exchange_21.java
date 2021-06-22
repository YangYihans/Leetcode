package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/5/23 10:34
 * @Description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class exchange_21 {
    public static int[] exchange(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left < right){
            while (left < len &&nums[left] % 2 == 1){
                left++;
            }
            while(right > 0 && nums[right] % 2 == 0){
                right--;
            }
            if(left < right && nums[left] % 2 == 0){
                while(right > left && nums[right] % 2 == 0){
                    right--;
                }
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        exchange(new int[]{1,2,5,6,7,4,3,2,1,3,4});
    }
}
