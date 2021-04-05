package leetcode.Dynamic_planning;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
/*
力扣62：不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
 */
public class uniquePathsTest62 {
    public static void main(String[] args) {
        uniquePathsTest62 t1 = new uniquePathsTest62();
        //System.out.print(t1.uniquePaths(7,3));
        int[][] a = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        //System.out.print(t1.uniquePathsWithObstacles(a));
        System.out.print(t1.minPathSum(a));
    }

    /**
     * 动态规划的经典例题：机器人某一位置的走法是上面一格和左面一格的走法之和
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n)
    {
        if(m== 0 || n == 0)
            return 0;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 遇到障碍，障碍处的路径直接设为0，如果是第一行或者第一列需要单独讨论
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        if(m == 0) //抠条件
            return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) //抠条件
            return 1;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        int dp[][] = new int[m][n];
        //dp[0][0] = 1;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                {
                    if(i == 0 && j == 0)
                        dp[i][j] = 1;
                    else if(i == 0 && j != 0)
                        dp[i][j] = dp[i][j-1];
                    else if(j == 0 && i != 0)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 最短路径：反向推理，动态规划，
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = m - 1; i >= 0; i--)
        {
            for(int j = n - 1; j >= 0; j--)
            {
                if(i == m-1 && j == n-1)
                    dp[i][j] = grid[i][j];
                else if(i == m-1 && j != n-1)
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                else if(j == n-1 && i != m-1)
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
}
