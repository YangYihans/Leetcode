package leetcode.Depth_First_Search;

public class updateMatrixTest542 {
    public static void main(String[] args) {
        updateMatrixTest542 t1 = new updateMatrixTest542();
        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] res = t1.updateMatrix(matrix);
        for(int i = 0; i < res.length; i++)
        {
            for(int j = 0; j < res[0].length; j++)
            {
                System.out.println(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] updateMatrix(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(matrix[i][j] == 0)
                    continue;
                else
                {
                  int count = search(matrix,i,j);
                  matrix[i][j] = count;
                }
            }
        }
        return matrix;
    }
    public int search(int[][] matrix, int i, int j)
    {
        if(i < 0 || i ==matrix.length || j < 0 || j == matrix[0].length || matrix[i][j] == 0)
            return 0;


        return 0;
    }
}
