package leetcode.Array;

public class nextPermutation {
    public static void nextPermutation(int[] nums){
        int len = nums.length;
        int k = len - 1;
        while(k >= 1 && nums[k-1] >= nums[k]){ // 从后往前找到第一个减小的数
            k--;
        }
        if(k == 0){
            reverse(nums, 0, len-1);
        }else{  // 从这个数往后找到第一个比它大的数
            int index = k;
            while(index < len - 1 && nums[index+1] > nums[k-1]){
                index++;
            }
            swap(nums, k-1, index);  // 对两个数进行交换
            reverse(nums, k, len-1);  // 由于交换后的该位置的往后的值是递减的， 所以需要进行逆序
        }
    }

    private static void reverse(int[] nums, int left, int right) {
        while(left < right){
            swap(nums, left++, right--);
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1,3,5,4,1});
    }
}
