package ByteDance.Number;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

/**
 * @Author Yang
 * @Date 2021/3/24 15:38
 * @Description 215.数组中第k大的元素
 */
public class findKthLargest {
    public static int findKthLargest(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while(true){
            int index = partition(nums, left, right);
            if(target == index){
                return nums[target];
            }else if(target < index){
                right = index - 1;
            }else{
                left = index + 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for(int i = j + 1; i < nums.length; i++){
            if(nums[i] < pivot){
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j, left);
        return j;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        findKthLargest(new int[]{4,2,1,7,5,3}, 2);
    }
}
