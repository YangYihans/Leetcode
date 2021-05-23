package leetcode.Dynamic_planning.LCS;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Yang
 * @Date 2021/4/5 11:47
 * @Description 583. 两个字符串的删除操作
 * 借鉴lcs的模板，画图进行分析
 */
public class minDistance_delete {
    public int minDistance_delete(String word1, String word2) {
        int len_word1 = word1.length();
        int len_word2 = word2.length();
        int[][] dp = new int[len_word1+1][len_word2+1];
        char[] char_word1 = word1.toCharArray();
        char[] char_word2 = word2.toCharArray();
        // base case
        dp[0][0] = 0;
        for(int i = 1; i <= len_word1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= len_word2; j++){
            dp[0][j] = j;
        }
        // transfer  画图可以看出来
        for(int i = 0; i < len_word1; i++){
            for(int j = 0; j < len_word2; j++){
                // 如果这两个值相等， 就不进行操作
                if(char_word1[i] == char_word2[j]){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    // 否则就选择左或者上的最小值+1
                    dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j]) + 1;
                }
            }
        }
        return dp[len_word1][len_word2];
    }
}
