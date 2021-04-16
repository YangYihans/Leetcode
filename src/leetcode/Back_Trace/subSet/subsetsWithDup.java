package leetcode.Back_Trace.subSet;
import org.omg.CORBA.INTERNAL;

import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/16 21:58
 * @Description 90. 子集 II
 * 含有重复字符的子集
 * 排序是去重的基础。
 */
public class subsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        track_back(res, path, nums, used, 0);
        return res;
    }

    private static void track_back(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used, int start) {
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            track_back(res, path, nums, used, i+1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2});
    }
}
