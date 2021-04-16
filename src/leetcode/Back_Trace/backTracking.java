import com.sun.org.apache.xml.internal.utils.StringToIntTable;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 回溯的基本思想：
 * * 核心： 画图， 画出每个一支路，然后看哪里需要剪枝，考虑剪枝的条件。
 *
 * * 迭代终止条件： 可能是深度(depth)， 可能是数组的长度(nums.length)，可能是一个目标数(target).
 *
 * * 剪枝的基本思想：
 * * * 核心是画图看哪里需要剪枝，找到共同的规律。
 * * * 如果是不能使用重复的元素， 使用布尔类型的used数组进行剪枝.
 * * * 如果是前面的结果集会对后面的结果集造成重复， 使用开始指针 start来确定每次遍历的起始点。———— 一直向后， 就取不到前面的元素。
 * * * 有时候这两个会混合使用
 *
 * * add path的时机
 * * * 根据支路完结的条件进行判断， 比如depth达到， length达到， target达到等。
 * * * 对于子集这类题直接添加即可。
 * * * add时候一定要add(new ArrayList<>(path)), 直接add(path) 得到的结果都是[][][][].
 *
 * 注意：用于计数和输出结果的static不要放在回溯的参数
 */
public class backTracking {
    HashMap<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return result;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        process("", 0, digits);
        return result;
    }
    public void process(String s, int index, String digit){
        if(index == digit.length()){
            result.add(s);
            return;
        }
        String temp = map.get(digit.charAt(index));
        for(int i = 0; i < temp.length(); i++){
            process(temp+temp.charAt(i), index+1, digit);
        }

    }

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
     * @Date 2020/12/8 14:53
     * @Description 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        if(len == 0){
            return result;
        }
        Arrays.sort(candidates);
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        tracking_target(candidates,0, len, target, path, result);
        return result;
    }
    /**
     * @Author Yang
     * @Date 2020/12/8 15:17
     * @Description 这里的为了去重没有使用used数组而是使用了start。
     * 没有使用used数组： 因为可以重复使用candidate中的的元素。
     * 但是产生了重复，因为这类题目是相同元素不计顺序，在搜索的时候就需要[按照某种顺序]进行搜索。
     * 具体做法：每次搜索的时候设置[下一轮搜索的起点]。
     * 前面的元素进行搜索的时候已经把后面的元素使用了，所以后面的元素在使用的时候只能使用还排在其后面的元素。
     */
    public void tracking_target(int[] candidates, int start, int len, int target, List<Integer> path, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < len; i++){
            if(candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            tracking_target(candidates, i, len, target-candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 组合总和II candidates 中的每个数字在每个组合中只能使用一次
     * @param candidates 传入的数组
     * @param start      开始遍历点
     * @param len        传入数组的长度
     * @param target     目标值
     * @param used       传入数组中的元素是否使用
     * @param path       每一条支路的栈
     * @param result     结果集
     */
    public void tracking_target_unique(int[] candidates, int start, int len, int target, boolean[] used, List<Integer> path, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < len; i++){
            /**
             * 每个数字在组合中只能使用一次， 使用used[i]进行降重，当前位置上的元素使用过了就不使用
             */
            if(!used[i]){
                /**
                 * 剪枝一：
                 * 数组是排序好的， 如果元素比target大，后面的也就没必要遍历了，
                 */
                if(candidates[i] > target){
                    break;
                }
                /**
                 * 剪枝二：
                 * 对于重复的元素，如果前后两个元素相同， 那么后面的元素为起始就可以直接剪去。
                 */
                if(i > 0 && !used[i-1] && candidates[i] == candidates[i-1]){
                    continue;
                }
                /**
                 * 后面就是回溯的基本模板
                 */
                path.add(candidates[i]);
                used[i] = true;
                tracking_target_unique(candidates, i, len, target - candidates[i], used, path, result);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * @Author Yang
     * @Date 2020/12/12 11:53
     * @Description 组合总和III
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     */
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        tracking_combination(n, k, 0, 1, path, result);
        return result;
    }

    public void tracking_combination(int n, int k, int depth, int start, List<Integer> path, List<List<Integer>>result){
        /**
         * 深度和target都满足的情况才添加
         */
        if(depth == k){
            if(n == 0){
                result.add(new ArrayList<>(path));
                return;
            }
            return;
        }
        // 1 - 9
        for(int i = start; i <= 9; i++){
            if(i > n){
                break;
            }
            path.add(i);
            tracking_combination(n-i, k, depth+1, i+1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * @Author Yang
     * @Date 2020/12/12 14:58
     * @Description 377.组合总数IV
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     */
    static int total_count = 0;
    public static int combinationSum4(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        tracking_sum(nums, target, 0);
        return total_count;
    }

    /**
     * 回溯法对target检索nums每个数字会超时，因为当数组有1而target又比较大时，dfs的规模太大。--- 超时
     * 组合类问题都可以使用[动态规划]，即根据最后一次选取的状态递推到当前状态
     */
    public static void tracking_sum(int[] nums, int target, int start){
        if(target == 0){
            total_count++;
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > target)
                break;
            tracking_sum(nums, target - nums[i], start);
        }
    }

    /**
     * 回溯法：自顶向下
     * 动态规划：自底向上
     */
    public int combinationSum4_dp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 这个值被其它状态参考，设置为 1 是合理的
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    /**
     * @Author Yang
     * @Date 2020/12/9 10:31
     * @Description 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */
    public List<List<Integer>> combine(int n, int k){
        if(k > n || k == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n+1];
        List<Integer> path = new ArrayList<>();
        tracking_number(n, k, 1, used, path, result);
        return result;
    }
    public void tracking_number(int n, int k, int start, boolean[] used, List<Integer> path, List<List<Integer>> result){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        /**
         * start 用于保证后面的分支和最初的分支不重复比如 [1,2] -> [2,1] 这种不重复。
         * 后面都不使用前面出现过的元素。
         * used确保数据的唯一性，不重复使用，
         */
        for(int i = start; i <= n; i++){
            if(!used[i]){
                path.add(i);
                used[i] = true;
                tracking_number(n, k, i, used, path, result);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * @Author Yang
     * @Date 2020/12/9 11:22
     * @Description 子集， 输出全部子集
     */
    public List<List<Integer>> subsets(int[] nums){
        if(nums == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path =  new ArrayList<>();
        /**
         * 剪枝的基础 是排序
         */
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        tracking_subsets_unique(nums, 0, used, path, result);
        return result;
    }
    public void tracking_subsets(int[] nums, int start, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            /**
             * i+1 进行递归，否则会卡在当前循环
             */
            tracking_subsets(nums, i+1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * @Author Yang
     * @Date 2020/12/9 11:44
     * @Description 解集不能包含重复的子集。
     */
    public void tracking_subsets_unique(int[] nums, int start, boolean[] used, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            tracking_subsets_unique(nums, i+1, used, path, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
    
    /**
     * @Author Yang
     * @Date 2020/12/10 10:35
     * @Description 排列序列
     * 将序列按从小到大排序，返回第k个排列
     * 用于计数和输出结果的static不要放在回溯的参数中
     */
    static int count = 0;
    static String ans = "";
    public static String getPermutation(int n, int k){
        String path ="";
        boolean[] used = new boolean[n+1];
        tracking_permutation(n, k, 0, used, path);
        return ans;
    }
    public static void tracking_permutation(int n, int k, int depth, boolean[] used, String path){
        if(depth == n){
            count++;
            if(count == k){
                ans = path;
            }
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!used[i]){
                path += i;
                used[i] = true;
                tracking_permutation(n, k, depth+1, used, path);
                used[i] = false;
                path = path.substring(0,path.length() - 1);
            }
        }
    }

    /**
     * @Author Yang
     * @Date 2020/12/13 10:57
     * @Description 面试08.08 有重复字符串的组合
     * 和排列组合II 属于同一个类型， 需要注意的是list<String>转换为String[].
     */
    public String[] permutation(String S){
        List<String> list = new ArrayList<>();
        if(S == null){
            return new String[]{};
        }
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        int len = chars.length;
        boolean[] used = new boolean[len];
        String path = "";
        tracking_permutation(chars, len, used, path, list);
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
    public void tracking_permutation(char[] chars, int len, boolean[] used, String path, List<String> list){
        if(path.length() == len){
            list.add(new String(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && !used[i-1] && chars[i-1] == chars[i]){
                continue;
            }
            path += chars[i];
            used[i] = true;
            tracking_permutation(chars, len, used, path, list);
            used[i] = false;
            path = path.substring(0, path.length() - 1);
        }
    }

    /**
     * 类型二：
     * Flood 是「洪水」的意思，Flood Fill 直译是「泛洪填充」的意思，体现了洪水能够从一点开始，迅速填满当前位置附近的地势低的区域。
     *
     */
    /**
     * @Author Yang
     * @Date 2020/12/11 10:50
     * @Description 岛屿问题
     * 求岛屿的数量
     * 深度优先遍历
     */

    public static int numIslands(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] used = new boolean[row][col];
        int island_count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !used[i][j]){
                    track_island(grid, row, col, i, j, used);
                    island_count++;
                }
            }
        }
        return island_count;
    }
    public static void track_island(char[][] grid, int row, int col, int i, int j, boolean[][] used){
        /**
         * used数组用于去重，grid数组的判断条件是 grid[i][j] == '0'
         */
        if(i < 0 || j < 0 || i == row || j == col || used[i][j] == true || grid[i][j] == '0'){
            return;
        }
        used[i][j] = true;
        track_island(grid, row, col, i-1, j, used);
        track_island(grid, row, col, i+1, j, used);
        track_island(grid, row, col, i, j-1, used);
        track_island(grid, row, col, i,j+1, used);
    }

    /**
     * @Author Yang
     * @Date 2020/12/11 12:11
     * @Description 130.被包围的区域
     */
    public void solve(char[][] board){
        if(board == null || board.length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O' && (i == 0 || i == row -1 || j == 0 || j == col -1)){
                    track_board(board, row, col, i, j);
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] != 'A'){
                    board[i][j] = 'X';
                }else{
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }


    public void track_board(char[][] board, int row, int col, int i, int j){
        /**
         * 有值的改变的时候，board的判断条件就不能写成 board[i][j] == 'X'了
         * 因为这时还有A的存在。
         */
        if(i < 0 || j < 0 || i == row || j == col || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'A';
        track_board(board, row, col, i-1, j);
        track_board(board, row, col, i+1, j);
        track_board(board, row, col, i, j-1);
        track_board(board, row, col, i, j+1);
    }

    /**
     * @Author Yang
     * @Date 2020/12/11 12:33
     * @Description 单词搜索
     */
    boolean flag = false;
    public boolean exist(char[][] board, String word){
        if(board == null || word == null)
            return false;
        char[] chars = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        boolean[][] used = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == chars[0]){
                    tracking_exist(board, chars, used, row, col, i, j, 0);
                    if(flag)
                        return true;
                }
            }
        }
        return false;
    }

    public void tracking_exist(char[][] board, char[]chars, boolean[][] used, int row, int col, int i, int j, int depth){
        if(i < 0 || j < 0 || i == row || j == col || used[i][j] || board[i][j] != chars[depth]){
            return;
        }
        if(depth == chars.length - 1){
            flag = true;
            return;
        }
        used[i][j] = true;
        tracking_exist(board, chars, used, row, col, i-1, j, depth+1);
        tracking_exist(board, chars, used, row, col, i+1, j, depth+1);
        tracking_exist(board, chars, used, row, col, i, j-1, depth+1);
        tracking_exist(board, chars, used, row, col, i, j+1, depth+1);
        used[i][j] = false;
        return;
    }

    /**
     * @Author Yang
     * @Date 2020/12/12 10:28
     * @Description 784.字母大小写全排列
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合
     * 思路： 和子集的思路相同
     */
    public List<String> letterCasePermutation(String S){
        List<String> result = new ArrayList<>();
        if(S == null || S.length() == 0)
            return result;
        char[] chars = S.toCharArray();
        int len = chars.length;
        tracking_letter(chars, 0, len, result);
        return result;
    }
    public void tracking_letter(char[] chars, int index, int len, List<String> result){
        if(index == len){
            result.add(new String(chars));
            return;
        }
        tracking_letter(chars, index+1, len, result);
        if(Character.isLetter(chars[index])){
            /**
             * 如果是小写字符，减去32得到大写字符。
             * 如果是大写字符，加上32得到小写字符。
             * 可以使用 异或 1<<5 的方法得到
             */
            chars[index] ^= 1 << 5;
            tracking_letter(chars, index+1, len, result);
        }
        return;
    }
    
    /**
     * @Author Yang
     * @Date 2020/12/12 11:17
     * @Description 22.括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        if(n == 0)
            return result;
        int left_count = n;
        int right_count = n;
        String path = "";
        tracking_generate(left_count, right_count, path, result);
        return result;
    }
    public static void tracking_generate(int left_count, int right_count, String path, List<String> result){
        if(left_count == 0 && right_count == 0){
            result.add(new String(path));
            return;
        }
        if(left_count > right_count){
            return;
        }
        if(left_count > 0){
            tracking_generate(left_count - 1, right_count, path+"(", result);
        }
        if(right_count > 0){
            tracking_generate(left_count, right_count - 1, path+")", result);
        }
    }

    public static int total_possible_count = 0;   // 全局变量， 记录所有组合次数
    public static int getPossibleCount(int m, int n, int s){
        tracking_getCount(m, n, s,0, 1);  // 递归初始条件
        return total_possible_count;
    }

    // 取值1-m, 个数=n, 目标是s.
    public static void tracking_getCount(int m, int n, int target, int depth, int start){
        if(depth == n){
            if(target == 0){  // 满足条件 n个数 target = s
                total_possible_count++;
                return;
            }
            return;
        }
        for(int i = start; i <= m; i++){
            if(i > target){  // 剪枝, 比target大就直接丢弃
                break;
            }
            /**
             * target = target - i；  每一轮target减少i，
             * depth = depth + 1；    每一轮深度加1
             * start = i + 1；        每一轮开始点从i+1开始，避免重复
             */
            tracking_getCount(m, n, target-i, depth+1, i+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getPossibleCount(9,3,7));

    }
}
