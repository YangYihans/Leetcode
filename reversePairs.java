import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class reversePairs {
    /**
     * 归并排序的经典例题
     */
    public static void merge(int[] nums, int start, int end){
        if(start == end)
            return;
        int mid = start + (end- start) / 2;
        // 递归分块
        merge(nums, start, mid);
        merge(nums, mid+1, end);
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        // 大小比较赋值到temp中
        while(i <= mid && j <= end){
            temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while(i <= mid){
            temp[index++] = nums[i++];
        }
        while(j <= end){
            temp[index++] = nums[j++];
        }
        // 将temp数组复制到nums数组中，分别确定起始位置和长度
        System.arraycopy(temp,0, nums, start, end-start+1);
    }

    /**
     * @Author Yang
     * @Date 2020/11/28 15:06
     * @Description 数组中的逆序对，使用的就是归并排序的思想。
     */
    public static int reversePairs_1(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        return reversePairsMerge(nums, 0, nums.length-1);
    }
    public static int reversePairsMerge(int[] nums, int start, int end){
        if(start == end){
            return 0;
        }
        int mid = start + (end - start) / 2;
        int num1 = reversePairsMerge(nums, 0, mid);
        int num2 = reversePairsMerge(nums, mid+1, end);
        int result = num1 + num2;
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= end){
            result += nums[i] <= nums[j] ? j - (mid + 1) : 0;
            temp[index++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        // 当前半部分还没有排列完 说明还是存在逆序对的
        while(i <= mid){
            result += j - (mid + 1);
            temp[index++] = nums[i++];
        }
        // 当后半部分还没有排列完 这时候就不存在逆序对了
        while(j <= end){
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, end-start+1);
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/11/29 10:32
     * @Description 计算右侧小于当前元素的个数
     */
    public List<Integer> countSmaller(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[len];
        int[] res = new int[len];
        // 创建索引数组
        int[] index = new int[len];
        for(int i = 0; i < len; i++){
            index[i] = i;
        }
        mergeAndCountSmaller(nums, 0, nums.length-1, index, temp, res);
        for(int i = 0; i < len; i++){
            result.add(res[i]);
        }
        return result;
    }
    public void mergeAndCountSmaller(int[] nums, int left, int right, int[] index, int[] temp, int[] res){
        if(left == right)
            return;
        int mid = left + (right - left) / 2 ;
        mergeAndCountSmaller(nums, left, mid, index, temp, res);
        mergeAndCountSmaller(nums, mid + 1, right, index, temp, res);
        // 如果归并数组是有序的， 就不需要进行合并
        if(nums[index[mid]] <= nums[index[mid+1]]){
            return;
        }
        mergeOfTwoSortedArr(nums, left, mid, right, index, temp, res);
    }
    public void mergeOfTwoSortedArr(int[] nums, int left, int mid, int right, int[] index, int[] temp, int[] res){
        for(int i = left;  i <= right; i++){
            temp[i] = index[i];
        }
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++){
            if (i > mid) {
                index[k] = temp[j];
                j++;
            } else if (j > right) {
                index[k] = temp[i];
                i++;
                res[index[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                // 注意：这里是 <= ，保证稳定性
                index[k] = temp[i];
                i++;
                res[index[k]] += (j - mid - 1);
            } else {
                index[k] = temp[j];
                j++;
            }
        }
    }
}
