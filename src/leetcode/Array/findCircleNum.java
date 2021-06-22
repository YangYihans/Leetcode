package leetcode.Array;

public class findCircleNum {
    public static void main(String[] args) {

    }
    public static int findCircleNum(int[][] M)
    {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(M, i, visited);
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for(int j = 0; j < M.length; j++)
        {
            if(!visited[j] && M[i][j] == 1)
                dfs(M, j, visited);
        }
    }
}
