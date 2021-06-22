package leetcode.Array;

public class pivotIndexTest724 {
    public static void main(String[] args) {
        pivotIndexTest724 t1 = new pivotIndexTest724();
        int[] nums = new int[]{1,2,3};
        System.out.println(t1.pivotIndex(nums));
    }
    public int pivotIndex(int[] nums)
    {
        int len = nums.length;
        int count = 0;
        int mid = 0;
        for(int i = 0; i < len; i++)
        {
            count += nums[i];
        }
        for(int i = 0; i < len; i++)
        {
            if(mid*2 + nums[i] == count)
            {
                return i;
            }
            else
            {
                mid += nums[i];
            }
        }
        return -1;
    }
}
