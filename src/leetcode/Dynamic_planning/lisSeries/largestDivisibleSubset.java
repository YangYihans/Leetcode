package leetcode.Dynamic_planning.lisSeries;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/23 9:46
 * @Description 368. 最大整除子集
 * 思路： 和LIS相同
 */
public class largestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0){
            return res;
        }
        int[] dp = new int[len];
        int maxLen = 0;
        int maxIndex = 0;
        // base case
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        for(int i = maxIndex; i >= 0; i--){
            if(nums[maxIndex] % nums[i] == 0 && dp[i] == maxLen){
                res.add(nums[i]);
                maxLen--;
                maxIndex = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        largestDivisibleSubset(new int[]{3,4,16,8});
    }
}
