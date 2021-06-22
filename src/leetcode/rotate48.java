package leetcode;
/*
给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
思路：和螺旋数组的方式相同，就是在宏观上找点，然后旋转，像剥洋葱的方式一层层的向内剥。
 */
public class rotate48 {
    public static void main(String[] args) {
        rotate48 t1 = new rotate48();
    }
    public void rotate(int[][] matrix)
    {
        if(matrix.length == 1)
        {
            return;
        }
        int xstart = 0;
        int ystart = 0;
        int xend = matrix.length-1;
        int yend = matrix.length-1;
        int temp = 0;
        while(xstart<xend)
        {
            int times = yend - ystart;
            int tmp = 0;
            for(int i = 0; i != times; i++)
            {
                temp = matrix[xstart][ystart+i];
                matrix[xstart][ystart+i] = matrix[xend-i][ystart];
                matrix[xend-i][ystart] = matrix[xend][yend-i];
                matrix[xend][yend-i] = matrix[xstart+i][yend];
                matrix[xstart+i][yend] = temp;
            }
            xstart++;
            ystart++;
            xend--;
            yend--;
        }
    }
}
