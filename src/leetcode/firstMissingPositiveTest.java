package leetcode;

import java.util.Arrays;

/*41.
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
示例 1:
输入: [1,2,0]
输出: 3
示例 2:
输入: [3,4,-1,1]
输出: 2
示例 3:
输入: [7,8,9,11,12]
输出: 1
说明:你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class firstMissingPositiveTest {
    public static void main(String [] args)
    {
        firstMissingPositiveTest t1 = new firstMissingPositiveTest();
        int [] a = new int[]{};
        System.out.println(t1.firstMissingPositive(a));
    }
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int temp = 1;
        int dif = 0;
        if(n == -1 )
            return 1;
        if(n == 0)
        {
            if(nums[0] == 1)
                return 2;
            else
                return 1;
        }
        else {
            for (int i = 0; i < n; i++) {
                if (nums[0] > 1)
                    return 1;
                if (nums[i] < 0 && nums[i + 1] > 1) {
                    nums[i] = 0;
                    dif = nums[i + 1] - nums[i];
                }
                if (nums[i] >= 0)
                    dif = nums[i + 1] - nums[i];
                if (dif > 1) {
                    temp = nums[i] + 1;
                    return temp;
                }
            }
            if (nums[n] >= 0)
                return nums[n] + 1;
            else
                return 1;

        }
    }
}
