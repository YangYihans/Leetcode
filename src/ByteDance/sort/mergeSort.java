package ByteDance.sort;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,42,5,2,34,1};
        mergeSort(arr,0, arr.length-1);
        for(int i= 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void merge(int[] arr, int L, int mid, int R)
    {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= R)
        {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid)
        {
            help[i++] = arr[p1++];
        }
        while(p2 <= R)
        {
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++)
        {
            arr[L + i] = help[i];
        }
    }
    public static void mergeSort(int[] arr, int l, int r)
    {
        if(l == r)
            return;
        int mid = (r + l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
}
