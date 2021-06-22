package leetcode.Offer;
/**
 * @Author Yang
 * @Date 2021/5/11 9:30
 * @Description 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动.
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19.
 * 思路：常规的递归算法， 但是这里是不走回头路所以不需要回溯。
 */
public class movingCount {
    public static int result = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        search(m, n, 0, 0, k, used);
        return result;
    }

    private void search(int m, int n, int i, int j, int k, boolean[][] used) {
        if(i < 0 || i == m || j < 0 || j == n || used[i][j] || i % 10 + i / 10 + j % 10 + j / 10 > k){
            return;
        }
        used[i][j] = true;
        result++;
        search(m, n, i+1, j, k, used);
        search(m, n, i, j+1, k ,used);
    }
}
