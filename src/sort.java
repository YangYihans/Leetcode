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

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
    }
}
