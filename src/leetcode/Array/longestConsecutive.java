package leetcode.Array;

import java.util.HashSet;

/**
 * 最长上升序列
 */
public class longestConsecutive {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            if(!set.contains(num-1))
            {
                int count = 0;
                while(set.contains(num))
                {
                    count++;
                    num = num + 1;
                }
                if(count > max)
                    max = count;
            }
        }
        return max;
    }

    public int longestConsecutiveTest(int[] nums)
    {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums)
        {
            hashSet.add(num);
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            if(!hashSet.contains(num - 1))
            {
                int count = 0;
                while(hashSet.contains(num))
                {
                    count++;
                    num++;
                }
                if(count > max)
                    max = count;
            }
        }
        return max;
    }
}
