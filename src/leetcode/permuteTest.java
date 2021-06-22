package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
46.全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class permuteTest {
    List<List<Integer>> lists = new ArrayList<>();
    public static void main(String [] args)
    {
        permuteTest t1 = new permuteTest();
        int [] a = new int[]{3,1,3};
        System.out.println(t1.permute(a));
    }
    public List<List<Integer>> permute(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        process(lists,list,nums,0);
        return lists;
    }

    //包含重复数字的全排列组合
    /*public void process(List<List<Integer>>lists, List<Integer>list, int[] nums)
    {
        if(list.size() == nums.length)
            lists.add(new ArrayList<>(list));
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(list.contains(nums[i]))
                    continue;
                list.add(nums[i]); //已经添加了的就不比较 ，没有的就继续添加
                process(lists,list,nums);
                list.remove(list.size()-1);
            }
        }
    }*/

    //不包含重复数字的全排列组合
    public void process(List<List<Integer>> lists, List<Integer> list, int[] nums,int start)
    {
        if(list.size() == nums.length)
            lists.add(new ArrayList<>(list));
        else
        {
            for(int i = start; i < nums.length; i++)
            {
                
                list.add(nums[i]);
                process(lists,list,nums,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
