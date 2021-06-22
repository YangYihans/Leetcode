package leetcode.Depth_First_Search;

public class solveTest130 {
    public static void main(String[] args) {
        solveTest130 t1 = new solveTest130();
    }
    public void solve(char[][] board)
    {
        int m = board.length;
        if(m == 0)
            return;
        int n = board[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if((i == 0 || i == m-1 || j == 0 || j == n-1)&& board[i][j] == 'O')
                {
                    board[i][j] = '*';
                    seedSearch(board,i-1,j);
                    seedSearch(board,i,j-1);
                    seedSearch(board,i+1,j);
                    seedSearch(board,i,j+1);
                }
            }
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == '*')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    public void seedSearch(char[][] board, int x, int y)
    {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return;
        if(board[x][y] == 'O')
        {
            board[x][y] = '*';
            seedSearch(board, x-1, y); //上
            seedSearch(board,x,y-1); //左
            seedSearch(board,x+1,y);//下
            seedSearch(board,x,y+1); //右
        }
    }
}
