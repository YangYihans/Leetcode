package ByteDance.sort;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,42,5,2,34,1};
        //quickSort(arr,0, arr.length-1);
        quickSort1(arr,0,arr.length-1);
        for(int i= 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void quickSort(int[] arr, int L, int R)
    {
        if(L < R)
        {
            int[]p =  partition(arr, L , R);
            quickSort(arr, L, p[0]-1);
            quickSort(arr, p[1]+1, R);
        }
    }
    public static int[] partition(int[] arr, int l, int r)
    {
        int less = l - 1;
        int more = r;
        while(l < more)
        {
            if(arr[l] < arr[r])
            {
                swap(arr, ++less, l++);
            }
            else if(arr[l] > arr[r])
            {
                swap(arr, --more, l);
            }
            else
                l++;
        }
        swap(arr, more, r);
        return new int[]{less+1, more};
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort1(int [] arr, int L, int R)
    {
        if(arr.length == 0)
            return;
        int i = L;
        int j = R;
        int key = arr[(i+j)/2];
        while(i <= j)
        {
            while(arr[i] < arr[key])
            {
                i++;
            }
            while(arr[j] > arr[key])
                j--;
            if(i <= j)
            {
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        //上面的while保证了第一趟排序支点的左边比支点小，支点的右边比支点大。
        //左边再做排序，直到左边只剩下一个数。
        if(L < j)
            quickSort(arr,L,j);
        //右边再排序，直到右边只剩下一个数。
        if(i < R)
            quickSort(arr,i,R);
    }
}
