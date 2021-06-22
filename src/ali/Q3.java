package ali;


import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int q = Integer.parseInt(s[2]);
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] temp = scanner.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                nums[i][j] = Integer.parseInt(temp[j]);
            }
        }
        for(int i = 0; i < q; i++){
            String[] op = scanner.nextLine().split(" ");
            int row = Integer.parseInt(op[0]) - 1;
            int col = Integer.parseInt(op[1]) - 1;
            process(nums, row, col);
        }
    }

    public static void process(int[][] nums, int row, int col){
        if(nums[row][col] == 0){
            nums[row][col] = 1;
        }else{
            nums[row][col] = 0;
        }
        int sum = 0;
        int temp = 0;
        for(int j = 0; j < nums[0].length; j++){
            if(nums[row][j] == 1){
                temp++;
            }else if(nums[row][j] == 0){
                temp = 0;
            }
            sum = Math.max(temp, sum);
        }
        System.out.println(sum);
    }
}
