package leetcode.Depth_First_Search;
/*
力扣200：岛屿数量
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
你可以假设网格的四个边均被水包围。
思路：和maxAreaOfIslandTest695的思路相同，DFS搜索。
 */
public class numIslandsTest200 {
    public static void main(String[] args) {
        numIslandsTest200 t1 = new numIslandsTest200();

    }
    public int numIslands(char[][] grid)
    {
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '0' || grid[i][j] == '9')
                    continue;
                if(grid[i][j] == '1')
                {
                    grid[i][j] = '9';
                    seedSearch(grid,i-1,j);
                    seedSearch(grid,i,j-1);
                    seedSearch(grid,i+1,j);
                    seedSearch(grid,i,j+1);
                    count ++;
                }
            }
        }
        return count;
    }
    public void seedSearch(char[][] grid, int x, int y)
    {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;
        if(grid[x][y] == '1')
        {
            grid[x][y] = '9';
            seedSearch(grid, x-1, y); //上
            seedSearch(grid,x,y-1); //左
            seedSearch(grid,x+1,y);//下
            seedSearch(grid,x,y+1); //右
        }
    }
}
