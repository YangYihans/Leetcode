package leetcode.Back_Trace;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣994题：腐烂的橘子
 * 在给定的网格中，每个单元格可以有三个值之一，0代表空单元格，1代表新鲜的橘子，2代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子相邻的新鲜橘子都会腐烂
 * 返回直到单元格中没有新鲜橘子为止所经过的最小的分钟数，如果不可能返回-1.
 * 思路：深度优先遍历 模板
 */
public class orangesRottingTest994 {
    public static void main(String[] args) {
        orangesRottingTest994 t1 = new orangesRottingTest994();
        int [][] gird = new int[][]{{2,1,1},{0,1,1},{1,0,1}}; //数组的输入
        System.out.print(t1.orangesRotting(gird));
    }
    public int orangesRotting(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int []> queue = new LinkedList<>();
        int count = 0; //表示新鲜的橘子的数量
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
                else if(grid[i][j] == 1)
                    count++;
            }
        }
        int times = 0; //表示腐烂的次数
        while(count>0 && !queue.isEmpty())
        {
            times++;
            int n = queue.size();
            for(int i = 0; i < n; i++)
            {
                int[] pos = queue.poll(); //弹出腐烂橘子的坐标
                int r = pos[0];
                int c = pos[1];
                if(r>=1 && grid[r-1][c] == 1) //腐烂橘子的上面
                {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1,c});
                }
                if(r+1 < row && grid[r+1][c] ==1) //腐烂橘子的下面
                {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1,c});
                }
                if(c>=1 && grid[r][c-1] ==1) //腐烂橘子的左边
                {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if(c+1 < col && grid[r][c+1] ==1) //腐烂橘子的右边
                {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }
        if(count > 0)
        {
            return -1;
        }
        return times;
    }

}
