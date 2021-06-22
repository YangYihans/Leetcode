package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/*
54。螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class spiralOrderTest54 {
    public static void main(String[] args) {
        spiralOrderTest54 t1 = new spiralOrderTest54();
        int [][] a = new int [3][4];
        t1.spiralOrder(a);
    }
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length; //行
        int n = matrix[0].length; //列
        int xstart = 0;
        int ystart = 0;
        int xend = m-1;
        int yend = n-1;
        while(res.size() <= m*n)
        {
            for(int j = xstart; j <= yend; j++)
            {
               res.add(matrix[xstart][j]);
            }
            for(int i = xstart+1; i <= xend; i++)
            {
                res.add(matrix[i][yend]);
            }
            for(int j = yend-1; j>=ystart; j--)
            {
                res.add(matrix[xend][j]);
            }
            for(int i = xend-1; i >= xstart+1; i--)
            {
                res.add(matrix[i][ystart]);
            }
            xstart = xstart + 1;
            ystart = ystart + 1;
            yend = yend - 1;
            xend = xend - 1;
        }
        return res;
    }

}
