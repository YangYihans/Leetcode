package Baidu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        int[] a = new int[56];
        int[][][] dp = new int[56][56][56];
        double[][] C = new double[56][56];
        C[0][0] = 1.0;
        for(int i = 1; i <= 55; i++){
            C[i][0] = 1.0;
            for(int j = 1; j <= i; j++){
                C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }
        for(int i = 1; i <= m; i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i <= n; i++){
            dp[0][0][i] = i;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                for(int k = 0; k <= n; k++){
                    for(int c = 0; c <= j; c++){
                        int max = Math.max(k, (c + a[i]-1)/a[i]);
                        dp[i][j][k] += dp[i-1][j-c][max] * Math.pow(i-1, j-c) / Math.pow(i,j) * C[j][c];
                    }
                }
            }
        }
        System.out.println(dp[m][n][0]);
    }
}
