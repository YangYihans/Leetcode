package leetcode.Array;
/*
289.生命游戏
 */
public class gameOfLifeTest289 {
    public static void main(String[] args) {
        gameOfLifeTest289 t1 = new gameOfLifeTest289();
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        t1.gameOfLife(board);
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void gameOfLife(int[][] board) {
        int row = board.length;
        if (row == 0 || board == null)
            return;
        int col = board[0].length;
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                search(board, i, j, temp);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
    public void search(int[][] board, int i, int j, int[][]temp)
    {
        int nums = 0;
        //下
        if(i < board.length-1 && board[i+1][j] == 1)
            nums++;
        //上
        if(i > 0 && board[i-1][j] == 1)
            nums++;
        //左
        if(j > 0 && board[i][j-1] ==1)
            nums++;
        //右
        if(j < board[0].length-1 && board[i][j+1] == 1)
            nums++;
        //左上
        if(i > 0 && j > 0 && board[i-1][j-1] == 1)
            nums++;
        //右上
        if(i > 0 && j < board[0].length-1 && board[i-1][j+1] == 1)
            nums++;
        //左下
        if(i < board.length-1 && j > 0 && board[i+1][j-1] == 1)
            nums++;
        //右下
        if(i < board.length-1 && j < board[0].length-1 && board[i+1][j+1] == 1)
            nums++;
        if(board[i][j] == 1 && nums < 2)
            temp[i][j] = 0;
        else if(board[i][j] == 1 &&(nums == 2 || nums == 3))
            temp[i][j] = 1;
        else if(board[i][j] == 1 && nums > 3)
            temp[i][j] = 0;
        else if(board[i][j] == 0 && nums == 3)
            temp[i][j] = 1;
        else
            temp[i][j] = 0;

    }

}
