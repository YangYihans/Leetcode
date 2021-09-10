package Baidu;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Q4 {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 'F' && !used[i][j]){
                    dfs(grid, i, j, used);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j, boolean[][] used){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 'F' || used[i][j]){
            return;
        }
        used[i][j] = true;
        dfs(grid, i-1, j, used);
        dfs(grid, i+1, j, used);
        dfs(grid, i, j-1, used);
        dfs(grid, i, j+1, used);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);
        char[][] grid = new char[row][col];
        for(int i = 0; i < row; i++){
            char[] c = sc.nextLine().toCharArray();
            if (col >= 0) System.arraycopy(c, 0, grid[i], 0, col);
        }
        System.out.println(numIslands(grid));
    }


}
