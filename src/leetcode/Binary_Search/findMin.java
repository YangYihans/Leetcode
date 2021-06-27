package leetcode.Binary_Search;

/**
 * @Author Yang
 * @Date 2021/4/8 20:51
 * @Description 153.寻找旋转排序数组中的最小值
 * 对于单调旋转找最小值的问题，本质上是二分的思想，二分的本质是阶段性，即一个阶段存在单调性，另一个阶段不存在。
 * 分为两种情况来讨论：存在重复数字和不存在重复数字。
 * 1.不存在重复数字：二阶段无论如何旋转是不会被破坏的。
 * 2.存在重复数字：二阶段可能存在破坏即： [2,2,3,4,1,2] 所以需要先进行预处理， 预处理为：
 *          while(left < right && nums[0] == nums[right]){
 *             right--;
 *          }
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

    public static int findMin_II(int[] nums) {
        int len = nums.length;
        int left = 0,  right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left == len ? nums[0] : nums[left];
    }

    /**
     * 存在重复数字的情况
     * @param nums 输入数组
     * @return 最小的值
     */
    public static int findMin_III(int[] nums){
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left < right && nums[0] == nums[right]){
            right--;
        }
        int end = right;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left == end + 1 ? nums[0] : nums[left];
    }


    public static void main(String[] args) {
        System.out.println(findMin_III(new int[]{5,1,3}));
    }
}
