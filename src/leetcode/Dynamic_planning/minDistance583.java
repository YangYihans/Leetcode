package leetcode.Dynamic_planning;

public class minDistance583 {
    public static void main(String[] args) {
        minDistance583 t1 = new minDistance583();


        String s1 = "vwojt";
        String s2 = "saqhgdrarwntji";
        System.out.println(t1.minDistance(s1,s2));
    }
    public int minDistance(String word1, String word2)
    {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int len1 = word1Array.length;
        int len2 = word2Array.length;
        int res = 0;
        if(len1 == 0)
        {
            for(int i = 0; i < len2; i++)
            {
                res += word2Array[i];
            }
            return res;
        }
        if(len2 == 0)
        {
            for(int i = 0; i < len1; i++)
            {
                res += word1Array[i];
            }
            return res;
        }
        int [][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++)
        {
            dp[i][0] = dp[i-1][0] + word1Array[i-1];
        }
        for(int j = 1; j <= len2; j++)
        {
            dp[0][j] = dp[0][j-1] + word2Array[j-1];
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
                dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1]+word1Array[i],dp[i+1][j]+word2Array[j]),dp[i][j]+word1Array[i]+word2Array[j]);
            }
        }
        return dp[len1][len2];
       /* int i = len1;
        int j = len2;
        int [] temp = new int[3];
        while(i>=0 && j>=0)
        {
            temp = search(dp,word1Array,word2Array,i,j,res);
            res = res + temp[2];
            i = temp[0];
            j = temp[1];
        }
        return res;*/
    }
   /* public int[] search(int[][]dp, char[] word1, char[] word2, int i, int j, int res)
    {
        int [] point = new int[3];
        if(i >= 1 && dp[i][j] == dp[i-1][j] + 1)
        {
            res += word1[i-1];
            point[0] = i-1;
            point[1] = j;
            point[2] = word1[i-1];
            return point;
        }

        if(j >=1 && dp[i][j] == dp[i][j-1] + 1)
        {
            res += word2[j-1];
            point[0] = i;
            point[1] = j - 1;
            point[2] = word2[j-1];
            return point;
        }

        if(i>=1 && j>=1 && dp[i][j] == dp[i-1][j-1] + 2)
        {
            res += word1[i-1]+word2[j-1];
            point[0] = i-1;
            point[1] = j-1;
            point[2] =  word1[i-1]+word2[j-1];
            return point;
        }
        point[0] = i - 1;
        point[1] = j - 1;
        point[2] = 0;
        return point;
    }*/
}
