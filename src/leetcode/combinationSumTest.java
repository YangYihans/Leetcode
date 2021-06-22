package leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
力扣39.组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class combinationSumTest {
    List<List<Integer>> lists = new ArrayList<>();
    public static void main(String [] args)
    {
        combinationSumTest t1 = new combinationSumTest();
        int [] t = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(t1.combinationSum(t,target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        if(candidates == null || candidates.length == 0)
        {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        process(0, candidates, target, list); //去重复 start
        return lists;
    }
    public void process(int start, int[] candidates, int target, List<Integer> list)
    {
        if(target < 0)
            return;
        if(target == 0)
            lists.add(new ArrayList<>(list));
        else
        {
            int j = start;
            for(int i = start; i < candidates.length; i++)
            {
                if(i>start && candidates[i]==candidates[i-1])
                    continue;
                list.add(candidates[i]);
                process(++i, candidates, target-candidates[i], list);
                list.remove(list.size()-1);
            }
        }
    }
}
