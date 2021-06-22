package ByteDance.sort;

/**
 * 堆排序
 * 先组成一个大根堆
 * 将堆顶和最后一个元素交换，最大的就是最后的一个值
 * 最后的一个元素到堆顶
 * 调整： 先选出左右孩子中的最大值
 *        然后如果比它大就直接结束
 *        如果比它小就交换， 继续调整它为最大堆
 */
public class heapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,42,5,2,34,1};
        heapSort(arr);
        for(int i= 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void heapSort(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return;
        for(int i = 0; i < arr.length; i++)
        {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while(size > 0)
        {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }
    //构建堆， 每次和他的父节点进行比较，如果比它大就交换。
    public static void heapInsert(int[] arr, int index)
    {
        while(arr[index] > arr[(index-1)/2])
        {
            swap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }
    public static void heapify(int[] arr, int index, int heapSize)
    {
        int left = index * 2 + 1;
        while(left < heapSize)
        {
            //左右孩子哪个大
            int largest = left + 1 < heapSize && arr[left] < arr[left+1] ? left+1 : left;
            //当前值和左右孩子中最大的那个比较
            largest = arr[largest] > arr[index] ? largest : index;
            //如果比孩子都大就直接退出。
            if(largest == index)
                break;
            swap(arr, index, largest);
            index = largest;
            left = (index * 2) + 1;
        }
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
