package leetcode.Dynamic_planning;

import java.util.Arrays;

/**
 * @Author Yang
 * @Date 2021/4/6 11:34
 * @Description 516. 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 */
public class longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s){
        int len = s.length();
        if(len < 2){
            return 1;
        }
        char[] chars = s.toCharArray();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        // 遍历的顺序 反着遍历。
        for(int i = len - 1; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                if(chars[i] == chars[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}
