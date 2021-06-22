package leetcode.Back_Trace.combination;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/16 22:20
 * @Description 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 套用递归的模板，应该指定start，避免取到重复值。
 */
public class combine {
    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(k > n || k == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        track_back(res, path, n, k, 1, 0);
        return res;
    }

    private static void track_back(List<List<Integer>> res, List<Integer> path, int n, int k, int start, int depth) {
        if(depth == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++){
            path.add(i);
            track_back(res, path, n, k, i+1, depth+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
