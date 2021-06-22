package leetcode.Array;

/**
 * 调整数组顺序使奇数位于偶数的前面
 * 一次快排思想
 */
public class exchange {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] res = exchange(nums);
        for(int i = 0; i < nums.length; i++)
        {
            System.out.println(res[i]);
        }
    }
    public static int[] exchange(int[] nums)
    {
        if(nums == null)
            return nums;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right)
        {
            if(nums[left] % 2 == 0 && nums[right] % 2 == 1) //左偶右奇
            {
                swap(nums, left, right);
                left++;
                right--;
            }
            else if(nums[left] % 2 == 0) //左偶右偶
            {
                right--;
            }
            else if(nums[right] % 2 == 1) //左奇右奇
            {
                left++;
            }
            else  //左奇右偶
            {
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
}
