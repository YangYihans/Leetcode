package leetcode.Back_Trace.combination;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/16 22:36
 * @Description 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 解集不能包含重复的组合。
 * start = i 用来去除重复的组合
 */
public class combinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        track_back(res, path, candidates, 0, target);
        return res;
    }

    private static void track_back(List<List<Integer>> res, List<Integer> path, int[] candidates, int start, int target) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            track_back(res, path, candidates,i,target-candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
    }
}
