package leetcode.Array;

import javax.sound.midi.SoundbankResource;

public class findDuplicateTest287 {
    public static void main(String[] args) {
        findDuplicateTest287 t1 = new findDuplicateTest287();
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(t1.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums)
    {
        int i = 1;
        int j = nums.length-1;
        while(i < j)
        {
            int mid = (i+j) >> 1;
            int count = 0;
            for(int num: nums)
            {
                if(num <= mid)
                    count++;
                
            }
            if(count > mid)
                j = mid;
            else
                i = mid+1;
        }
        return i;
    }
}
