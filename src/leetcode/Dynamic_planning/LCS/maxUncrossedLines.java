package leetcode.Dynamic_planning.LCS;
/**
 * @Author Yang
 * @Date 2021/5/21 9:23
 * @Description 1035. 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 */
public class maxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m  = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];

    }
}
