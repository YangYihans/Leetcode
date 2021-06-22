package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numWaysTest {
    public static void main(String[] args) {
        numWaysTest t1 = new numWaysTest();
        //int [][] relation = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int [][] relation = new int[][]{{0,2},{2,1}};
        System.out.println(t1.numWays(3,relation,2));
    }
    List<List<Integer>> lists = new ArrayList<>();
    public int numWays(int n, int[][] relation, int k)
    {
        Arrays.sort(relation,(o1,o2)->o1[0]-o2[0]);
        int search = 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int index = 0;
        process(lists,list,relation,k,n,index);
        res = lists.size();
        return res;
    }
    public void process(List<List<Integer>>lists, List<Integer> list, int[][] relation, int k , int n,int index)
    {
        int flag = 1;
        if(list.size() == k+1 && list.get(k) == n-1)
        {
            lists.add(new ArrayList<>(list));
            return;
        }
        else
        {
            for(int i = 0 ; i < relation.length; i++)
            {
                if(relation[i][0] == list.get(index) && index<=k)
                {
                    flag = 1;
                    list.add(relation[i][1]);
                    process(lists,list,relation,k,n,index+1);
                    list.remove(list.size()-1);
                }

            }

        }
    }
}
