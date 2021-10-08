package leetcode.Binary_Search;

import java.sql.SQLOutput;

public class search {
    /**
     * @Author Yang
     * @Date 2021/4/7 22:52
     * @Description 81. 搜索旋转排序数组 II
     * 有重复的数字的情况
     */
    public static boolean search_II(int[] nums, int target) {
        int len = nums.length;
        if(len < 2){
            return nums[0] == target;
        }
        int left = 0, right = len -1;
        while(left <= right){
            /**
             * 恢复二分的阶段性，让左右边界内的值存在阶段性
             */
            while(left < right && nums[left] == nums[left+1]){
                left++;
            }
            while(left < right && nums[right] == nums[right-1]){
                right--;
            }
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] >= nums[left]){  // 左边是有序的
                if(target >= nums[left] && nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{  // 右边是有序的
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * @Author Yang
     * @Date 2021/4/8 21:40
     * @Description 33. 搜索旋转排序数组
     * 无重复数字的情况
     */
    public static int search(int[] nums, int target){
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){  // 相等就直接输出
                return mid;
            }
            if(nums[left] <= nums[mid]){  // 如果是左边有序
                if(nums[left] <= target && nums[mid] > target){ // target是否是在有序的那一半
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{  // 右边有序
                if(nums[mid] < target && nums[right] >= target){  // target是否是在有序的那一半
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int search_III(int[] nums, int target){
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = len - 1;
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(nums[mid] >= nums[0]){
                left = mid ;
            }else{
                right = mid - 1;
            }
        }
        if(target >= nums[0]){
            left = 0;
        }else{
            left = left + 1;
            right = len - 1;
        }
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[right] == target ? right : -1;
     }

    public static void main(String[] args) {
        System.out.println(search_III(new int[]{3,1}, 1));
    }
}
