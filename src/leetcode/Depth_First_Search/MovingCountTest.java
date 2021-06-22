package leetcode.Depth_First_Search;
/*
力扣面试13：机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？
 */
public class MovingCountTest {
    public static void main(String[] args) {
        MovingCountTest t1 = new MovingCountTest();
        System.out.println(t1.movingCount(2,3,1));
    }
    public int movingCount(int m, int n, int k)
    {
        boolean[][] visited = new boolean[m][n]; //标记是否参观完成的数组
        return search(0,0,m,n,k,visited);

    }

    private int search(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(i < 0 || i == m || j < 0 || j == n || i % 10 + i / 10 + j % 10 + j / 10 > k || visited[i][j] == true)
            return 0;
        visited[i][j] = true;
        return  1 + search(i+1, j, m, n, k, visited) + search(i-1, j, m, n, k, visited) + search(i, j-1, m, n, k, visited) + search(i, j+1, m, n, k, visited);
    }


}
