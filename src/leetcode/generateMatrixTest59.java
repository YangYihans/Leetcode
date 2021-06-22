package leetcode;
/*
59.螺旋矩阵
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
思路：剥洋葱一样一层一层的，从外到里，循环终止条件是到达n²，用左右上下四个点来标记矩阵的大小。
 */
public class generateMatrixTest59 {
    public static void main(String[] args) {
        generateMatrixTest59 t1 = new generateMatrixTest59();
        int [][] res = t1.generateMatrix(3);
    }
    public int[][] generateMatrix(int n)
    {
        int [][] res = new int[n][n];
        if(n == 0)
            return res;
        if(n == 1)
        {
            res[0][0] = 1;
            return res;
        }
        int target = n*n;
        int num = 1;
        int xstart = 0;
        int ystart = 0;
        int xend = n-1;
        int yend = n-1;
        while(num <= target)
        {
            for(int j = xstart; j <= yend; j++)
            {
                res[xstart][j] = num;
                num++;
            }
            for(int i = xstart+1; i <= xend; i++)
            {
                res[i][yend] = num;
                num++;
            }
            for(int j = yend-1; j>=ystart; j--)
            {
                res[xend][j] = num;
                num++;
            }
            for(int i = xend-1; i >= xstart+1; i--)
            {
                res[i][ystart] = num;
                num++;
            }
            xstart = xstart + 1;
            ystart = ystart + 1;
            yend = yend - 1;
            xend = xend - 1;
        }
        return res;
    }
}
