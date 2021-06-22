package leetcode;
/*
912.排序数组
给你一个整数数组 nums，将该数组升序排列。
 */
public class sortArrayTest912 {
    public static void main(String[] args) {
        sortArrayTest912 t1 = new sortArrayTest912();
        int[] nums = new int[]{5,2,3,1};
        //int[] res = t1.sortArray(nums);
        //int[] res = t1.selectionSort(nums);
        int[] res = t1.insertionSort(nums);
        for(int i = 0; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }

    /**
     * 冒泡排序：两两相互比较，把大的数向后移动，最后一个数就是最大的数。
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums)
    {
        if(nums == null ||nums.length < 2)
            return nums;
        for(int end = nums.length-1; end > 0; end--)
        {
            for(int i = 0; i < end; i++)
            {
                if(nums[i] > nums[i+1])
                {
                    swap(nums,i,i+1);
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序：每次选择最小的数放在最前面，每次确定一个数。
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums)
    {
        if(nums == null || nums.length < 2)
            return nums;
        for(int i = 0; i < nums.length-1; i++)
        {
            int minIndex = i;
            for(int j = i + 1; j < nums.length; j++)
            {
                minIndex = nums[j] < nums[minIndex]? j : minIndex;
            }
            swap(nums,i, minIndex);
        }
        return nums;
    }

    /**
     * 插入排序：从前往后依次固定一个数，然后将后面的数和前面的数依次比较插入。
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums)
    {
        if(nums == null || nums.length < 2)
        return nums;
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = i-1; j >=0 && nums[j] > nums[j+1]; j--)
            {
                swap(nums, j, j+1);
            }
        }
        return nums;
    }
    public void merge(int[] nums, int L, int R, int mid)
    {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while(p1 < mid && p2 <= R)
        {
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        //两个必有一个越界
        while(p1 <= mid)
        {
            help[i++] = nums[p1++];
        }
        while(p2 <= R)
        {
            help[i++] = nums[p2++];
        }
        for(i = 0; i < help.length; i++)
        {
            nums[L + i] = help[i];
        }
    }
    public int[] mergeSort(int[] nums)
    {
        if(nums == null || nums.length < 2)
            return nums;
        merge(nums,0,nums.length-1,(nums.length-1)/2);
        return nums;
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
