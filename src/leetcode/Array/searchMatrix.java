package leetcode.Array;
/**
 * @Author Yang
 * @Date 2021/3/30 10:25
 * @Description 74.搜索二维数组
 */
public class searchMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while(i >= 0 && i < row && j <= col-1 && j >= 0){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
