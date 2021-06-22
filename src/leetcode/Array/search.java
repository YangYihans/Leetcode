package leetcode.Array;

public class search {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2,3};
        System.out.println(search(nums,0));
    }
    public static int search(int[] nums, int target)
    {
        int r = nums.length-1;
        int l = 0;
        int mid;
        if(nums.length == 2)
        {
            if(nums[0] == target)
                return 0;
            else if(nums[1] == target)
                return 1;
            else
                return -1;
        }
        while(l <= r)
        {
            mid = l + (r-l)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[l] < nums[mid])
            {
                if(nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else
            {
                if(nums[mid] < target && nums[l] >= target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
