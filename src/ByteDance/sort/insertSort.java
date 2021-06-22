package ByteDance.sort;

/**
 * 从前往后依次去固定一个数，将后面的数和前面的数依次比较插入。
 * 当前数前面的数始终是有序的。
 */
public class insertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,42,5,2,34,1};
        insertSort(arr);
        for(int i= 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void insertSort(int[] arr)
    {
        if(arr == null || arr.length < 2)
            return;
        for(int i = 1; i < arr.length; i++)
        {
            for(int j = i -1; j >= 0 && arr[j] > arr[j+1]; j--)
            {
                swap(arr, j, j+1);
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
