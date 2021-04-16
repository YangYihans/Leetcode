package leetcode.Back_Trace.subSet;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author Yang
 * @Date 2021/4/16 21:57
 * @Description 78. 子集
 * 子集问题，直接add path
 */
public class subset {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        track_back(res, path, nums, 0);
        return res;
    }

    private static void track_back(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            track_back(res, path, nums, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

}
