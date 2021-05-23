package leetcode.Dynamic_planning.LCS;
/**
 * @Author Yang
 * @Date 2021/5/22 9:41
 * @Description 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 */
public class minimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int [][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++){
            dp[i][0] = dp[i-1][0] + chars1[i-1];
        }
        for(int j = 1; j <= len2; j++){
            dp[0][j] = dp[0][j-1] + chars2[j-1];
        }
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(chars1[i] == chars2[j]){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(dp[i][j+1] + chars1[i], dp[i+1][j] + chars2[j]);
                }
            }
        }
        return dp[len1][len2];

    }
}
