package leetcode.Binary_Search;

public class moveZeros {
    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        for(; left < right; left++){
            nums[left] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
