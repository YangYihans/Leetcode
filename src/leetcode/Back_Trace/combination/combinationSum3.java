package leetcode.Back_Trace.combination;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/16 23:02
 * @Description 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class combinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        track_back(res, path, k, n, 1, 0);
        return res;
    }

    private static void track_back(List<List<Integer>> res, List<Integer> path, int k, int n, int start, int depth) {
        if(n == 0 && depth == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= 9; i++){
            if(i > n){
                break;
            }
            path.add(i);
            track_back(res, path, k, n - i, i + 1,  depth + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum3(3,9);
    }
}
