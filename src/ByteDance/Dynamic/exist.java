package ByteDance.Dynamic;

import sun.util.resources.cldr.ewo.CurrencyNames_ewo;
import sun.util.resources.cldr.sbp.CurrencyNames_sbp;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 */
public class exist {
    public static void main(String[] args)
    {
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        //char[][] board = new char[][]{{'A'}};
        String word = "AAB";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word)
    {
        if(board == null || board.length == 0 || word == null)
            return false;
        char[] chars = word.toCharArray();
        int index = 0;
        int row = board.length - 1;
        int col = board[0].length - 1;
        boolean[][] isVisited = new boolean[row+1][col+1];
        for(int i = 0; i <= row; i++)
        {
            for(int j = 0; j <= col; j++)
            {
                if(board[i][j] == chars[index])
                {
                    if( bfs(board,i,j,isVisited,word,index))
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean bfs(char[][] board, int i, int j, boolean[][] isVisited, String word, int index)
    {
        if(index == word.length())
            return true;
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || isVisited[i][j] == true || board[i][j] != word.charAt(index))
            return false;
        isVisited[i][j] = true;
        boolean res = bfs(board, i-1,j,isVisited,word,index+1)||bfs(board,i+1,j,isVisited,word,index+1)||bfs(board,i,j+1,isVisited,word,index+1) || bfs(board,i,j-1,isVisited,word,index+1);
        //查找完成之后，初始化。
        isVisited[i][j] = false;
        return res;
    }
}
