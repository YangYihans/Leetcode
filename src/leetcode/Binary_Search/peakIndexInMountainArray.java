package leetcode.Binary_Search;

/**
 * 852. 山脉数组的峰顶索引
 */
public class peakIndexInMountainArray {
    /**
     * 根据 arr[i-1] < arr[i] 在 [1,n-1] 范围内找值峰顶
     * 元素为符合条件的最靠近中心的元素
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 1, right = len - 1;
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(arr[mid - 1] < arr[mid]){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
}
