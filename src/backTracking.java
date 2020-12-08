import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
                 * 这样在考虑下一个位置的时候，就能够以 O(1)O(1) 的时间复杂度判断这个数是否被选择过，这是一种「以空间换时间」的思想。
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
}
