package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/4/29 17:40
 * @Description 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class findNumberIn2DArray_04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int i = 0, j = col;
        while(i <= row && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
