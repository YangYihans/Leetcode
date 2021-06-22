package leetcode.Array;

import java.util.*;

public class rotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = scanner.nextInt();
            }
        }

        int row_start = 0, row_end = n - 1, col_start = 0, col_end = m - 1;
        while(row_start <= row_end){
            for(int i = row_start; i <= row_end; i++){
                System.out.print(nums[i][col_start] + " ");
            }
            col_start++;
            if(col_start > col_end){
                break;
            }
            for(int j = col_start; j <= col_end; j++){
                System.out.print(nums[row_end][j] + " ");
            }
            row_end--;
            if(row_end < row_start){
                break;
            }
            for(int i = row_end; i >= row_start; i--){
                System.out.print(nums[i][col_end]+ " ");
            }
            col_end--;
            if(col_end < col_start){
                break;
            }
            for(int j = col_end; j >= col_start; j--){
                System.out.print(nums[row_start][j] + " ");
            }
            row_start++;
        }
    }
}
