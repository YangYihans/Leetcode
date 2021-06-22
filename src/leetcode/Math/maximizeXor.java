package leetcode.Math;

import java.util.Arrays;

/**
 * @Author Yang
 * @Date 2021/5/23 9:56
 * @Description 1707. 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 */
public class maximizeXor {
    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int len = queries.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++){
            int x = queries[i][0];
            int m = queries[i][1];
            int max = -1;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] <= m){
                    max = Math.max(max, nums[j] ^ x);
                }else{
                    break;
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        maximizeXor(new int[]{5,2,4,6,6,3}, new int[][]{{12 ,4}, {8, 1}, {6, 3}});
    }
}
