package leetcode.Dynamic_planning;
/**
 * @Author Yang
 * @Date 2021/4/5 10:53
 * @Description 1143.最长公共子序列
 * 模板类型题目
 * dp[i][j]表示对于s1[1...i]和s2[1...j]他们的LCS长度是dp[i][j]
 * 转移方程：如果s1[i] == s2[j]那么这个字符一定是在lck中， 否则至少有一个不在，就需要丢弃一个。
 */
public class longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2){
        int len_text1 = text1.length();
        int len_text2 = text2.length();
        char[] text1_char = text1.toCharArray();
        char[] text2_char = text2.toCharArray();
        int[][] dp = new int[len_text1 + 1][len_text2 +1 ];
        // base case
        for(int i = 0; i <= len_text1; i++){
            dp[i][0] = 0;
        }
        // base case
        for(int j = 0; j <= len_text2; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i < len_text1; i++){
            for(int j = 0; j < len_text2; j++){
                // transfer
                if(text1_char[i] == text2_char[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[len_text1][len_text2];
    }
}
