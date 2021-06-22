package leetcode;
/*
999.车的可用捕获量
在一个 8 x 8 的棋盘上，有一个白色车（rook）。
也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
它们分别以字符 “R”，“.”，“B” 和 “p” 给出。
大写字符表示白棋，小写字符表示黑棋。
车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、
到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
另外，车不能与其他友方（白色）象进入同一个方格。
返回车能够在一次移动中捕获到的卒的数量。
 */
public class numRookCaptureTest999 {
    public static void main(String[] args) {
        numRookCaptureTest999 t1 = new numRookCaptureTest999();
    }
    public int numRookCaptures(char[][] board)
    {
        int row = board.length;
        if(row == 0)
            return 0;
        int col = board[0].length;
        int res = 0;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(board[i][j] == 'R')
                {
                    res = findNum(board, i, j);
                }
            }
        }
        return  res;
    }
    public int findNum(char[][] board, int i, int j)
    {
        int sum = 0;
        for(int x = i; x < board.length; x++)
        {
            if(board[x][j] == 'B')
                break;
            if(board[x][j] == 'p')
            {
                sum++;
                break;
            }
        }
        for(int x = i; x >= 0; x--)
        {
            if(board[x][j] == 'B')
                break;
            if(board[x][j] == 'p')
            {
                sum++;
                break;
            }
        }
        for(int y = j; y < board[0].length; y++)
        {
            if(board[i][y] == 'B')
                break;
            if(board[i][y] == 'p')
            {
                sum++;
                break;
            }
        }
        for(int y = j; y >= 0; y--)
        {
            if(board[i][y] == 'B')
                break;
            if(board[i][y] == 'p')
            {
                sum++;
                break;
            }
        }
        return sum;
    }

}
