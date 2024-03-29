package leetcode.Dynamic_planning;

public class minDistanceTest72 {
    public static void main(String[] args) {
        minDistanceTest72 t1 = new minDistanceTest72();
    }
    public int minDistance(String word1, String word2)
    {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int len1 = word1Array.length;
        int len2 = word2Array.length;
        int [][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++)
        {
            dp[i][0] = i;
        }
        for(int j = 1; j < len2; j++)
        {
            dp[0][j] = j;
        }
        for(int i = 0; i < len1; i++)
        {
            for(int j = 0; j < len2; j++)
            {
                if(word1Array[i] == word2Array[j])
                {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }
                dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i+1][j]),dp[i][j+1]) + 1;
            }
        }
        return dp[len1][len2];
    }
}
