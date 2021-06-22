package leetcode.Dynamic_planning;
/**
 * @Author Yang
 * @Date 2021/4/12 16:17
 * @Description 1312. 让字符串成为回文串的最少插入次数
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。请你返回让 s 成为回文串的 最少操作次数 。
 */
public class minInsertions {
    public static int minInsertions(String s){
        if(s == null || s.length() < 2){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = 0;
        }
        char[] chars = s.toCharArray();
        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(chars[i] == chars[j]){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("g"));
    }
}
