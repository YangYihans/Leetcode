package leetcode.Dynamic_planning;
/**
 * @Author Yang
 * @Date 2021/4/5 17:11
 * @Description 674. 最长连续递增序列
 */
public class findLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len < 1){
            return 0;
        }
        if(len == 1){
            return 1;
        }
        if(len == 2){
            return nums[0] < nums[1] ? 2 : 1;
        }
        int max = 1, res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                max++;
                res = Math.max(max, res);
            }else{
                max = 1;
            }
        }
        return Math.max(res, max);


    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
}
