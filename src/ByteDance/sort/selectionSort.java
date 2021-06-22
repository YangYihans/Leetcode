package ByteDance.sort;

/**
 * 每次选择一个最小的数放在最前面，每个确定一个数，依次向后进行操作；
 */
public class selectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,42,5,2,34,1};
       selectionSort(arr);
        for(int i= 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void selectionSort(int[] arr)
    {
        if(arr == null || arr.length < 2)
            return;
        for(int i = 0; i < arr.length; i++)
        {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                minIndex = arr[j] < arr[minIndex]? j : minIndex;
            }
            swap(arr, i , minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
