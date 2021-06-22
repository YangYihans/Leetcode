package ByteDance.sort;

import java.util.Scanner;

/**
 * 冒泡排序： 两两相互比较，把大的数向后移动，最后一个数就是最大的数
 * 每次减少一个数的范围，保证每次循环到最后的一个数就是当前排序中最大的一个数。
 */
public class BubbleSort {
    public static void main(String[] args)
    {

        int[] arr = new int[]{1,3,42,5,2,34,1};
        bubbleSort(arr);
        for(int i= 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void bubbleSort(int[] arr)
    {
        if(arr == null || arr.length < 2)
            return;
        for(int end = arr.length-1; end > 0; end--)
        {
            for(int i = 0; i < end; i++)
            {
                if(arr[i]> arr[i+1])
                    swap(arr, i, i+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
