package leetcode.Back_Trace.permute;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author Yang
 * @Date 2021/4/16 16:32
 * @Description 回溯的基础问题：全排列问题
 */
public class permute {
    /**
     * @Author Yang
     * @Date 2020/12/8 11:14
     * @Description 全排列
     * 一个没有重复数字的序列，对它进行全排列
     */
    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(len == 0)
            return result;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        tracking(nums, len, 0, path, used, result);
        return result;
    }
    public void tracking(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>>result){
        if(len == depth){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(!used[i]){
                path.add(nums[i]);
                /**
                 * 这样在考虑下一个位置的时候，就能够以 O(1) 的时间复杂度判断这个数是否被选择过，这是一种「以空间换时间」的思想。
                 */
                used[i] = true;
                tracking(nums, len, depth+1, path, used, result);
                /**
                 * 状态重置
                 * 在回头之后，状态变量需要设置和先前的一样，因此在回到上一层节点的时候，需要撤销上一次的选择。
                 *
                 * 从深层节点到浅层节点的过程，代码形式上和递归之前的是对称的。
                 */
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * @Author Yang
     * @Date 2020/12/8 12:21
     * @Description 含有重复数字的全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(len == 0){
            return result;
        }
        /**
         * 排序是剪枝的基础
         */
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        tracking_unique(nums, len, 0, used, path, result);
        return result;
    }
    public void tracking_unique(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> result){
        if(len == depth){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(used[i])
                continue;
            /**
             * 剪枝
             */
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            tracking_unique(nums, len, depth + 1, used, path, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    /**
     * @Author Yang
     * @Date 2021/4/16 17:08
     * @Description 51. N 皇后
     */
    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        char[][] chessboard = new char[n][n];
        for (char[] line : chessboard)
            Arrays.fill(line, '.');
        backTrack(chessboard, n, 0);
        return res;
    }

    private static void backTrack(char[][] chessboard, int n, int row) {
        if (row == chessboard.length) {
            //将整副棋盘copy进res
            List<String> copyBoard = new ArrayList<>();
            for (char[] line : chessboard) {
                copyBoard.add(String.valueOf(line));
            }
            res.add(copyBoard);
            return;
        }

        //(1)遍历每个棋子位
        for (int col = 0; col < n; col++) {
            //(2)判断该棋位下'Q'是否合法
            if (!isValid(chessboard, n, row, col))
                continue;

            //(3)回溯
            chessboard[row][col] = 'Q';
            backTrack(chessboard, n, row + 1);
            chessboard[row][col] = '.';

        }
    }

    //判断皇后落子是否合格：判断行(无需判断)、列、左上与右上
    private static boolean isValid(char[][] chessboard, int n, int row, int col) {
        //判断列是否存在皇后
        for (int r = 0; r < n; r++) {
            if (chessboard[r][col] == 'Q')
                return false;
        }

        //判断右上方（斜线）是否存在皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }

        //判断左上方（斜线）是否存在皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j] == 'Q')
                return false;

        //到此说明皇后落子合格
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
