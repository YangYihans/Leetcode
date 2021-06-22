package leetcode.Array;
/*
73.矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class setZerosTest {
    public static void main(String[] args) {
        setZerosTest t1 = new setZerosTest();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        t1.setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
    public void setZeroes(int[][] matrix)
    {
        int row = matrix.length;
        if(row == 0)
            return;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col;  j++)
            {
                if(matrix[i][j] == 0)
                {
                    search(matrix,i,j);
                }
            }
        }
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(matrix[i][j] == -10000)
                    matrix[i][j] = 0;
            }
        }
    }
    public void search(int[][] matrix, int i, int j)
    {
        for(int x = 0; x < matrix.length; x++)
        {
            if(x == i)
                continue;
            if(matrix[x][j] == 0)
            {
                matrix[x][j] = 0;
                continue;
            }

            if(matrix[x][j] == -10000)
                continue;
            else
                matrix[x][j] = -10000;
        }
        for(int y = 0; y < matrix[0].length; y++)
        {
            if(y == j)
                continue;
            if(matrix[i][y] == 0)
            {
                matrix[i][y] = 0;
                continue;
            }

            if(matrix[i][y] == -10000)
                continue;
            else
                matrix[i][y] = -10000;
        }
    }
}
