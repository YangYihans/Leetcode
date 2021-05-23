package leetcode.Dynamic_planning.LCS;
/**
 * @Author Yang
 * @Date 2021/5/21 9:51
 * @Description 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 */
public class minDistance {
    public int minDistance(String word1, String word2){
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= len2; j++){
            dp[0][j] = j;
        }
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(words1[i] == words2[j]){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j]), dp[i][j+1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
