package leetcode.Array;

import javax.sound.midi.SoundbankResource;
import javax.xml.transform.Source;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] res = twoSum((nums),9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    public static int[] twoSum(int[] sum, int target)
    {
        int len = sum.length;
        if(len < 2)
            return new int[]{};
        int l = 0;
        int r = len - 1;
        while(l < r)
        {
            if(sum[l]+sum[r] == target)
                return new int[]{sum[l], sum[r]};
            else if(sum[l] + sum[r] > target)
            {
                r--;
            }
            else
            {
                l++;
            }
        }
        return new int[]{};
    }
}
