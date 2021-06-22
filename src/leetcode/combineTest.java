package leetcode;
/*
力扣77题：组合
给定两个整数n和k，返回1-n中所有可能的k个数的组合
思路：使用递归的方式求解
 */
import java.util.ArrayList;
import java.util.List;

public class combineTest {
    public static void main(String[] args) {
        combineTest t1 = new combineTest();
        System.out.println(t1.combine(3,3));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k)
    {
        if(n<=0 || k<=0 || n<k)
            return res;
        backTrack(n,k,1,temp);
        return res;
    }
    public void backTrack(int n, int k, int begin, List<Integer> temp)
    {
        if(temp.size() == k)
        {
            res.add(new ArrayList<>(temp)); //key
            return;
        }
        for(int i = begin; i <= n; i++)
        {
            temp.add(i);
            backTrack(n,k,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
