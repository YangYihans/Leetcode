package leetcode.Offer;
import java.util.*;
public class spiralOrder_29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[]{};
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int row_start = 0, col_start = 0, row_end = row - 1, col_end = col - 1;
        List<Integer> list = new ArrayList<>();
        while(row_start <= row_end){
            for(int j = col_start; j <= col_end; j++){
                list.add(matrix[row_start][j]);
            }
            row_start++;
            if(row_start > row_end){
                break;
            }
            for(int i = row_start; i <= row_end; i++){
                list.add(matrix[i][col_end]);
            }
            col_end--;
            if(col_start > col_end){
                break;
            }
            for(int j = col_end; j >= col_start; j--){
                list.add(matrix[row_end][j]);
            }
            row_end--;
            if(row_end < row_start){
                break;
            }
            for(int i = row_end; i >= row_start; i--){
                list.add(matrix[i][col_start]);
            }
            col_start++;
            if(col_start > col_end){
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
