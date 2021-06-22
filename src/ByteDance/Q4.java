package ByteDance;

import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        process(new int[]{1793, 140, 1187, 199, 722, 1067, 817, 324, 1499, 805, 1910, 1811, 1365, 509, 1255, 1393, 1098, 594, 309, 518, 218, 393, 1270, 1788, 1710,
                1858, 1284, 1213, 888, 639, 467, 1404, 691, 1623, 1969, 129, 52, 504, 559, 816, 1980, 1675, 1355, 1722, 1506, 1931, 464, 168, 1845, 1321});
    }

    public static void process(int[] nums){
        int n = nums.length;
        if(n < 3){
            System.out.println(0);
            System.out.println(0);
            return;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 2);
        for(int i = 2; i < n; i++){
            for(int j = 1; j < i; j++){
                if(nums[i] == (nums[j] * nums[j-1]) % 2021){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
