package leetcode.Array;

public class rotateTest {
    public static void main(String[] args) {
        rotateTest t1 = new rotateTest();
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        t1.rotate(matrix);
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 1)
            return;
        int xStart = 0;
        int yStart = 0;
        int xEnd = row-1;
        int yEnd = col-1;
        while(xStart < xEnd)
        {
            int time = yEnd - yStart; //确定循环的次数
            for(int i = 0; i < time; i++) //这样每次i都能从0开始
            {
                int temp = matrix[xStart][yStart+i];
                matrix[xStart][yStart+i] = matrix[xEnd-i][yStart];
                matrix[xEnd-i][yStart] = matrix[xEnd][yEnd-i];
                matrix[xEnd][yEnd-i] = matrix[xStart+i][yEnd];
                matrix[xStart+i][yEnd] = temp;
            }
            xStart++;
            yStart++;
            xEnd--;
            yEnd--;
        }
    }
}
