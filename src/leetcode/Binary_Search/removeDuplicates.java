package leetcode.Binary_Search;
/**
 * @Author Yang
 * @Date 2021/4/6 9:16
 * @Description 80. 删除有序数组中的重复项 II
 * 重复项最多出现两次
 * 左指针表示处理出的数组的长度， 右指针表示已检查过的数组的长度。
 * 当nums[slow-2] == nums[fast]时，表示有三个元素是相同的， 就不应该保留了。
 */
public class removeDuplicates {
    public static int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len <= 2){
            return len;
        }
        int slow = 2, fast = 2;
        while(fast < len){
            if(nums[slow-2] != nums[fast]){  // 这个判断条件很精髓  处理状态和检测状态的比较
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * @Author Yang
     * @Date 2021/4/6 10:39
     * @Description 26.删除有序数组的重复项
     * 每个只保留一次
     */
    public static int removeDuplicates_v1(int[] nums){
        int len = nums.length;
        if(len <= 1){
            return len;
        }
        if(len == 2){
            return nums[0] == nums[1] ? 1 : 2;
        }
        int slow = 1, fast = 1;
        while(fast < len){
            if(nums[slow-1] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates_v1(new int[]{1, 1, 1, 2, 2, 3, 3}));
    }
}
