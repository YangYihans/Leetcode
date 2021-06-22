package leetcode.Dynamic_planning;
/**
 * @Author Yang
 * @Date 2021/4/10 15:50
 * @Description 44. 通配符匹配
 * LCS类问题
 */
public class isMatch {
    public boolean isMatch(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();
        char[] char_s = s.toCharArray();
        char[] char_p = p.toCharArray();
        boolean[][] dp = new boolean[len_p+1][len_s+1];
        dp[0][0] = true;
        for(int i = 1; i <= len_p; i++){
            if(char_p[i-1] != '*'){
                break;
            }
            dp[i][0] = true;
        }
        for(int i = 1; i <= len_p; i++){
            for(int j = 1; j <= len_s; j++){
                if(char_p[i-1] == char_s[j-1] || char_p[i-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(char_p[i-1] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[len_p][len_s];
    }
}
