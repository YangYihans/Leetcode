package leetcode;

import java.util.ArrayList;
import java.util.List;

public class subsetsTest {
    public static void main(String[] args) {
        subsetsTest t1 = new subsetsTest();
        int [] a = new int[]{1,2,3};
        System.out.println(t1.subsets(a));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums)
    {
        int n = nums.length;
        if(n == 0)
            return res;
       /* if(n == 1)
        {
            temp.add(nums[0]);
            res.add(new ArrayList<>(temp));
            return res;
        }*/
        backtracking(n,nums,0,1,temp);
        return res;
    }
    public void backtracking(int n, int[] nums, int begin, int len, List<Integer> temp)
    {
        res.add(new ArrayList<>(temp));
        for(int i = begin; i < n; i++)
        {
            temp.add(nums[i]);
            backtracking(n,nums,i+1,len,temp);
            temp.remove(temp.size()-1);
        }

    }
}
