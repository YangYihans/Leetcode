package leetcode.Back_Trace.combination;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/16 22:47
 * @Description 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class combinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[len];
        track_back(res, path, candidates, used,0, target);
        return res;
    }

    private static void track_back(List<List<Integer>> res, List<Integer> path, int[] candidates, boolean[] used, int start, int target) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            // !used[i-1] 对于同一个树枝的 used[i-1] = true, 对于不同树枝的 used[i-1] = false;
            // 这个就是针对重复的数组，可以在一条支路上使用重复的数字(不是同一个位置上的数字使用多次)，但是在又要保持结果集唯一的情况
            if(i >= 1 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            path.add(candidates[i]);
            used[i] = true;
            track_back(res, path, candidates, used, i + 1, target - candidates[i]);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
