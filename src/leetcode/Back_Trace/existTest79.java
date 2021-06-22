package leetcode.Back_Trace;

public class existTest79 {
    public static void main(String[] args) {
        existTest79 t1 = new existTest79();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(t1.exist(board,"SEE"));
    }
    int[][] flag = new int[400][400];
    public boolean exist(char[][] board, String word)
    {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                //int[][] flag = new int[400][400];
                if(board[i][j] == word.charAt(0))
                {
                    flag[i][j] = 1;
                    if(trace_back(board,word,1,i,j))
                        return true;
                }
                else
                    continue;
            }
        }
        return false;
    }
    public boolean trace_back(char[][] board, String word, int index, int i, int j)
    {
        if(index == word.length())
            return true;
        if(i >= 1 && board[i-1][j] == word.charAt(index) && flag[i-1][j] == 0)
        {
            flag[i-1][j] = 1;
            if(trace_back(board,word,index+1,i-1,j))
                return true;
        }
        if(i+1 < board.length && board[i+1][j] == word.charAt(index) && flag[i+1][j] == 0)
        {
            flag[i+1][j] = 1;
            if(trace_back(board,word,index+1,i+1,j))
                return true;
        }
        if(j >= 1 && board[i][j-1] == word.charAt(index) && flag[i][j-1] == 0)
        {
            flag[i][j-1] = 1;
            if(trace_back(board,word,index+1,i,j-1))
                return true;
        }
        if(j+1 < board[0].length && board[i][j+1] == word.charAt(index) && flag[i][j+1] == 0)
        {
            flag[i][j+1] = 1;
            if(trace_back(board,word,index+1,i,j+1))
                return true;
        }
        flag[i][j] = 0;
        return false;
    }
}
