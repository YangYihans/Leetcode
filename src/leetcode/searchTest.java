package leetcode;
/*
力扣33题：搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
        搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
        你可以假设数组中不存在重复的元素。
        你的算法时间复杂度必须是 O(log n) 级别。

        示例 1:
        输入: nums = [4,5,6,7,0,1,2], target = 0
        输出: 4
        示例 2:
        输入: nums = [4,5,6,7,0,1,2], target = 3
        输出: -1
*/
public class searchTest {
    public static void main(String [] args)
    {
       String  s;

    }
    public int search(int[] nums, int target)
    {
        int r = nums.length-1;
        int l = 0;
        int mid;
        if(r == 1)
        {
            if(nums[0] == target)
                return 0;
            if(nums[1] == target)
                return 1;
            else
                return -1;
        }
        while(l<=r)
        {
            mid = l+(r-l)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[l]<=nums[mid]) //前半部分是有序的
            {
               if(nums[l]<=target && nums[mid]>target)
               {
                   r = mid - 1;
               }
               else
                   l = mid + 1;
            }
            else //前半部分是无序的
            {
                if(nums[mid]<=target && nums[l]>target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }


}
