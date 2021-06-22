package leetcode.Depth_First_Search;

/*
力扣695：求围成的岛屿的最大的面积
 */
public class maxAreaOfIslandTest695 {
    int area = 0;
    public static void main(String[] args) {
        maxAreaOfIslandTest695 t1 = new maxAreaOfIslandTest695();
        int [][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.print(t1.maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int [][] grid)
    {
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        int maxArea = 0;
        int count = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0 || grid[i][j] == 9)
                    continue;
                if(grid[i][j] == 1)
                {
                    grid[i][j] = 9;
                    area = 1;
                    seedSearch(grid,i-1,j);
                    seedSearch(grid,i,j-1);
                    seedSearch(grid,i+1,j);
                    seedSearch(grid,i,j+1);
                }
                if(area >= maxArea)
                    maxArea = area;
            }
        }
        return maxArea;

    }

    /**
     * DFS思想，每检测到一个1，就将他的上下左右邻近单元进行检索，如果是1则继续递归。
     * @param grid 传入的方阵
     * @param x 需要检测的横坐标
     * @param y 需要检测的纵坐标
     */
    public void seedSearch(int[][] grid, int x, int y)
    {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;
        if(grid[x][y] == 1)
        {
            grid[x][y] = 9;
            area++;
            seedSearch(grid, x-1, y); //上
            seedSearch(grid,x,y-1); //左
            seedSearch(grid,x+1,y);//下
            seedSearch(grid,x,y+1); //右
        }
    }
}
