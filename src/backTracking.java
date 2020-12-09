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
}
