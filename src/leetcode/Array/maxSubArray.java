package leetcode.Array;

public class maxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums)
    {
        int ans = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(sum > 0)
                sum += nums[i];
            else
                sum = nums[i];
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
