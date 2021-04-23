package leetcode.Breadth_First_Search;

import java.util.ArrayList;
import java.util.List;

/*
1162.地图分析
在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。
其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
如果我们的地图上只有陆地或者海洋，请返回 -1。
 */
public class maxDistanceTest1162 {
    public static void main(String[] args) {
        maxDistanceTest1162 t1 = new maxDistanceTest1162();
    }
    public int maxDistance(int[][] grid)
    {
        List<Point> list = new ArrayList<Point>();
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                    list.add(new Point(i,j));
            }
        }
        if(list.size() == 0  || list.size() == grid.length * grid[0].length)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        int landCount = list.size();
        int mapCount = m * n;
        int seaCount = mapCount - landCount;
        int res = getMaxDistance(grid,list,seaCount,0);
        return res;
    }
    public int getMaxDistance(int[][] grid, List<Point> list, int seaCount, int res)
    {
        int m = grid.length;
        int n = grid[0].length;
        List<Point> addLand = new ArrayList<>();
        for(int i = 0; i < list.size(); i++)
        {
            Point point = list.get(i);
            if(point.x - 1 >= 0)
            {
                if(grid[point.x-1][point.y] != 1)
                {
                    seaCount--;
                    grid[point.x-1][point.y] = 1;
                    addLand.add(new Point(point.x-1,point.y));
                }
            }
            if(point.y - 1 >= 0)
            {
                if(grid[point.x][point.y-1] != 1)
                {
                    seaCount--;
                    grid[point.x][point.y-1] = 1;
                    addLand.add(new Point(point.x, point.y-1));
                }
            }
            if(point.x + 1 < m)
            {
                if(grid[point.x+1][point.y] != 1)
                {
                    seaCount--;
                    grid[point.x+1][point.y] = 1;
                    addLand.add(new Point(point.x+1,point.y));
                }
            }
            if(point.y + 1 < n)
            {
                if(grid[point.x][point.y+1] != 1)
                {
                    seaCount--;
                    grid[point.x][point.y+1] = 1;
                    addLand.add(new Point(point.x,point.y+1));
                }
            }
        }
        res++;
        if(seaCount > 0)
        {
            return getMaxDistance(grid,addLand,seaCount,res);
        }
        return res;
    }
    class  Point{
        int x;
        int y;
        public Point(int i, int j)
        {
            this.x = i;
            this.y = j;
        }
    }

}
