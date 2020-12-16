import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sort {
    /**
     * @Author Yang
     * @Date 2020/12/13 11:48
     * @Description 颜色分类
     * 荷兰三色国旗问题
     */
    public static void sortColors(int[] nums){
        if(nums == null || nums.length < 2)
            return;
        int left = 0;
        int right = nums.length - 1;
        for(int i = left; i <= right; i++){
            if(nums[i] == 0){
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }else if(nums[i] == 2){
                nums[i] = nums[right];
                i--;
                nums[right] = 2;
                right--;
            }
        }
        return;
    }

    /**
     * 荷兰三色旗的模板解法
     * @param nums
     */
    public static void sort_partition(int[] nums){
        if(nums == null || nums.length < 2)
            return;
        /**
         * [0, left)       ---> 0
         * [left, i)       ---> 1
         * [right, len -1) ---> 2
         */
        int left = -1;
        int right = nums.length - 1;
        int i = 0;
        while(i <= right){
            if(nums[i] == 0){
                left++;
                swap(nums, i, left);
                i++;
            }else if(nums[i] == 1){
                i++;
            }else {
                /**
                 * 交换完成之后，当前位置的值未知，所以对i不进行操作，继续判断
                 */
                swap(nums, i, right);
                right--;
            }
        }
        return;
    }

    /**
     * @Author Yang
     * @Date 2020/12/13 15:04
     * @Description 查找第K大的元素
     */
    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k ;
        while(true){
            int index = partition(nums, left, right);
            if(index == target){
                return nums[index];
            }else if(index < target){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }
    }
    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int j = left;
        for(int i = left + 1; i <= right; i++){
            if(nums[i] < pivot){
                j++;
                swap(nums, j, i);
            }
        }
        /**
         * 在遍历的过程中，满足[left+1, j) < pivot [j+1, right) > pivot
         */
        swap(nums, j, left);
        /**
         * 交换后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
         */
        return j;
    }

    /**
     * @Author Yang
     * @Date 2020/12/14 10:51
     * @Description 找出峰值元素
     * 因为nums[-1] = nums[∞] = -1 所以只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
     */
    public int findPeakElement(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * @Author Yang
     * @Date 2020/12/14 10:58
     * @Description 在排序数组中查找元素的第一个和最后一个位置
     * 这个方法比较笨，先使用二分查找命中target，然后对其左右进行遍历找出他的区间。
     */
    public int[] searchRange(int[] nums, int target){
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid;
                right = mid;
                while(left > 0 && nums[left] == nums[left-1]){
                    left--;
                }
                while(right < nums.length-1 && nums[right] == nums[right + 1]){
                    right++;
                }
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * @Author Yang
     * @Date 2020/12/14 11:09
     * @Description 合并区间
     * 这道题做复杂了， 既然是排好序的，极小值是不用管的了， 只需要每次比较极大值即可
     * 需要注意i++的位置
     */
    public static int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        int i = 0, len = intervals.length - 1, left = 0, right = 0;
        while(i <= len){
            if(i < len && intervals[i][1] < intervals[i+1][0]){
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
                if(i == len){
                    list.add(new int[]{intervals[i][0], intervals[i][1]});
                    break;
                }
                continue;
            }else if(i < len && intervals[i][1] >= intervals[i+1][0]){
                left = Math.min(intervals[i][0], intervals[i+1][0]);
                right = Math.max(intervals[i][1], intervals[i+1][1]);
                i++;
                while(i < len && right >= intervals[i+1][0]){
                    left = Math.min(left,intervals[i+1][0]);
                    right = Math.max(right,intervals[i+1][1]);
                    i++;
                }
                list.add(new int[]{left, right});
                i++;
                if(i == len){
                    list.add(new int[]{intervals[i][0], intervals[i][1]});
                    break;
                }
            }
        }
        int[][] result = list.toArray(new int[list.size()][2]);
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/12/16 11:23
     * @Description 合并区间的简易版本
     * 因为数组是排好序的， 只需要比较头一个区间和尾部和下一个区间头部的关系。
     */
    public static int[][] merge_v2(int[][] intervals){
        if(intervals == null || intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);  //sorted
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        int i = 1, len = intervals.length - 1;
        while(i <= len){
            int tail = list.get(list.size() -1)[1];
            if(intervals[i][0] <= tail){
                int end = Math.max(tail, intervals[i][1]);
                list.set(list.size() - 1, new int[]{list.get(list.size() -1)[0], end});
            }else{
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            i++;
        }
        int[][] result = list.toArray(new int[list.size()][2]);
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/12/16 10:54
     * @Description 搜索旋转数组
     * 二分查找的思利用原本数组是已排好序的数组，所以只考虑已排序段和未有序段。
     * 每次比较先看是否再已排序段中，否则直接放入未排序段。
     */
    public int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){ // [left , target , mid)
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[right]){  //[mid , target, right]
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * @Author Yang
     * @Date 2020/12/16 11:29
     * @Description 二维搜素矩阵
     * 对于一个行列数值均是递增的二维数组进行搜索
     */
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col -1;
        while(i < row && i >=0 && j < col && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        int[][] intervals = new int[][]{{1,4},{4,5},{3,9},{1,7},{10,12}};
        merge(intervals);
        sortColors(nums);
    }
}
